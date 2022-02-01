package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.b;
import com.tencent.mm.plugin.gallery.model.s.c;
import com.tencent.mm.plugin.gallery.model.s.d;
import com.tencent.mm.plugin.gallery.model.s.f;
import com.tencent.mm.plugin.gallery.model.s.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SmartGalleryUI
  extends MMActivity
{
  public static int tPR = 1;
  private int kTx;
  private ProgressDialog nZt;
  Button pOj;
  private String tGY;
  private RecyclerView tPF;
  private EditText tPG;
  private b tPH;
  private f tPI;
  private e tPJ;
  private h tPK;
  private int tPL;
  private boolean tPM;
  w tPN;
  private boolean tPO;
  c tPP;
  private boolean tPQ;
  
  public SmartGalleryUI()
  {
    AppMethodBeat.i(111703);
    this.tPM = false;
    this.tPO = true;
    this.tPP = new c()
    {
      public final void a(s.a paramAnonymousa)
      {
        AppMethodBeat.i(111677);
        ad.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", new Object[] { paramAnonymousa.tHF, paramAnonymousa.tGK });
        Intent localIntent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
        localIntent.putExtras(SmartGalleryUI.this.getIntent());
        localIntent.putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this));
        if (SmartGalleryUI.h(SmartGalleryUI.this)) {
          if ((paramAnonymousa.tHJ != null) && (paramAnonymousa.tHJ.tHK)) {
            localIntent.putExtra("select_type_tag", 1);
          }
        }
        try
        {
          while ((paramAnonymousa.tHE != null) && (paramAnonymousa.tHE.tHQ != null))
          {
            Object localObject = paramAnonymousa.tHE.tHQ;
            String str2 = "";
            if (paramAnonymousa.tGK != null) {
              str2 = paramAnonymousa.tGK;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(18269, new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(str2, "utf-8") });
            localIntent.putExtra("is_from_smart_gallery", true);
            str2 = paramAnonymousa.tGK;
            localObject = str2;
            if (bt.isNullOrNil(str2)) {
              localObject = paramAnonymousa.tHE.tHQ;
            }
            localIntent.putExtra("title_from_smart_gallery", (String)localObject);
            localIntent.putExtra("album_id_from_smart_gallery", paramAnonymousa.tHF);
            SmartGalleryUI.this.startActivityForResult(localIntent, 1);
            AppMethodBeat.o(111677);
            return;
            localIntent.putExtra("select_type_tag", 0);
            continue;
            localIntent.putExtra("select_type_tag", 2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            continue;
            String str1 = "";
          }
        }
      }
    };
    this.tPQ = false;
    AppMethodBeat.o(111703);
  }
  
  private void cWq()
  {
    AppMethodBeat.i(111706);
    int i = s.cVx().cVB();
    if (i > 0) {
      this.pOj.setEnabled(true);
    }
    for (;;)
    {
      this.pOj.setText(d.a(this, this.kTx, i, this.tPL, this.tGY, null));
      AppMethodBeat.o(111706);
      return;
      this.pOj.setEnabled(false);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495474;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111707);
    ad.i("MicroMsg.SmartGalleryUI", "requestCode: %d, resultCode: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent != null)
    {
      this.tPQ = paramIntent.getBooleanExtra("send_raw_img", false);
      paramIntent.putExtra("send_raw_img", this.tPQ);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ad.i("MicroMsg.SmartGalleryUI", "key: %s, value: %s.", new Object[] { str, localBundle.get(str) });
        }
      }
    }
    if (1 == paramInt1)
    {
      if ((-2 == paramInt2) || (paramInt2 == 0))
      {
        ad.i("MicroMsg.SmartGalleryUI", "just back from AlbumPreviewUI.");
        cWq();
        AppMethodBeat.o(111707);
        return;
      }
      setResult(paramInt2, paramIntent);
      finish();
    }
    AppMethodBeat.o(111707);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(111704);
    super.onCreate(paramBundle);
    this.kTx = getIntent().getIntExtra("query_source_type", 3);
    this.tPL = getIntent().getIntExtra("max_select_count", 9);
    this.tGY = getIntent().getStringExtra("album_business_tag");
    this.tPQ = getIntent().getBooleanExtra("send_raw_img", false);
    this.nZt = p.a(this, getString(2131755936), true);
    this.nZt.show();
    setActionbarColor(getResources().getColor(2131100399));
    setNavigationbarColor(getResources().getColor(2131100399));
    paramBundle = LayoutInflater.from(this).inflate(2131492919, new LinearLayout(this), false);
    paramBundle.findViewById(2131304858).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111671);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (bt.ai(SmartGalleryUI.a(SmartGalleryUI.this).getText()))
        {
          SmartGalleryUI.this.setResult(-2, SmartGalleryUI.this.getIntent().putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this)));
          SmartGalleryUI.this.finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111671);
          return;
          SmartGalleryUI.a(SmartGalleryUI.this).setText("");
        }
      }
    });
    this.tPG = ((EditText)paramBundle.findViewById(2131304860));
    this.tPG.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111672);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (!SmartGalleryUI.c(SmartGalleryUI.this)) {
          SmartGalleryUI.a(SmartGalleryUI.this, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(111672);
        return false;
      }
    });
    this.tPG.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(111673);
        if (3 == paramAnonymousInt)
        {
          paramAnonymousTextView = paramAnonymousTextView.getText().toString();
          if (!bt.isNullOrNil(paramAnonymousTextView))
          {
            SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousTextView, true);
            AppMethodBeat.o(111673);
            return true;
          }
        }
        AppMethodBeat.o(111673);
        return false;
      }
    });
    this.tPG.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(111674);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        ad.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", new Object[] { paramAnonymousEditable });
        SmartGalleryUI.d(SmartGalleryUI.this).tQe = paramAnonymousEditable;
        if (bt.isNullOrNil(paramAnonymousEditable))
        {
          SmartGalleryUI.e(SmartGalleryUI.this);
          SmartGalleryUI.g(SmartGalleryUI.this).setAdapter(SmartGalleryUI.f(SmartGalleryUI.this));
          SmartGalleryUI.g(SmartGalleryUI.this).a(SmartGalleryUI.this.tPN);
          SmartGalleryUI.f(SmartGalleryUI.this).asY.notifyChanged();
          AppMethodBeat.o(111674);
          return;
        }
        SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousEditable, false);
        AppMethodBeat.o(111674);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.pOj = ((Button)paramBundle.findViewById(2131304861));
    cWq();
    this.pOj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111675);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SmartGalleryUI.this.setResult(SmartGalleryUI.tPR);
        SmartGalleryUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111675);
      }
    });
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      localActionBar.gm();
      localActionBar.setDisplayHomeAsUpEnabled(false);
      localActionBar.gl();
      localActionBar.gn();
      localActionBar.setCustomView(paramBundle);
    }
    for (;;)
    {
      this.tPN = new w(this);
      this.tPN.setDrawable(getResources().getDrawable(2131234071));
      this.tPF = ((RecyclerView)findViewById(2131304859));
      this.tPF.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(198789);
          b localb = new b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt1);
          localb.mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(198789);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111676);
          b localb = new b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          ad.d("MicroMsg.SmartGalleryUI", "onScrollStateChanged, newState: %d, mIsNeedReset: %s.", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(SmartGalleryUI.c(SmartGalleryUI.this)) });
          if ((1 == paramAnonymousInt) && (SmartGalleryUI.c(SmartGalleryUI.this)))
          {
            SmartGalleryUI.a(SmartGalleryUI.this, false);
            SmartGalleryUI.this.hideVKB();
            SmartGalleryUI.a(SmartGalleryUI.this).clearFocus();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(111676);
        }
      });
      this.tPF.a(this.tPN);
      this.tPH = new b(this);
      this.tPH.tPP = this.tPP;
      this.tPI = new f(this);
      this.tPI.tPP = this.tPP;
      this.tPF.setLayoutManager(new LinearLayoutManager());
      this.tPF.setAdapter(this.tPH);
      this.tPK = new h(this.tPF, this.tPI);
      this.tPJ = new e(this.tPK);
      e.cUN().al(new d(this.tPH, this.nZt, this.tPG));
      AppMethodBeat.o(111704);
      return;
      ad.e("MicroMsg.SmartGalleryUI", "actionbar is null.");
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(111710);
    super.onDestroy();
    s.cVx().cVA();
    AppMethodBeat.o(111710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111708);
    if ((4 == paramInt) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (bt.ai(this.tPG.getText()))
      {
        setResult(-2, getIntent().putExtra("send_raw_img", this.tPQ));
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(111708);
        return true;
        this.tPG.setText("");
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(111708);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(111709);
    super.onPause();
    this.tPG.clearFocus();
    AppMethodBeat.o(111709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111705);
    super.onResume();
    cWq();
    AppMethodBeat.o(111705);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends RecyclerView.a<a>
  {
    View.OnClickListener km;
    private Context mContext;
    private View.OnLongClickListener tLt;
    SmartGalleryUI.c tPP;
    List<s.a> tPT;
    private int tPU;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(111681);
      this.km = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111678);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.a.a(SmartGalleryUI.a.this) != null)) {
            SmartGalleryUI.a.a(SmartGalleryUI.a.this).a((s.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111678);
        }
      };
      this.tLt = new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111679);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView instanceof s.a))
          {
            paramAnonymousView = (s.a)paramAnonymousView;
            ((ClipboardManager)SmartGalleryUI.a.b(SmartGalleryUI.a.this).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("media info", paramAnonymousView.toString()));
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(111679);
          return true;
        }
      };
      this.mContext = paramContext;
      this.tPT = new ArrayList();
      this.tPU = ((this.mContext.getResources().getDisplayMetrics().widthPixels - aq.ay(this.mContext, 2131165289) - aq.ay(this.mContext, 2131165303) * 4) / 9 * 2);
      ad.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", new Object[] { Integer.valueOf(this.tPU) });
      AppMethodBeat.o(111681);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111682);
      int i = this.tPT.size();
      AppMethodBeat.o(111682);
      return i;
    }
    
    static final class a
      extends RecyclerView.w
    {
      ImageView tPW;
      TextView tPX;
      TextView tPY;
      
      a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(111680);
        this.tPW = ((ImageView)paramView.findViewById(2131296565));
        ViewGroup.LayoutParams localLayoutParams = this.tPW.getLayoutParams();
        localLayoutParams.width = paramInt;
        localLayoutParams.height = paramInt;
        this.tPW.setLayoutParams(localLayoutParams);
        this.tPX = ((TextView)paramView.findViewById(2131296593));
        this.tPY = ((TextView)paramView.findViewById(2131296542));
        AppMethodBeat.o(111680);
      }
    }
  }
  
  static final class b
    extends RecyclerView.a<a>
  {
    private Context mContext;
    SmartGalleryUI.c tPP;
    s.c tPZ;
    
    b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111686);
      if (this.tPZ == null)
      {
        AppMethodBeat.o(111686);
        return 0;
      }
      int i = this.tPZ.tHO.size();
      AppMethodBeat.o(111686);
      return i;
    }
    
    static final class a
      extends RecyclerView.w
    {
      TextView oDS;
      RecyclerView tQa;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111685);
        this.oDS = ((TextView)paramView.findViewById(2131297928));
        al.a(this.oDS.getPaint(), 0.8F);
        this.tQa = ((RecyclerView)paramView.findViewById(2131297927));
        AppMethodBeat.o(111685);
      }
    }
  }
  
  static abstract interface c
  {
    public abstract void a(s.a parama);
  }
  
  static final class d
    implements Runnable
  {
    WeakReference<SmartGalleryUI.b> tQb;
    WeakReference<ProgressDialog> tQc;
    WeakReference<EditText> tQd;
    
    d(SmartGalleryUI.b paramb, ProgressDialog paramProgressDialog, EditText paramEditText)
    {
      AppMethodBeat.i(111689);
      this.tQb = new WeakReference(paramb);
      this.tQc = new WeakReference(paramProgressDialog);
      this.tQd = new WeakReference(paramEditText);
      AppMethodBeat.o(111689);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111690);
      long l1 = System.currentTimeMillis();
      ad.i("MicroMsg.SmartGalleryUI", "start query category album.");
      Object localObject2 = s.cVx();
      Object localObject1 = new ArrayList();
      Object localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("albums").build();
      localObject2 = ((s)localObject2).gGN.query((Uri)localObject3, s.cVy(), null, null, null);
      if (localObject2 != null)
      {
        int i = ((Cursor)localObject2).getColumnIndex("categoryID");
        int j = ((Cursor)localObject2).getColumnIndex("categoryName");
        int k = ((Cursor)localObject2).getColumnIndex("albumID");
        int m = ((Cursor)localObject2).getColumnIndex("albumName");
        int n = ((Cursor)localObject2).getColumnIndex("albumCapacity");
        int i1 = ((Cursor)localObject2).getColumnIndex("coverID");
        int i2 = ((Cursor)localObject2).getColumnIndex("coverData");
        int i3 = ((Cursor)localObject2).getColumnIndex("albumTag");
        while (((Cursor)localObject2).moveToNext())
        {
          localObject3 = new s.a();
          ((s.a)localObject3).gR(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
          ((s.a)localObject3).tHF = ((Cursor)localObject2).getString(k);
          ((s.a)localObject3).tGK = ((Cursor)localObject2).getString(m);
          ((s.a)localObject3).tHG = bt.aRe(((Cursor)localObject2).getString(n));
          ((s.a)localObject3).tHH = bt.aRf(((Cursor)localObject2).getString(i1));
          ((s.a)localObject3).tHI = ((Cursor)localObject2).getString(i2);
          String str = ((Cursor)localObject2).getString(i3);
          if (!bt.isNullOrNil(str)) {
            ((s.a)localObject3).tHJ = s.gQ(str, ((s.a)localObject3).tHF);
          }
          ((List)localObject1).add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = s.dY((List)localObject1);
      ad.i("MicroMsg.SmartGalleryUI", "finish query category album.");
      long l2 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.g.yhR.f(19165, new Object[] { "", Long.valueOf(l2 - l1) });
      localObject1 = new SmartGalleryUI.g(this.tQb, (s.c)localObject1);
      ((SmartGalleryUI.g)localObject1).tQc = this.tQc;
      ((SmartGalleryUI.g)localObject1).tQd = this.tQd;
      e.cUN().f((Runnable)localObject1);
      AppMethodBeat.o(111690);
    }
  }
  
  static final class e
    implements Runnable
  {
    String tQe;
    SmartGalleryUI.h tQf;
    
    e(SmartGalleryUI.h paramh)
    {
      this.tQf = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111691);
      if (bt.isNullOrNil(this.tQe))
      {
        ad.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
        AppMethodBeat.o(111691);
        return;
      }
      ad.i("MicroMsg.SmartGalleryUI", "query search start.");
      Object localObject3 = s.cVx();
      Object localObject1 = this.tQe;
      Object localObject2 = new ArrayList();
      Object localObject4 = s.BASE_URI.buildUpon().appendEncodedPath("search").build();
      localObject3 = ((s)localObject3).gGN.query((Uri)localObject4, new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" }, "keyword=?", new String[] { localObject1 }, null);
      int i;
      if (localObject3 != null)
      {
        i = ((Cursor)localObject3).getColumnIndex("categoryID");
        int j = ((Cursor)localObject3).getColumnIndex("categoryName");
        int k = ((Cursor)localObject3).getColumnIndex("albumID");
        int m = ((Cursor)localObject3).getColumnIndex("albumName");
        int n = ((Cursor)localObject3).getColumnIndex("albumCapacity");
        int i1 = ((Cursor)localObject3).getColumnIndex("coverID");
        int i2 = ((Cursor)localObject3).getColumnIndex("coverData");
        int i3 = ((Cursor)localObject3).getColumnIndex("albumTag");
        while (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new s.a();
          ((s.a)localObject4).gR(((Cursor)localObject3).getString(i), ((Cursor)localObject3).getString(j));
          ((s.a)localObject4).tHF = ((Cursor)localObject3).getString(k);
          ((s.a)localObject4).tGK = ((Cursor)localObject3).getString(m);
          ((s.a)localObject4).tHG = bt.aRe(((Cursor)localObject3).getString(n));
          ((s.a)localObject4).tHH = bt.aRf(((Cursor)localObject3).getString(i1));
          ((s.a)localObject4).tHI = ((Cursor)localObject3).getString(i2);
          String str = ((Cursor)localObject3).getString(i3);
          if (!bt.isNullOrNil(str)) {
            ((s.a)localObject4).tHJ = s.gQ(str, ((s.a)localObject4).tHF);
          }
          ((List)localObject2).add(localObject4);
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = s.l((List)localObject2, (String)localObject1);
      ad.i("MicroMsg.SmartGalleryUI", "query search finish.");
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
          localObject3 = URLEncoder.encode(this.tQe, "utf-8");
          if (((List)localObject1).size() != 0) {
            continue;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(18270, new Object[] { localObject3, Integer.valueOf(i) });
        }
        catch (Exception localException)
        {
          continue;
        }
        if ((!bt.isNullOrNil(this.tQf.tQe)) && (this.tQf.tQe.equals(this.tQe))) {
          continue;
        }
        ad.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", new Object[] { this.tQe, this.tQf.tQe });
        AppMethodBeat.o(111691);
        return;
        i = 1;
      }
      localObject2 = this.tQf;
      ((SmartGalleryUI.h)localObject2).pAZ.clear();
      ((SmartGalleryUI.h)localObject2).pAZ.addAll((Collection)localObject1);
      e.cUN().f(this.tQf);
      AppMethodBeat.o(111691);
    }
  }
  
  static final class f
    extends RecyclerView.a<RecyclerView.w>
  {
    private View.OnClickListener km;
    private Context mContext;
    List<s.i> pAZ;
    SmartGalleryUI.c tPP;
    String tQe;
    
    f(Context paramContext)
    {
      AppMethodBeat.i(111695);
      this.km = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111692);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.f.a(SmartGalleryUI.f.this) != null)) {
            SmartGalleryUI.f.a(SmartGalleryUI.f.this).a((s.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111692);
        }
      };
      this.mContext = paramContext;
      this.pAZ = new ArrayList();
      AppMethodBeat.o(111695);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(111696);
      if (paramInt == 0)
      {
        paramViewGroup = new b(LayoutInflater.from(this.mContext).inflate(2131495476, paramViewGroup, false));
        AppMethodBeat.o(111696);
        return paramViewGroup;
      }
      if (1 == paramInt)
      {
        paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(2131495475, paramViewGroup, false));
        AppMethodBeat.o(111696);
        return paramViewGroup;
      }
      paramViewGroup = new c(LayoutInflater.from(this.mContext).inflate(2131495477, paramViewGroup, false));
      AppMethodBeat.o(111696);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(111697);
      Object localObject1;
      if ((paramw instanceof b))
      {
        localObject1 = (s.d)this.pAZ.get(paramInt);
        b.a((b)paramw).setText(((s.d)localObject1).tHQ);
        AppMethodBeat.o(111697);
        return;
      }
      if ((paramw instanceof a))
      {
        localObject1 = (s.a)this.pAZ.get(paramInt);
        paramw.auu.setOnClickListener(this.km);
        paramw.auu.setTag(localObject1);
        Object localObject2 = ((s.a)localObject1).tHJ;
        paramInt = i;
        ImageView localImageView;
        String str1;
        String str2;
        long l;
        if (localObject2 != null)
        {
          if (((s.b)localObject2).tHL) {
            paramInt = 2;
          }
        }
        else
        {
          localObject2 = (a)paramw;
          localImageView = a.a((a)localObject2);
          str1 = ((s.a)localObject1).tHI;
          str2 = ((s.a)localObject1).tHI;
          l = ((s.a)localObject1).tHH;
          if (((s.a)localObject1).tHJ != null) {
            break label220;
          }
        }
        label220:
        for (paramw = null;; paramw = ((s.a)localObject1).tHJ.tFV)
        {
          h.a(localImageView, paramInt, str1, str2, l, paramw);
          a.b((a)localObject2).setText(f.b(((s.a)localObject1).tGK, this.tQe));
          a.c((a)localObject2).setText(String.valueOf(((s.a)localObject1).tHG));
          AppMethodBeat.o(111697);
          return;
          paramInt = 1;
          break;
        }
      }
      if ((paramw instanceof c)) {
        ad.i("MicroMsg.SmartGalleryUI", "no search result.");
      }
      AppMethodBeat.o(111697);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111698);
      if (this.pAZ.size() == 0)
      {
        s.f localf = new s.f();
        this.pAZ.add(localf);
      }
      int i = this.pAZ.size();
      AppMethodBeat.o(111698);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(111699);
      paramInt = ((s.i)this.pAZ.get(paramInt)).mType;
      AppMethodBeat.o(111699);
      return paramInt;
    }
    
    static final class a
      extends RecyclerView.w
    {
      private ImageView tPW;
      private TextView tPX;
      private TextView tPY;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111693);
        this.tPW = ((ImageView)paramView.findViewById(2131296565));
        this.tPX = ((TextView)paramView.findViewById(2131296593));
        this.tPY = ((TextView)paramView.findViewById(2131296542));
        AppMethodBeat.o(111693);
      }
    }
    
    static final class b
      extends RecyclerView.w
    {
      private TextView oDS;
      
      b(View paramView)
      {
        super();
        AppMethodBeat.i(111694);
        this.oDS = ((TextView)paramView.findViewById(2131297928));
        al.a(this.oDS.getPaint(), 0.8F);
        AppMethodBeat.o(111694);
      }
    }
    
    static final class c
      extends RecyclerView.w
    {
      c(View paramView)
      {
        super();
      }
    }
  }
  
  static final class g
    implements Runnable
  {
    s.c tPZ;
    WeakReference<SmartGalleryUI.b> tQb;
    WeakReference<ProgressDialog> tQc;
    WeakReference<EditText> tQd;
    
    g(WeakReference<SmartGalleryUI.b> paramWeakReference, s.c paramc)
    {
      this.tQb = paramWeakReference;
      this.tPZ = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111700);
      if ((this.tQb != null) && (this.tPZ != null))
      {
        Object localObject = (SmartGalleryUI.b)this.tQb.get();
        if (localObject != null)
        {
          ad.i("MicroMsg.SmartGalleryUI", "show category.");
          ((SmartGalleryUI.b)localObject).tPZ = this.tPZ;
          ((RecyclerView.a)localObject).asY.notifyChanged();
        }
        if (this.tQc != null)
        {
          localObject = (ProgressDialog)this.tQc.get();
          if (localObject != null)
          {
            ad.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
            ((ProgressDialog)localObject).dismiss();
          }
        }
        if (this.tQd != null)
        {
          localObject = (EditText)this.tQd.get();
          if (localObject != null)
          {
            ad.i("MicroMsg.SmartGalleryUI", "show keyboard.");
            ((EditText)localObject).requestFocus();
            ((InputMethodManager)((EditText)localObject).getContext().getSystemService("input_method")).showSoftInput((View)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(111700);
    }
  }
  
  static final class h
    implements Runnable
  {
    List<s.i> pAZ;
    String tQe;
    WeakReference<RecyclerView> tQh;
    WeakReference<SmartGalleryUI.f> tQi;
    
    h(RecyclerView paramRecyclerView, SmartGalleryUI.f paramf)
    {
      AppMethodBeat.i(111701);
      this.pAZ = new ArrayList();
      this.tQh = new WeakReference(paramRecyclerView);
      this.tQi = new WeakReference(paramf);
      AppMethodBeat.o(111701);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111702);
      if ((this.tQh == null) || (this.tQi == null))
      {
        ad.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
        AppMethodBeat.o(111702);
        return;
      }
      if (this.pAZ != null)
      {
        Object localObject = (RecyclerView)this.tQh.get();
        if (localObject != null)
        {
          SmartGalleryUI.f localf = (SmartGalleryUI.f)this.tQi.get();
          if (localf != null)
          {
            ((RecyclerView)localObject).setAdapter(localf);
            localf.tQe = this.tQe;
            localObject = this.pAZ;
            localf.pAZ.clear();
            localf.pAZ.addAll((Collection)localObject);
            localf.asY.notifyChanged();
          }
        }
        AppMethodBeat.o(111702);
        return;
      }
      ad.e("MicroMsg.SmartGalleryUI", "update search ui, data is null.");
      AppMethodBeat.o(111702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI
 * JD-Core Version:    0.7.0.1
 */