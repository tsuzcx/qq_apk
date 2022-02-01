package com.tencent.mm.plugin.gallery.ui;

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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.t;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.gallery.model.t.b;
import com.tencent.mm.plugin.gallery.model.t.c;
import com.tencent.mm.plugin.gallery.model.t.d;
import com.tencent.mm.plugin.gallery.model.t.f;
import com.tencent.mm.plugin.gallery.model.t.i;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bd;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SmartGalleryUI
  extends MMActivity
{
  public static int HQv = 1;
  private String HHP;
  private boolean HLE;
  private RecyclerView HQk;
  private EditText HQl;
  private SmartGalleryUI.b HQm;
  private f HQn;
  private e HQo;
  private SmartGalleryUI.h HQp;
  private int HQq;
  private boolean HQr;
  androidx.recyclerview.widget.h HQs;
  private boolean HQt;
  c HQu;
  private int sfB;
  private ProgressDialog vEG;
  Button xXJ;
  
  public SmartGalleryUI()
  {
    AppMethodBeat.i(111703);
    this.HQr = false;
    this.HQt = true;
    this.HQu = new c()
    {
      public final void a(t.a paramAnonymousa)
      {
        AppMethodBeat.i(111677);
        Log.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", new Object[] { paramAnonymousa.HIx, paramAnonymousa.albumName });
        Intent localIntent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
        localIntent.putExtras(SmartGalleryUI.this.getIntent());
        localIntent.putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this));
        if (SmartGalleryUI.h(SmartGalleryUI.this)) {
          if ((paramAnonymousa.HIB != null) && (paramAnonymousa.HIB.HIC)) {
            localIntent.putExtra("select_type_tag", 1);
          }
        }
        try
        {
          while ((paramAnonymousa.HIw != null) && (paramAnonymousa.HIw.HIH != null))
          {
            Object localObject = paramAnonymousa.HIw.HIH;
            String str2 = "";
            if (paramAnonymousa.albumName != null) {
              str2 = paramAnonymousa.albumName;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(18269, new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(str2, "utf-8") });
            localIntent.putExtra("is_from_smart_gallery", true);
            str2 = paramAnonymousa.albumName;
            localObject = str2;
            if (Util.isNullOrNil(str2)) {
              localObject = paramAnonymousa.HIw.HIH;
            }
            localIntent.putExtra("title_from_smart_gallery", (String)localObject);
            localIntent.putExtra("album_id_from_smart_gallery", paramAnonymousa.HIx);
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
    this.HLE = false;
    AppMethodBeat.o(111703);
  }
  
  private void fBO()
  {
    AppMethodBeat.i(111706);
    int i = t.fAV().fAY();
    if (i > 0) {
      this.xXJ.setEnabled(true);
    }
    for (;;)
    {
      this.xXJ.setText(com.tencent.mm.plugin.gallery.b.h.a(this, this.sfB, i, this.HQq, this.HHP, null));
      AppMethodBeat.o(111706);
      return;
      this.xXJ.setEnabled(false);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.smart_gallery_layout;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(111707);
    Log.i("MicroMsg.SmartGalleryUI", "requestCode: %d, resultCode: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent != null)
    {
      this.HLE = paramIntent.getBooleanExtra("send_raw_img", false);
      paramIntent.putExtra("send_raw_img", this.HLE);
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
        fBO();
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
    this.sfB = getIntent().getIntExtra("query_source_type", 3);
    this.HQq = getIntent().getIntExtra("max_select_count", 9);
    this.HHP = getIntent().getStringExtra("album_business_tag");
    this.HLE = getIntent().getBooleanExtra("send_raw_img", false);
    this.vEG = w.a(this, getString(b.i.app_waiting), true);
    this.vEG.show();
    setActionbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    setNavigationbarColor(getResources().getColor(b.b.gallery_dark_mode_color));
    paramBundle = LayoutInflater.from(this).inflate(b.f.action_bar_smart_gallery, new LinearLayout(this), false);
    paramBundle.findViewById(b.e.smart_gallery_back).setOnClickListener(new SmartGalleryUI.1(this));
    this.HQl = ((EditText)paramBundle.findViewById(b.e.smart_gallery_search));
    this.HQl.setOnTouchListener(new SmartGalleryUI.2(this));
    this.HQl.setOnEditorActionListener(new SmartGalleryUI.3(this));
    this.HQl.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(111674);
        paramAnonymousEditable = paramAnonymousEditable.toString();
        Log.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", new Object[] { paramAnonymousEditable });
        SmartGalleryUI.d(SmartGalleryUI.this).HQI = paramAnonymousEditable;
        if (Util.isNullOrNil(paramAnonymousEditable))
        {
          SmartGalleryUI.e(SmartGalleryUI.this);
          SmartGalleryUI.g(SmartGalleryUI.this).setAdapter(SmartGalleryUI.f(SmartGalleryUI.this));
          SmartGalleryUI.g(SmartGalleryUI.this).a(SmartGalleryUI.this.HQs);
          SmartGalleryUI.f(SmartGalleryUI.this).bZE.notifyChanged();
          AppMethodBeat.o(111674);
          return;
        }
        SmartGalleryUI.a(SmartGalleryUI.this, paramAnonymousEditable, false);
        AppMethodBeat.o(111674);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.xXJ = ((Button)paramBundle.findViewById(b.e.smart_gallery_send));
    fBO();
    this.xXJ.setOnClickListener(new SmartGalleryUI.5(this));
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      localActionBar.x(false);
      localActionBar.w(false);
      localActionBar.v(false);
      localActionBar.y(true);
      localActionBar.setCustomView(paramBundle);
    }
    for (;;)
    {
      this.HQs = new androidx.recyclerview.widget.h(this, 1);
      this.HQs.w(getResources().getDrawable(b.d.smart_gallery_divider));
      this.HQk = ((RecyclerView)findViewById(b.e.smart_gallery_recycler_view));
      this.HQk.a(new SmartGalleryUI.6(this));
      this.HQk.a(this.HQs);
      this.HQm = new SmartGalleryUI.b(this);
      this.HQm.HQu = this.HQu;
      this.HQn = new f(this);
      this.HQn.HQu = this.HQu;
      this.HQk.setLayoutManager(new LinearLayoutManager());
      this.HQk.setAdapter(this.HQm);
      this.HQp = new SmartGalleryUI.h(this.HQk, this.HQn);
      this.HQo = new e(this.HQp);
      e.fAo().aG(new d(this.HQm, this.vEG, this.HQl));
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
    t.fAV().fAX();
    AppMethodBeat.o(111710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111708);
    if ((4 == paramInt) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (Util.isNullOrNil(this.HQl.getText()))
      {
        setResult(-2, getIntent().putExtra("send_raw_img", this.HLE));
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(111708);
        return true;
        this.HQl.setText("");
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
    this.HQl.clearFocus();
    AppMethodBeat.o(111709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111705);
    super.onResume();
    fBO();
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
    private View.OnLongClickListener HLH;
    SmartGalleryUI.c HQu;
    List<t.a> HQx;
    private int HQy;
    View.OnClickListener dpY;
    private Context mContext;
    
    a(Context paramContext)
    {
      AppMethodBeat.i(111681);
      this.dpY = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111678);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof t.a)) && (SmartGalleryUI.a.a(SmartGalleryUI.a.this) != null)) {
            SmartGalleryUI.a.a(SmartGalleryUI.a.this).a((t.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111678);
        }
      };
      this.HLH = new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111679);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          paramAnonymousView = paramAnonymousView.getTag();
          if ((paramAnonymousView instanceof t.a))
          {
            paramAnonymousView = (t.a)paramAnonymousView;
            ClipboardHelper.setText(SmartGalleryUI.a.b(SmartGalleryUI.a.this), "media info", paramAnonymousView.toString());
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(111679);
          return true;
        }
      };
      this.mContext = paramContext;
      this.HQx = new ArrayList();
      this.HQy = ((this.mContext.getResources().getDisplayMetrics().widthPixels - bd.bs(this.mContext, b.c.Edge_2A) - bd.bs(this.mContext, b.c.Edge_A) * 4) / 9 * 2);
      Log.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", new Object[] { Integer.valueOf(this.HQy) });
      AppMethodBeat.o(111681);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111682);
      int i = this.HQx.size();
      AppMethodBeat.o(111682);
      return i;
    }
    
    static final class a
      extends RecyclerView.v
    {
      ImageView HQA;
      TextView HQB;
      TextView HQC;
      
      a(View paramView, int paramInt)
      {
        super();
        AppMethodBeat.i(111680);
        this.HQA = ((ImageView)paramView.findViewById(b.e.album_cover));
        ViewGroup.LayoutParams localLayoutParams = this.HQA.getLayoutParams();
        localLayoutParams.width = paramInt;
        localLayoutParams.height = paramInt;
        this.HQA.setLayoutParams(localLayoutParams);
        this.HQB = ((TextView)paramView.findViewById(b.e.album_name));
        this.HQC = ((TextView)paramView.findViewById(b.e.album_capacity));
        AppMethodBeat.o(111680);
      }
    }
  }
  
  static abstract interface c
  {
    public abstract void a(t.a parama);
  }
  
  static final class d
    implements Runnable
  {
    WeakReference<SmartGalleryUI.b> HQF;
    WeakReference<ProgressDialog> HQG;
    WeakReference<EditText> HQH;
    
    d(SmartGalleryUI.b paramb, ProgressDialog paramProgressDialog, EditText paramEditText)
    {
      AppMethodBeat.i(111689);
      this.HQF = new WeakReference(paramb);
      this.HQG = new WeakReference(paramProgressDialog);
      this.HQH = new WeakReference(paramEditText);
      AppMethodBeat.o(111689);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111690);
      long l1 = System.currentTimeMillis();
      Log.i("MicroMsg.SmartGalleryUI", "start query category album.");
      Object localObject2 = t.fAV();
      Object localObject1 = new ArrayList();
      if (!i.s(MMApplicationContext.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
        Log.i("MicroMsg.SmartGalleryQueryUtil", "queryAlbum without READ_EXTERNAL_STORAGE.");
      }
      for (;;)
      {
        localObject1 = t.ib((List)localObject1);
        Log.i("MicroMsg.SmartGalleryUI", "finish query category album.");
        long l2 = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.h.OAn.b(19165, new Object[] { "", Long.valueOf(l2 - l1) });
        localObject1 = new SmartGalleryUI.g(this.HQF, (t.c)localObject1);
        ((SmartGalleryUI.g)localObject1).HQG = this.HQG;
        ((SmartGalleryUI.g)localObject1).HQH = this.HQH;
        e.fAo().postToMainThread((Runnable)localObject1);
        AppMethodBeat.o(111690);
        return;
        Log.i("MicroMsg.SmartGalleryQueryUtil", "has permiss.");
        Object localObject3 = t.dYo.buildUpon().appendEncodedPath("albums").build();
        localObject2 = ((t)localObject2).mJn.query((Uri)localObject3, t.fAW(), null, null, null);
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
            localObject3 = new t.a();
            ((t.a)localObject3).iM(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
            ((t.a)localObject3).HIx = ((Cursor)localObject2).getString(k);
            ((t.a)localObject3).albumName = ((Cursor)localObject2).getString(m);
            ((t.a)localObject3).HIy = Util.safeParseInt(((Cursor)localObject2).getString(n));
            ((t.a)localObject3).HIz = Util.safeParseLong(((Cursor)localObject2).getString(i1));
            ((t.a)localObject3).HIA = ((Cursor)localObject2).getString(i2);
            String str = ((Cursor)localObject2).getString(i3);
            if (!Util.isNullOrNil(str)) {
              ((t.a)localObject3).HIB = t.iL(str, ((t.a)localObject3).HIx);
            }
            ((List)localObject1).add(localObject3);
          }
          ((Cursor)localObject2).close();
        }
      }
    }
  }
  
  static final class e
    implements Runnable
  {
    String HQI;
    SmartGalleryUI.h HQJ;
    
    e(SmartGalleryUI.h paramh)
    {
      this.HQJ = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111691);
      if (Util.isNullOrNil(this.HQI))
      {
        Log.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
        AppMethodBeat.o(111691);
        return;
      }
      Log.i("MicroMsg.SmartGalleryUI", "query search start.");
      Object localObject3 = t.fAV();
      Object localObject1 = this.HQI;
      Object localObject2 = new ArrayList();
      if (!i.s(MMApplicationContext.getContext(), "android.permission.READ_EXTERNAL_STORAGE"))
      {
        Log.i("MicroMsg.SmartGalleryQueryUtil", "isCategoryInfoValid without READ_EXTERNAL_STORAGE.");
        localObject1 = t.x((List)localObject2, (String)localObject1);
        Log.i("MicroMsg.SmartGalleryUI", "query search finish.");
      }
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
          localObject3 = URLEncoder.encode(this.HQI, "utf-8");
          if (((List)localObject1).size() != 0) {
            continue;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(18270, new Object[] { localObject3, Integer.valueOf(i) });
        }
        catch (Exception localException)
        {
          int i;
          Object localObject4;
          int j;
          int k;
          int m;
          int n;
          int i1;
          int i2;
          int i3;
          String str;
          continue;
        }
        if ((!Util.isNullOrNil(this.HQJ.HQI)) && (this.HQJ.HQI.equals(this.HQI))) {
          continue;
        }
        Log.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", new Object[] { this.HQI, this.HQJ.HQI });
        AppMethodBeat.o(111691);
        return;
        Log.i("MicroMsg.SmartGalleryQueryUtil", "has permiss.");
        localObject4 = t.dYo.buildUpon().appendEncodedPath("search").build();
        localObject3 = ((t)localObject3).mJn.query((Uri)localObject4, new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" }, "keyword=?", new String[] { localObject1 }, null);
        if (localObject3 == null) {
          break;
        }
        i = ((Cursor)localObject3).getColumnIndex("categoryID");
        j = ((Cursor)localObject3).getColumnIndex("categoryName");
        k = ((Cursor)localObject3).getColumnIndex("albumID");
        m = ((Cursor)localObject3).getColumnIndex("albumName");
        n = ((Cursor)localObject3).getColumnIndex("albumCapacity");
        i1 = ((Cursor)localObject3).getColumnIndex("coverID");
        i2 = ((Cursor)localObject3).getColumnIndex("coverData");
        i3 = ((Cursor)localObject3).getColumnIndex("albumTag");
        if (((Cursor)localObject3).moveToNext())
        {
          localObject4 = new t.a();
          ((t.a)localObject4).iM(((Cursor)localObject3).getString(i), ((Cursor)localObject3).getString(j));
          ((t.a)localObject4).HIx = ((Cursor)localObject3).getString(k);
          ((t.a)localObject4).albumName = ((Cursor)localObject3).getString(m);
          ((t.a)localObject4).HIy = Util.safeParseInt(((Cursor)localObject3).getString(n));
          ((t.a)localObject4).HIz = Util.safeParseLong(((Cursor)localObject3).getString(i1));
          ((t.a)localObject4).HIA = ((Cursor)localObject3).getString(i2);
          str = ((Cursor)localObject3).getString(i3);
          if (!Util.isNullOrNil(str)) {
            ((t.a)localObject4).HIB = t.iL(str, ((t.a)localObject4).HIx);
          }
          ((List)localObject2).add(localObject4);
        }
        else
        {
          ((Cursor)localObject3).close();
          break;
          i = 1;
        }
      }
      localObject2 = this.HQJ;
      ((SmartGalleryUI.h)localObject2).xGG.clear();
      ((SmartGalleryUI.h)localObject2).xGG.addAll((Collection)localObject1);
      e.fAo().postToMainThread(this.HQJ);
      AppMethodBeat.o(111691);
    }
  }
  
  static final class f
    extends RecyclerView.a<RecyclerView.v>
  {
    String HQI;
    SmartGalleryUI.c HQu;
    private View.OnClickListener dpY;
    private Context mContext;
    List<t.i> xGG;
    
    f(Context paramContext)
    {
      AppMethodBeat.i(111695);
      this.dpY = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(111692);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = paramAnonymousView.getTag();
          if (((paramAnonymousView instanceof t.a)) && (SmartGalleryUI.f.a(SmartGalleryUI.f.this) != null)) {
            SmartGalleryUI.f.a(SmartGalleryUI.f.this).a((t.a)paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(111692);
        }
      };
      this.mContext = paramContext;
      this.xGG = new ArrayList();
      AppMethodBeat.o(111695);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(289443);
      if (paramInt == 0)
      {
        paramViewGroup = new SmartGalleryUI.f.b(LayoutInflater.from(this.mContext).inflate(b.f.smart_gallery_search_category_item_layout, paramViewGroup, false));
        AppMethodBeat.o(289443);
        return paramViewGroup;
      }
      if (1 == paramInt)
      {
        paramViewGroup = new a(LayoutInflater.from(this.mContext).inflate(b.f.smart_gallery_search_album_item_layout, paramViewGroup, false));
        AppMethodBeat.o(289443);
        return paramViewGroup;
      }
      paramViewGroup = new SmartGalleryUI.f.c(LayoutInflater.from(this.mContext).inflate(b.f.smart_gallery_search_empty_item_layout, paramViewGroup, false));
      AppMethodBeat.o(289443);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(289447);
      Object localObject1;
      if ((paramv instanceof SmartGalleryUI.f.b))
      {
        localObject1 = (t.d)this.xGG.get(paramInt);
        SmartGalleryUI.f.b.a((SmartGalleryUI.f.b)paramv).setText(((t.d)localObject1).HIH);
        AppMethodBeat.o(289447);
        return;
      }
      if ((paramv instanceof a))
      {
        localObject1 = (t.a)this.xGG.get(paramInt);
        paramv.caK.setOnClickListener(this.dpY);
        paramv.caK.setTag(localObject1);
        Object localObject2 = ((t.a)localObject1).HIB;
        paramInt = i;
        ImageView localImageView;
        String str1;
        String str2;
        long l;
        if (localObject2 != null)
        {
          if (((t.b)localObject2).HID) {
            paramInt = 2;
          }
        }
        else
        {
          localObject2 = (a)paramv;
          localImageView = a.a((a)localObject2);
          str1 = ((t.a)localObject1).HIA;
          str2 = ((t.a)localObject1).HIA;
          l = ((t.a)localObject1).HIz;
          if (((t.a)localObject1).HIB != null) {
            break label220;
          }
        }
        label220:
        for (paramv = null;; paramv = ((t.a)localObject1).HIB.HGH)
        {
          h.a(localImageView, paramInt, str1, str2, l, paramv);
          a.b((a)localObject2).setText(f.b(((t.a)localObject1).albumName, this.HQI));
          a.c((a)localObject2).setText(String.valueOf(((t.a)localObject1).HIy));
          AppMethodBeat.o(289447);
          return;
          paramInt = 1;
          break;
        }
      }
      if ((paramv instanceof SmartGalleryUI.f.c)) {
        Log.i("MicroMsg.SmartGalleryUI", "no search result.");
      }
      AppMethodBeat.o(289447);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111698);
      if (this.xGG.size() == 0)
      {
        t.f localf = new t.f();
        this.xGG.add(localf);
      }
      int i = this.xGG.size();
      AppMethodBeat.o(111698);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(111699);
      paramInt = ((t.i)this.xGG.get(paramInt)).mType;
      AppMethodBeat.o(111699);
      return paramInt;
    }
    
    static final class a
      extends RecyclerView.v
    {
      private ImageView HQA;
      private TextView HQB;
      private TextView HQC;
      
      a(View paramView)
      {
        super();
        AppMethodBeat.i(111693);
        this.HQA = ((ImageView)paramView.findViewById(b.e.album_cover));
        this.HQB = ((TextView)paramView.findViewById(b.e.album_name));
        this.HQC = ((TextView)paramView.findViewById(b.e.album_capacity));
        AppMethodBeat.o(111693);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI
 * JD-Core Version:    0.7.0.1
 */