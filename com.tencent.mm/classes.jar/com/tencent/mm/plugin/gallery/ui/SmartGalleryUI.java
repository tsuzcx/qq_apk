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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
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
  public static int rLy = 1;
  private int jWF;
  private ProgressDialog mVv;
  Button oHj;
  private String rBv;
  private RecyclerView rLm;
  private EditText rLn;
  private b rLo;
  private f rLp;
  private e rLq;
  private h rLr;
  private int rLs;
  private boolean rLt;
  w rLu;
  private boolean rLv;
  c rLw;
  private boolean rLx;
  
  public SmartGalleryUI()
  {
    AppMethodBeat.i(111703);
    this.rLt = false;
    this.rLv = true;
    this.rLw = new c()
    {
      public final void a(s.a paramAnonymousa)
      {
        AppMethodBeat.i(111677);
        ad.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", new Object[] { paramAnonymousa.rCc, paramAnonymousa.rBh });
        Intent localIntent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
        localIntent.putExtras(SmartGalleryUI.this.getIntent());
        localIntent.putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this));
        if (SmartGalleryUI.h(SmartGalleryUI.this)) {
          if ((paramAnonymousa.rCg != null) && (paramAnonymousa.rCg.rCh)) {
            localIntent.putExtra("select_type_tag", 1);
          }
        }
        try
        {
          while ((paramAnonymousa.rCb != null) && (paramAnonymousa.rCb.rCn != null))
          {
            Object localObject = paramAnonymousa.rCb.rCn;
            String str2 = "";
            if (paramAnonymousa.rBh != null) {
              str2 = paramAnonymousa.rBh;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(18269, new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(str2, "utf-8") });
            localIntent.putExtra("is_from_smart_gallery", true);
            str2 = paramAnonymousa.rBh;
            localObject = str2;
            if (bt.isNullOrNil(str2)) {
              localObject = paramAnonymousa.rCb.rCn;
            }
            localIntent.putExtra("title_from_smart_gallery", (String)localObject);
            localIntent.putExtra("album_id_from_smart_gallery", paramAnonymousa.rCc);
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
    this.rLx = false;
    AppMethodBeat.o(111703);
  }
  
  private void cAO()
  {
    AppMethodBeat.i(111706);
    int i = s.czT().czX();
    if (i > 0) {
      this.oHj.setEnabled(true);
    }
    for (;;)
    {
      this.oHj.setText(d.a(this, this.jWF, i, this.rLs, this.rBv, null));
      AppMethodBeat.o(111706);
      return;
      this.oHj.setEnabled(false);
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
      this.rLx = paramIntent.getBooleanExtra("send_raw_img", false);
      paramIntent.putExtra("send_raw_img", this.rLx);
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
        cAO();
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
    this.jWF = getIntent().getIntExtra("query_source_type", 3);
    this.rLs = getIntent().getIntExtra("max_select_count", 9);
    this.rBv = getIntent().getStringExtra("album_business_tag");
    this.rLx = getIntent().getBooleanExtra("send_raw_img", false);
    this.mVv = p.a(this, getString(2131755936), true);
    this.mVv.show();
    setActionbarColor(getResources().getColor(2131100399));
    setNavigationbarColor(getResources().getColor(2131100399));
    paramBundle = LayoutInflater.from(this).inflate(2131492919, new LinearLayout(this), false);
    paramBundle.findViewById(2131304858).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111671);
        if (bt.ai(SmartGalleryUI.a(SmartGalleryUI.this).getText()))
        {
          SmartGalleryUI.this.setResult(-2, SmartGalleryUI.this.getIntent().putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this)));
          SmartGalleryUI.this.finish();
          AppMethodBeat.o(111671);
          return;
        }
        SmartGalleryUI.a(SmartGalleryUI.this).setText("");
        AppMethodBeat.o(111671);
      }
    });
    this.rLn = ((EditText)paramBundle.findViewById(2131304860));
    this.rLn.setOnTouchListener(new View.OnTouchListener()
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
    this.rLn.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.rLn.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(111674);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        ad.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", new Object[] { paramAnonymousEditable });
        SmartGalleryUI.d(SmartGalleryUI.this).rLL = paramAnonymousEditable;
        if (bt.isNullOrNil(paramAnonymousEditable))
        {
          SmartGalleryUI.e(SmartGalleryUI.this);
          SmartGalleryUI.g(SmartGalleryUI.this).setAdapter(SmartGalleryUI.f(SmartGalleryUI.this));
          SmartGalleryUI.g(SmartGalleryUI.this).a(SmartGalleryUI.this.rLu);
          SmartGalleryUI.f(SmartGalleryUI.this).aql.notifyChanged();
          AppMethodBeat.o(111674);
          return;
        }
        SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousEditable, false);
        AppMethodBeat.o(111674);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.oHj = ((Button)paramBundle.findViewById(2131304861));
    cAO();
    this.oHj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111675);
        SmartGalleryUI.this.setResult(SmartGalleryUI.rLy);
        SmartGalleryUI.this.finish();
        AppMethodBeat.o(111675);
      }
    });
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      localActionBar.fM();
      localActionBar.setDisplayHomeAsUpEnabled(false);
      localActionBar.fL();
      localActionBar.fN();
      localActionBar.setCustomView(paramBundle);
    }
    for (;;)
    {
      this.rLu = new w(this);
      this.rLu.setDrawable(getResources().getDrawable(2131234071));
      this.rLm = ((RecyclerView)findViewById(2131304859));
      this.rLm.a(new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(200780);
          b localb = new b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt1);
          localb.lT(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(200780);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(111676);
          b localb = new b();
          localb.be(paramAnonymousRecyclerView);
          localb.lT(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
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
      this.rLm.a(this.rLu);
      this.rLo = new b(this);
      this.rLo.rLw = this.rLw;
      this.rLp = new f(this);
      this.rLp.rLw = this.rLw;
      this.rLm.setLayoutManager(new LinearLayoutManager());
      this.rLm.setAdapter(this.rLo);
      this.rLr = new h(this.rLm, this.rLp);
      this.rLq = new e(this.rLr);
      e.czi().ak(new d(this.rLo, this.mVv, this.rLn));
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
    s.czT().czW();
    AppMethodBeat.o(111710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111708);
    if ((4 == paramInt) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (bt.ai(this.rLn.getText()))
      {
        setResult(-2, getIntent().putExtra("send_raw_img", this.rLx));
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(111708);
        return true;
        this.rLn.setText("");
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
    this.rLn.clearFocus();
    AppMethodBeat.o(111709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111705);
    super.onResume();
    cAO();
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
    View.OnClickListener hs;
    private Context mContext;
    private View.OnLongClickListener rHa;
    List<s.a> rLA;
    private int rLB;
    SmartGalleryUI.c rLw;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(111681);
      this.hs = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111678);
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.a.a(SmartGalleryUI.a.this) != null)) {
            SmartGalleryUI.a.a(SmartGalleryUI.a.this).a((s.a)paramAnonymousView);
          }
          AppMethodBeat.o(111678);
        }
      };
      this.rHa = new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111679);
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView instanceof s.a))
          {
            paramAnonymousView = (s.a)paramAnonymousView;
            ((ClipboardManager)SmartGalleryUI.a.b(SmartGalleryUI.a.this).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("media info", paramAnonymousView.toString()));
          }
          AppMethodBeat.o(111679);
          return true;
        }
      };
      this.mContext = paramContext;
      this.rLA = new ArrayList();
      this.rLB = ((this.mContext.getResources().getDisplayMetrics().widthPixels - ao.ap(this.mContext, 2131165289) - ao.ap(this.mContext, 2131165303) * 4) / 9 * 2);
      ad.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", new Object[] { Integer.valueOf(this.rLB) });
      AppMethodBeat.o(111681);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111682);
      int i = this.rLA.size();
      AppMethodBeat.o(111682);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      ImageView rLD;
      TextView rLE;
      TextView rLF;
      
      a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(111680);
        this.rLD = ((ImageView)paramView.findViewById(2131296565));
        ViewGroup.LayoutParams localLayoutParams = this.rLD.getLayoutParams();
        localLayoutParams.width = paramInt;
        localLayoutParams.height = paramInt;
        this.rLD.setLayoutParams(localLayoutParams);
        this.rLE = ((TextView)paramView.findViewById(2131296593));
        this.rLF = ((TextView)paramView.findViewById(2131296542));
        AppMethodBeat.o(111680);
      }
    }
  }
  
  static final class b
    extends RecyclerView.a<a>
  {
    private Context mContext;
    s.c rLG;
    SmartGalleryUI.c rLw;
    
    b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111686);
      if (this.rLG == null)
      {
        AppMethodBeat.o(111686);
        return 0;
      }
      int i = this.rLG.rCl.size();
      AppMethodBeat.o(111686);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      TextView nxy;
      RecyclerView rLH;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111685);
        this.nxy = ((TextView)paramView.findViewById(2131297928));
        ai.a(this.nxy.getPaint(), 0.8F);
        this.rLH = ((RecyclerView)paramView.findViewById(2131297927));
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
    WeakReference<SmartGalleryUI.b> rLI;
    WeakReference<ProgressDialog> rLJ;
    WeakReference<EditText> rLK;
    
    d(SmartGalleryUI.b paramb, ProgressDialog paramProgressDialog, EditText paramEditText)
    {
      AppMethodBeat.i(111689);
      this.rLI = new WeakReference(paramb);
      this.rLJ = new WeakReference(paramProgressDialog);
      this.rLK = new WeakReference(paramEditText);
      AppMethodBeat.o(111689);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111690);
      long l1 = System.currentTimeMillis();
      ad.i("MicroMsg.SmartGalleryUI", "start query category album.");
      Object localObject2 = s.czT();
      Object localObject1 = new ArrayList();
      Object localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("albums").build();
      localObject2 = ((s)localObject2).hTQ.query((Uri)localObject3, s.czU(), null, null, null);
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
          ((s.a)localObject3).gp(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
          ((s.a)localObject3).rCc = ((Cursor)localObject2).getString(k);
          ((s.a)localObject3).rBh = ((Cursor)localObject2).getString(m);
          ((s.a)localObject3).rCd = bt.aGh(((Cursor)localObject2).getString(n));
          ((s.a)localObject3).rCe = bt.aGi(((Cursor)localObject2).getString(i1));
          ((s.a)localObject3).rCf = ((Cursor)localObject2).getString(i2);
          String str = ((Cursor)localObject2).getString(i3);
          if (!bt.isNullOrNil(str)) {
            ((s.a)localObject3).rCg = s.go(str, ((s.a)localObject3).rCc);
          }
          ((List)localObject1).add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = s.dK((List)localObject1);
      ad.i("MicroMsg.SmartGalleryUI", "finish query category album.");
      long l2 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.vKh.f(19165, new Object[] { "", Long.valueOf(l2 - l1) });
      localObject1 = new SmartGalleryUI.g(this.rLI, (s.c)localObject1);
      ((SmartGalleryUI.g)localObject1).rLJ = this.rLJ;
      ((SmartGalleryUI.g)localObject1).rLK = this.rLK;
      e.czi().f((Runnable)localObject1);
      AppMethodBeat.o(111690);
    }
  }
  
  static final class e
    implements Runnable
  {
    String rLL;
    SmartGalleryUI.h rLM;
    
    e(SmartGalleryUI.h paramh)
    {
      this.rLM = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111691);
      if (bt.isNullOrNil(this.rLL))
      {
        ad.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
        AppMethodBeat.o(111691);
        return;
      }
      ad.i("MicroMsg.SmartGalleryUI", "query search start.");
      Object localObject3 = s.czT();
      Object localObject1 = this.rLL;
      Object localObject2 = new ArrayList();
      Object localObject4 = s.BASE_URI.buildUpon().appendEncodedPath("search").build();
      localObject3 = ((s)localObject3).hTQ.query((Uri)localObject4, new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" }, "keyword=?", new String[] { localObject1 }, null);
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
          ((s.a)localObject4).gp(((Cursor)localObject3).getString(i), ((Cursor)localObject3).getString(j));
          ((s.a)localObject4).rCc = ((Cursor)localObject3).getString(k);
          ((s.a)localObject4).rBh = ((Cursor)localObject3).getString(m);
          ((s.a)localObject4).rCd = bt.aGh(((Cursor)localObject3).getString(n));
          ((s.a)localObject4).rCe = bt.aGi(((Cursor)localObject3).getString(i1));
          ((s.a)localObject4).rCf = ((Cursor)localObject3).getString(i2);
          String str = ((Cursor)localObject3).getString(i3);
          if (!bt.isNullOrNil(str)) {
            ((s.a)localObject4).rCg = s.go(str, ((s.a)localObject4).rCc);
          }
          ((List)localObject2).add(localObject4);
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = s.m((List)localObject2, (String)localObject1);
      ad.i("MicroMsg.SmartGalleryUI", "query search finish.");
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
          localObject3 = URLEncoder.encode(this.rLL, "utf-8");
          if (((List)localObject1).size() != 0) {
            continue;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(18270, new Object[] { localObject3, Integer.valueOf(i) });
        }
        catch (Exception localException)
        {
          continue;
        }
        if ((!bt.isNullOrNil(this.rLM.rLL)) && (this.rLM.rLL.equals(this.rLL))) {
          continue;
        }
        ad.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", new Object[] { this.rLL, this.rLM.rLL });
        AppMethodBeat.o(111691);
        return;
        i = 1;
      }
      localObject2 = this.rLM;
      ((SmartGalleryUI.h)localObject2).otO.clear();
      ((SmartGalleryUI.h)localObject2).otO.addAll((Collection)localObject1);
      e.czi().f(this.rLM);
      AppMethodBeat.o(111691);
    }
  }
  
  static final class f
    extends RecyclerView.a<RecyclerView.v>
  {
    private View.OnClickListener hs;
    private Context mContext;
    List<s.i> otO;
    String rLL;
    SmartGalleryUI.c rLw;
    
    f(Context paramContext)
    {
      AppMethodBeat.i(111695);
      this.hs = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111692);
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.f.a(SmartGalleryUI.f.this) != null)) {
            SmartGalleryUI.f.a(SmartGalleryUI.f.this).a((s.a)paramAnonymousView);
          }
          AppMethodBeat.o(111692);
        }
      };
      this.mContext = paramContext;
      this.otO = new ArrayList();
      AppMethodBeat.o(111695);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
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
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(111697);
      Object localObject1;
      if ((paramv instanceof b))
      {
        localObject1 = (s.d)this.otO.get(paramInt);
        b.a((b)paramv).setText(((s.d)localObject1).rCn);
        AppMethodBeat.o(111697);
        return;
      }
      if ((paramv instanceof a))
      {
        localObject1 = (s.a)this.otO.get(paramInt);
        paramv.arI.setOnClickListener(this.hs);
        paramv.arI.setTag(localObject1);
        Object localObject2 = ((s.a)localObject1).rCg;
        paramInt = i;
        ImageView localImageView;
        String str1;
        String str2;
        long l;
        if (localObject2 != null)
        {
          if (((s.b)localObject2).rCi) {
            paramInt = 2;
          }
        }
        else
        {
          localObject2 = (a)paramv;
          localImageView = a.a((a)localObject2);
          str1 = ((s.a)localObject1).rCf;
          str2 = ((s.a)localObject1).rCf;
          l = ((s.a)localObject1).rCe;
          if (((s.a)localObject1).rCg != null) {
            break label220;
          }
        }
        label220:
        for (paramv = null;; paramv = ((s.a)localObject1).rCg.rAs)
        {
          h.a(localImageView, paramInt, str1, str2, l, paramv);
          a.b((a)localObject2).setText(f.a(((s.a)localObject1).rBh, this.rLL));
          a.c((a)localObject2).setText(String.valueOf(((s.a)localObject1).rCd));
          AppMethodBeat.o(111697);
          return;
          paramInt = 1;
          break;
        }
      }
      if ((paramv instanceof c)) {
        ad.i("MicroMsg.SmartGalleryUI", "no search result.");
      }
      AppMethodBeat.o(111697);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111698);
      if (this.otO.size() == 0)
      {
        s.f localf = new s.f();
        this.otO.add(localf);
      }
      int i = this.otO.size();
      AppMethodBeat.o(111698);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(111699);
      paramInt = ((s.i)this.otO.get(paramInt)).mType;
      AppMethodBeat.o(111699);
      return paramInt;
    }
    
    static final class a
      extends RecyclerView.v
    {
      private ImageView rLD;
      private TextView rLE;
      private TextView rLF;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111693);
        this.rLD = ((ImageView)paramView.findViewById(2131296565));
        this.rLE = ((TextView)paramView.findViewById(2131296593));
        this.rLF = ((TextView)paramView.findViewById(2131296542));
        AppMethodBeat.o(111693);
      }
    }
    
    static final class b
      extends RecyclerView.v
    {
      private TextView nxy;
      
      b(View paramView)
      {
        super();
        AppMethodBeat.i(111694);
        this.nxy = ((TextView)paramView.findViewById(2131297928));
        ai.a(this.nxy.getPaint(), 0.8F);
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
    s.c rLG;
    WeakReference<SmartGalleryUI.b> rLI;
    WeakReference<ProgressDialog> rLJ;
    WeakReference<EditText> rLK;
    
    g(WeakReference<SmartGalleryUI.b> paramWeakReference, s.c paramc)
    {
      this.rLI = paramWeakReference;
      this.rLG = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111700);
      if ((this.rLI != null) && (this.rLG != null))
      {
        Object localObject = (SmartGalleryUI.b)this.rLI.get();
        if (localObject != null)
        {
          ad.i("MicroMsg.SmartGalleryUI", "show category.");
          ((SmartGalleryUI.b)localObject).rLG = this.rLG;
          ((RecyclerView.a)localObject).aql.notifyChanged();
        }
        if (this.rLJ != null)
        {
          localObject = (ProgressDialog)this.rLJ.get();
          if (localObject != null)
          {
            ad.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
            ((ProgressDialog)localObject).dismiss();
          }
        }
        if (this.rLK != null)
        {
          localObject = (EditText)this.rLK.get();
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
    List<s.i> otO;
    String rLL;
    WeakReference<RecyclerView> rLO;
    WeakReference<SmartGalleryUI.f> rLP;
    
    h(RecyclerView paramRecyclerView, SmartGalleryUI.f paramf)
    {
      AppMethodBeat.i(111701);
      this.otO = new ArrayList();
      this.rLO = new WeakReference(paramRecyclerView);
      this.rLP = new WeakReference(paramf);
      AppMethodBeat.o(111701);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111702);
      if ((this.rLO == null) || (this.rLP == null))
      {
        ad.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
        AppMethodBeat.o(111702);
        return;
      }
      if (this.otO != null)
      {
        Object localObject = (RecyclerView)this.rLO.get();
        if (localObject != null)
        {
          SmartGalleryUI.f localf = (SmartGalleryUI.f)this.rLP.get();
          if (localf != null)
          {
            ((RecyclerView)localObject).setAdapter(localf);
            localf.rLL = this.rLL;
            localObject = this.otO;
            localf.otO.clear();
            localf.otO.addAll((Collection)localObject);
            localf.aql.notifyChanged();
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