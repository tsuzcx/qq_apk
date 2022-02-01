package com.tencent.mm.plugin.gallery.ui;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.b;
import com.tencent.mm.plugin.gallery.model.s.c;
import com.tencent.mm.plugin.gallery.model.s.d;
import com.tencent.mm.plugin.gallery.model.s.f;
import com.tencent.mm.plugin.gallery.model.s.i;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.q;
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
  public static int xrW = 1;
  private int mcq;
  private ProgressDialog pqa;
  Button rlN;
  private String xjc;
  private RecyclerView xrK;
  private EditText xrL;
  private b xrM;
  private f xrN;
  private e xrO;
  private h xrP;
  private int xrQ;
  private boolean xrR;
  w xrS;
  private boolean xrT;
  c xrU;
  private boolean xrV;
  
  public SmartGalleryUI()
  {
    AppMethodBeat.i(111703);
    this.xrR = false;
    this.xrT = true;
    this.xrU = new c()
    {
      public final void a(s.a paramAnonymousa)
      {
        AppMethodBeat.i(111677);
        Log.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", new Object[] { paramAnonymousa.xjJ, paramAnonymousa.albumName });
        Intent localIntent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
        localIntent.putExtras(SmartGalleryUI.this.getIntent());
        localIntent.putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this));
        if (SmartGalleryUI.h(SmartGalleryUI.this)) {
          if ((paramAnonymousa.xjN != null) && (paramAnonymousa.xjN.xjO)) {
            localIntent.putExtra("select_type_tag", 1);
          }
        }
        try
        {
          while ((paramAnonymousa.xjI != null) && (paramAnonymousa.xjI.xjU != null))
          {
            Object localObject = paramAnonymousa.xjI.xjU;
            String str2 = "";
            if (paramAnonymousa.albumName != null) {
              str2 = paramAnonymousa.albumName;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(18269, new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(str2, "utf-8") });
            localIntent.putExtra("is_from_smart_gallery", true);
            str2 = paramAnonymousa.albumName;
            localObject = str2;
            if (Util.isNullOrNil(str2)) {
              localObject = paramAnonymousa.xjI.xjU;
            }
            localIntent.putExtra("title_from_smart_gallery", (String)localObject);
            localIntent.putExtra("album_id_from_smart_gallery", paramAnonymousa.xjJ);
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
    this.xrV = false;
    AppMethodBeat.o(111703);
  }
  
  private void dSt()
  {
    AppMethodBeat.i(111706);
    int i = s.dRv().dRz();
    if (i > 0) {
      this.rlN.setEnabled(true);
    }
    for (;;)
    {
      this.rlN.setText(d.a(this, this.mcq, i, this.xrQ, this.xjc, null));
      AppMethodBeat.o(111706);
      return;
      this.rlN.setEnabled(false);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496349;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111707);
    Log.i("MicroMsg.SmartGalleryUI", "requestCode: %d, resultCode: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent != null)
    {
      this.xrV = paramIntent.getBooleanExtra("send_raw_img", false);
      paramIntent.putExtra("send_raw_img", this.xrV);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.i("MicroMsg.SmartGalleryUI", "key: %s, value: %s.", new Object[] { str, localBundle.get(str) });
        }
      }
    }
    if (1 == paramInt1)
    {
      if ((-2 == paramInt2) || (paramInt2 == 0))
      {
        Log.i("MicroMsg.SmartGalleryUI", "just back from AlbumPreviewUI.");
        dSt();
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
    this.mcq = getIntent().getIntExtra("query_source_type", 3);
    this.xrQ = getIntent().getIntExtra("max_select_count", 9);
    this.xjc = getIntent().getStringExtra("album_business_tag");
    this.xrV = getIntent().getBooleanExtra("send_raw_img", false);
    this.pqa = q.a(this, getString(2131756029), true);
    this.pqa.show();
    setActionbarColor(getResources().getColor(2131100500));
    setNavigationbarColor(getResources().getColor(2131100500));
    paramBundle = LayoutInflater.from(this).inflate(2131492937, new LinearLayout(this), false);
    paramBundle.findViewById(2131307944).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111671);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (Util.isNullOrNil(SmartGalleryUI.a(SmartGalleryUI.this).getText()))
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
    this.xrL = ((EditText)paramBundle.findViewById(2131307946));
    this.xrL.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(111672);
        if (!SmartGalleryUI.c(SmartGalleryUI.this)) {
          SmartGalleryUI.a(SmartGalleryUI.this, true);
        }
        AppMethodBeat.o(111672);
        return false;
      }
    });
    this.xrL.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(111673);
        if (3 == paramAnonymousInt)
        {
          paramAnonymousTextView = paramAnonymousTextView.getText().toString();
          if (!Util.isNullOrNil(paramAnonymousTextView))
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
    this.xrL.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(111674);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        Log.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", new Object[] { paramAnonymousEditable });
        SmartGalleryUI.d(SmartGalleryUI.this).xsj = paramAnonymousEditable;
        if (Util.isNullOrNil(paramAnonymousEditable))
        {
          SmartGalleryUI.e(SmartGalleryUI.this);
          SmartGalleryUI.g(SmartGalleryUI.this).setAdapter(SmartGalleryUI.f(SmartGalleryUI.this));
          SmartGalleryUI.g(SmartGalleryUI.this).a(SmartGalleryUI.this.xrS);
          SmartGalleryUI.f(SmartGalleryUI.this).atj.notifyChanged();
          AppMethodBeat.o(111674);
          return;
        }
        SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousEditable, false);
        AppMethodBeat.o(111674);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.rlN = ((Button)paramBundle.findViewById(2131307947));
    dSt();
    this.rlN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111675);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SmartGalleryUI.this.setResult(SmartGalleryUI.xrW);
        SmartGalleryUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111675);
      }
    });
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      localActionBar.gt();
      localActionBar.setDisplayHomeAsUpEnabled(false);
      localActionBar.gs();
      localActionBar.gu();
      localActionBar.setCustomView(paramBundle);
    }
    for (;;)
    {
      this.xrS = new w(this, 1);
      this.xrS.setDrawable(getResources().getDrawable(2131234916));
      this.xrK = ((RecyclerView)findViewById(2131307945));
      this.xrK.a(new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111676);
          b localb = new b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          Log.d("MicroMsg.SmartGalleryUI", "onScrollStateChanged, newState: %d, mIsNeedReset: %s.", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(SmartGalleryUI.c(SmartGalleryUI.this)) });
          if ((1 == paramAnonymousInt) && (SmartGalleryUI.c(SmartGalleryUI.this)))
          {
            SmartGalleryUI.a(SmartGalleryUI.this, false);
            SmartGalleryUI.this.hideVKB();
            SmartGalleryUI.a(SmartGalleryUI.this).clearFocus();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(111676);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(257760);
          b localb = new b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(257760);
        }
      });
      this.xrK.a(this.xrS);
      this.xrM = new b(this);
      this.xrM.xrU = this.xrU;
      this.xrN = new f(this);
      this.xrN.xrU = this.xrU;
      this.xrK.setLayoutManager(new LinearLayoutManager());
      this.xrK.setAdapter(this.xrM);
      this.xrP = new h(this.xrK, this.xrN);
      this.xrO = new e(this.xrP);
      e.dQL().ar(new d(this.xrM, this.pqa, this.xrL));
      AppMethodBeat.o(111704);
      return;
      Log.e("MicroMsg.SmartGalleryUI", "actionbar is null.");
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
    s.dRv().dRy();
    AppMethodBeat.o(111710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111708);
    if ((4 == paramInt) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (Util.isNullOrNil(this.xrL.getText()))
      {
        setResult(-2, getIntent().putExtra("send_raw_img", this.xrV));
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(111708);
        return true;
        this.xrL.setText("");
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
    this.xrL.clearFocus();
    AppMethodBeat.o(111709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111705);
    super.onResume();
    dSt();
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
    View.OnClickListener ko;
    private Context mContext;
    private View.OnLongClickListener xnu;
    SmartGalleryUI.c xrU;
    List<s.a> xrY;
    private int xrZ;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(111681);
      this.ko = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111678);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.a.a(SmartGalleryUI.a.this) != null)) {
            SmartGalleryUI.a.a(SmartGalleryUI.a.this).a((s.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111678);
        }
      };
      this.xnu = new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111679);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView instanceof s.a))
          {
            paramAnonymousView = (s.a)paramAnonymousView;
            ClipboardHelper.setText(SmartGalleryUI.a.b(SmartGalleryUI.a.this), "media info", paramAnonymousView.toString());
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(111679);
          return true;
        }
      };
      this.mContext = paramContext;
      this.xrY = new ArrayList();
      this.xrZ = ((this.mContext.getResources().getDisplayMetrics().widthPixels - at.aH(this.mContext, 2131165296) - at.aH(this.mContext, 2131165314) * 4) / 9 * 2);
      Log.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", new Object[] { Integer.valueOf(this.xrZ) });
      AppMethodBeat.o(111681);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111682);
      int i = this.xrY.size();
      AppMethodBeat.o(111682);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      ImageView xsb;
      TextView xsc;
      TextView xsd;
      
      a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(111680);
        this.xsb = ((ImageView)paramView.findViewById(2131296642));
        ViewGroup.LayoutParams localLayoutParams = this.xsb.getLayoutParams();
        localLayoutParams.width = paramInt;
        localLayoutParams.height = paramInt;
        this.xsb.setLayoutParams(localLayoutParams);
        this.xsc = ((TextView)paramView.findViewById(2131296670));
        this.xsd = ((TextView)paramView.findViewById(2131296618));
        AppMethodBeat.o(111680);
      }
    }
  }
  
  static final class b
    extends RecyclerView.a<a>
  {
    private Context mContext;
    SmartGalleryUI.c xrU;
    s.c xse;
    
    b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111686);
      if (this.xse == null)
      {
        AppMethodBeat.o(111686);
        return 0;
      }
      int i = this.xse.xjS.size();
      AppMethodBeat.o(111686);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      TextView pYi;
      RecyclerView xsf;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111685);
        this.pYi = ((TextView)paramView.findViewById(2131298247));
        ao.a(this.pYi.getPaint(), 0.8F);
        this.xsf = ((RecyclerView)paramView.findViewById(2131298246));
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
    WeakReference<SmartGalleryUI.b> xsg;
    WeakReference<ProgressDialog> xsh;
    WeakReference<EditText> xsi;
    
    d(SmartGalleryUI.b paramb, ProgressDialog paramProgressDialog, EditText paramEditText)
    {
      AppMethodBeat.i(111689);
      this.xsg = new WeakReference(paramb);
      this.xsh = new WeakReference(paramProgressDialog);
      this.xsi = new WeakReference(paramEditText);
      AppMethodBeat.o(111689);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111690);
      long l1 = System.currentTimeMillis();
      Log.i("MicroMsg.SmartGalleryUI", "start query category album.");
      Object localObject2 = s.dRv();
      Object localObject1 = new ArrayList();
      Object localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("albums").build();
      localObject2 = ((s)localObject2).hwt.query((Uri)localObject3, s.dRw(), null, null, null);
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
          ((s.a)localObject3).hD(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
          ((s.a)localObject3).xjJ = ((Cursor)localObject2).getString(k);
          ((s.a)localObject3).albumName = ((Cursor)localObject2).getString(m);
          ((s.a)localObject3).xjK = Util.safeParseInt(((Cursor)localObject2).getString(n));
          ((s.a)localObject3).xjL = Util.safeParseLong(((Cursor)localObject2).getString(i1));
          ((s.a)localObject3).xjM = ((Cursor)localObject2).getString(i2);
          String str = ((Cursor)localObject2).getString(i3);
          if (!Util.isNullOrNil(str)) {
            ((s.a)localObject3).xjN = s.hC(str, ((s.a)localObject3).xjJ);
          }
          ((List)localObject1).add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = s.eV((List)localObject1);
      Log.i("MicroMsg.SmartGalleryUI", "finish query category album.");
      long l2 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.CyF.a(19165, new Object[] { "", Long.valueOf(l2 - l1) });
      localObject1 = new SmartGalleryUI.g(this.xsg, (s.c)localObject1);
      ((SmartGalleryUI.g)localObject1).xsh = this.xsh;
      ((SmartGalleryUI.g)localObject1).xsi = this.xsi;
      e.dQL().postToMainThread((Runnable)localObject1);
      AppMethodBeat.o(111690);
    }
  }
  
  static final class e
    implements Runnable
  {
    String xsj;
    SmartGalleryUI.h xsk;
    
    e(SmartGalleryUI.h paramh)
    {
      this.xsk = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111691);
      if (Util.isNullOrNil(this.xsj))
      {
        Log.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
        AppMethodBeat.o(111691);
        return;
      }
      Log.i("MicroMsg.SmartGalleryUI", "query search start.");
      Object localObject3 = s.dRv();
      Object localObject1 = this.xsj;
      Object localObject2 = new ArrayList();
      Object localObject4 = s.BASE_URI.buildUpon().appendEncodedPath("search").build();
      localObject3 = ((s)localObject3).hwt.query((Uri)localObject4, new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" }, "keyword=?", new String[] { localObject1 }, null);
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
          ((s.a)localObject4).hD(((Cursor)localObject3).getString(i), ((Cursor)localObject3).getString(j));
          ((s.a)localObject4).xjJ = ((Cursor)localObject3).getString(k);
          ((s.a)localObject4).albumName = ((Cursor)localObject3).getString(m);
          ((s.a)localObject4).xjK = Util.safeParseInt(((Cursor)localObject3).getString(n));
          ((s.a)localObject4).xjL = Util.safeParseLong(((Cursor)localObject3).getString(i1));
          ((s.a)localObject4).xjM = ((Cursor)localObject3).getString(i2);
          String str = ((Cursor)localObject3).getString(i3);
          if (!Util.isNullOrNil(str)) {
            ((s.a)localObject4).xjN = s.hC(str, ((s.a)localObject4).xjJ);
          }
          ((List)localObject2).add(localObject4);
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = s.n((List)localObject2, (String)localObject1);
      Log.i("MicroMsg.SmartGalleryUI", "query search finish.");
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
          localObject3 = URLEncoder.encode(this.xsj, "utf-8");
          if (((List)localObject1).size() != 0) {
            continue;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(18270, new Object[] { localObject3, Integer.valueOf(i) });
        }
        catch (Exception localException)
        {
          continue;
        }
        if ((!Util.isNullOrNil(this.xsk.xsj)) && (this.xsk.xsj.equals(this.xsj))) {
          continue;
        }
        Log.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", new Object[] { this.xsj, this.xsk.xsj });
        AppMethodBeat.o(111691);
        return;
        i = 1;
      }
      localObject2 = this.xsk;
      ((SmartGalleryUI.h)localObject2).qXp.clear();
      ((SmartGalleryUI.h)localObject2).qXp.addAll((Collection)localObject1);
      e.dQL().postToMainThread(this.xsk);
      AppMethodBeat.o(111691);
    }
  }
  
  static final class f
    extends RecyclerView.a<RecyclerView.v>
  {
    private View.OnClickListener ko;
    private Context mContext;
    List<s.i> qXp;
    SmartGalleryUI.c xrU;
    String xsj;
    
    f(Context paramContext)
    {
      AppMethodBeat.i(111695);
      this.ko = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111692);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.f.a(SmartGalleryUI.f.this) != null)) {
            SmartGalleryUI.f.a(SmartGalleryUI.f.this).a((s.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111692);
        }
      };
      this.mContext = paramContext;
      this.qXp = new ArrayList();
      AppMethodBeat.o(111695);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(111696);
      if (paramInt == 0)
      {
        paramViewGroup = new b(LayoutInflater.from(this.mContext).inflate(2131496351, paramViewGroup, false));
        AppMethodBeat.o(111696);
        return paramViewGroup;
      }
      if (1 == paramInt)
      {
        paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(2131496350, paramViewGroup, false));
        AppMethodBeat.o(111696);
        return paramViewGroup;
      }
      paramViewGroup = new c(LayoutInflater.from(this.mContext).inflate(2131496352, paramViewGroup, false));
      AppMethodBeat.o(111696);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(111697);
      Object localObject1;
      if ((paramv instanceof b))
      {
        localObject1 = (s.d)this.qXp.get(paramInt);
        b.a((b)paramv).setText(((s.d)localObject1).xjU);
        AppMethodBeat.o(111697);
        return;
      }
      if ((paramv instanceof a))
      {
        localObject1 = (s.a)this.qXp.get(paramInt);
        paramv.aus.setOnClickListener(this.ko);
        paramv.aus.setTag(localObject1);
        Object localObject2 = ((s.a)localObject1).xjN;
        paramInt = i;
        ImageView localImageView;
        String str1;
        String str2;
        long l;
        if (localObject2 != null)
        {
          if (((s.b)localObject2).xjP) {
            paramInt = 2;
          }
        }
        else
        {
          localObject2 = (a)paramv;
          localImageView = a.a((a)localObject2);
          str1 = ((s.a)localObject1).xjM;
          str2 = ((s.a)localObject1).xjM;
          l = ((s.a)localObject1).xjL;
          if (((s.a)localObject1).xjN != null) {
            break label220;
          }
        }
        label220:
        for (paramv = null;; paramv = ((s.a)localObject1).xjN.xhZ)
        {
          h.a(localImageView, paramInt, str1, str2, l, paramv);
          a.b((a)localObject2).setText(f.b(((s.a)localObject1).albumName, this.xsj));
          a.c((a)localObject2).setText(String.valueOf(((s.a)localObject1).xjK));
          AppMethodBeat.o(111697);
          return;
          paramInt = 1;
          break;
        }
      }
      if ((paramv instanceof c)) {
        Log.i("MicroMsg.SmartGalleryUI", "no search result.");
      }
      AppMethodBeat.o(111697);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111698);
      if (this.qXp.size() == 0)
      {
        s.f localf = new s.f();
        this.qXp.add(localf);
      }
      int i = this.qXp.size();
      AppMethodBeat.o(111698);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(111699);
      paramInt = ((s.i)this.qXp.get(paramInt)).mType;
      AppMethodBeat.o(111699);
      return paramInt;
    }
    
    static final class a
      extends RecyclerView.v
    {
      private ImageView xsb;
      private TextView xsc;
      private TextView xsd;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111693);
        this.xsb = ((ImageView)paramView.findViewById(2131296642));
        this.xsc = ((TextView)paramView.findViewById(2131296670));
        this.xsd = ((TextView)paramView.findViewById(2131296618));
        AppMethodBeat.o(111693);
      }
    }
    
    static final class b
      extends RecyclerView.v
    {
      private TextView pYi;
      
      b(View paramView)
      {
        super();
        AppMethodBeat.i(111694);
        this.pYi = ((TextView)paramView.findViewById(2131298247));
        ao.a(this.pYi.getPaint(), 0.8F);
        AppMethodBeat.o(111694);
      }
    }
    
    static final class c
      extends RecyclerView.v
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
    s.c xse;
    WeakReference<SmartGalleryUI.b> xsg;
    WeakReference<ProgressDialog> xsh;
    WeakReference<EditText> xsi;
    
    g(WeakReference<SmartGalleryUI.b> paramWeakReference, s.c paramc)
    {
      this.xsg = paramWeakReference;
      this.xse = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111700);
      if ((this.xsg != null) && (this.xse != null))
      {
        Object localObject = (SmartGalleryUI.b)this.xsg.get();
        if (localObject != null)
        {
          Log.i("MicroMsg.SmartGalleryUI", "show category.");
          ((SmartGalleryUI.b)localObject).xse = this.xse;
          ((RecyclerView.a)localObject).atj.notifyChanged();
        }
        if (this.xsh != null)
        {
          localObject = (ProgressDialog)this.xsh.get();
          if (localObject != null)
          {
            Log.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
            ((ProgressDialog)localObject).dismiss();
          }
        }
        if (this.xsi != null)
        {
          localObject = (EditText)this.xsi.get();
          if (localObject != null)
          {
            Log.i("MicroMsg.SmartGalleryUI", "show keyboard.");
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
    List<s.i> qXp;
    String xsj;
    WeakReference<RecyclerView> xsm;
    WeakReference<SmartGalleryUI.f> xsn;
    
    h(RecyclerView paramRecyclerView, SmartGalleryUI.f paramf)
    {
      AppMethodBeat.i(111701);
      this.qXp = new ArrayList();
      this.xsm = new WeakReference(paramRecyclerView);
      this.xsn = new WeakReference(paramf);
      AppMethodBeat.o(111701);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111702);
      if ((this.xsm == null) || (this.xsn == null))
      {
        Log.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
        AppMethodBeat.o(111702);
        return;
      }
      if (this.qXp != null)
      {
        Object localObject = (RecyclerView)this.xsm.get();
        if (localObject != null)
        {
          SmartGalleryUI.f localf = (SmartGalleryUI.f)this.xsn.get();
          if (localf != null)
          {
            ((RecyclerView)localObject).setAdapter(localf);
            localf.xsj = this.xsj;
            localObject = this.qXp;
            localf.qXp.clear();
            localf.qXp.addAll((Collection)localObject);
            localf.atj.notifyChanged();
          }
        }
        AppMethodBeat.o(111702);
        return;
      }
      Log.e("MicroMsg.SmartGalleryUI", "update search ui, data is null.");
      AppMethodBeat.o(111702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI
 * JD-Core Version:    0.7.0.1
 */