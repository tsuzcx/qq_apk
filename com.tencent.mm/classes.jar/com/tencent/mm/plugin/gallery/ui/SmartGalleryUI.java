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
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.w;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@a(19)
public class SmartGalleryUI
  extends MMActivity
{
  public static int sTn = 1;
  private int kxr;
  private ProgressDialog nxV;
  Button pkJ;
  private String sKn;
  private RecyclerView sTb;
  private EditText sTc;
  private SmartGalleryUI.b sTd;
  private f sTe;
  private e sTf;
  private SmartGalleryUI.h sTg;
  private int sTh;
  private boolean sTi;
  w sTj;
  private boolean sTk;
  SmartGalleryUI.c sTl;
  private boolean sTm;
  
  public SmartGalleryUI()
  {
    AppMethodBeat.i(111703);
    this.sTi = false;
    this.sTk = true;
    this.sTl = new SmartGalleryUI.c()
    {
      public final void a(s.a paramAnonymousa)
      {
        AppMethodBeat.i(111677);
        ac.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", new Object[] { paramAnonymousa.sKV, paramAnonymousa.sJZ });
        Intent localIntent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
        localIntent.putExtras(SmartGalleryUI.this.getIntent());
        localIntent.putExtra("send_raw_img", SmartGalleryUI.b(SmartGalleryUI.this));
        if (SmartGalleryUI.h(SmartGalleryUI.this)) {
          if ((paramAnonymousa.sKZ != null) && (paramAnonymousa.sKZ.sLa)) {
            localIntent.putExtra("select_type_tag", 1);
          }
        }
        try
        {
          while ((paramAnonymousa.sKU != null) && (paramAnonymousa.sKU.sLh != null))
          {
            Object localObject = paramAnonymousa.sKU.sLh;
            String str2 = "";
            if (paramAnonymousa.sJZ != null) {
              str2 = paramAnonymousa.sJZ;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(18269, new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(str2, "utf-8") });
            localIntent.putExtra("is_from_smart_gallery", true);
            str2 = paramAnonymousa.sJZ;
            localObject = str2;
            if (bs.isNullOrNil(str2)) {
              localObject = paramAnonymousa.sKU.sLh;
            }
            localIntent.putExtra("title_from_smart_gallery", (String)localObject);
            localIntent.putExtra("album_id_from_smart_gallery", paramAnonymousa.sKV);
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
    this.sTm = false;
    AppMethodBeat.o(111703);
  }
  
  private void cNX()
  {
    AppMethodBeat.i(111706);
    int i = s.cNf().cNj();
    if (i > 0) {
      this.pkJ.setEnabled(true);
    }
    for (;;)
    {
      this.pkJ.setText(d.a(this, this.kxr, i, this.sTh, this.sKn, null));
      AppMethodBeat.o(111706);
      return;
      this.pkJ.setEnabled(false);
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
    ac.i("MicroMsg.SmartGalleryUI", "requestCode: %d, resultCode: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent != null)
    {
      this.sTm = paramIntent.getBooleanExtra("send_raw_img", false);
      paramIntent.putExtra("send_raw_img", this.sTm);
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ac.i("MicroMsg.SmartGalleryUI", "key: %s, value: %s.", new Object[] { str, localBundle.get(str) });
        }
      }
    }
    if (1 == paramInt1)
    {
      if ((-2 == paramInt2) || (paramInt2 == 0))
      {
        ac.i("MicroMsg.SmartGalleryUI", "just back from AlbumPreviewUI.");
        cNX();
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
    this.kxr = getIntent().getIntExtra("query_source_type", 3);
    this.sTh = getIntent().getIntExtra("max_select_count", 9);
    this.sKn = getIntent().getStringExtra("album_business_tag");
    this.sTm = getIntent().getBooleanExtra("send_raw_img", false);
    this.nxV = p.a(this, getString(2131755936), true);
    this.nxV.show();
    setActionbarColor(getResources().getColor(2131100399));
    setNavigationbarColor(getResources().getColor(2131100399));
    paramBundle = LayoutInflater.from(this).inflate(2131492919, new LinearLayout(this), false);
    paramBundle.findViewById(2131304858).setOnClickListener(new SmartGalleryUI.1(this));
    this.sTc = ((EditText)paramBundle.findViewById(2131304860));
    this.sTc.setOnTouchListener(new SmartGalleryUI.2(this));
    this.sTc.setOnEditorActionListener(new SmartGalleryUI.3(this));
    this.sTc.addTextChangedListener(new SmartGalleryUI.4(this));
    this.pkJ = ((Button)paramBundle.findViewById(2131304861));
    cNX();
    this.pkJ.setOnClickListener(new SmartGalleryUI.5(this));
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
    {
      localActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
      localActionBar.fU();
      localActionBar.setDisplayHomeAsUpEnabled(false);
      localActionBar.fT();
      localActionBar.fV();
      localActionBar.setCustomView(paramBundle);
    }
    for (;;)
    {
      this.sTj = new w(this);
      this.sTj.setDrawable(getResources().getDrawable(2131234071));
      this.sTb = ((RecyclerView)findViewById(2131304859));
      this.sTb.a(new SmartGalleryUI.6(this));
      this.sTb.a(this.sTj);
      this.sTd = new SmartGalleryUI.b(this);
      this.sTd.sTl = this.sTl;
      this.sTe = new f(this);
      this.sTe.sTl = this.sTl;
      this.sTb.setLayoutManager(new LinearLayoutManager());
      this.sTb.setAdapter(this.sTd);
      this.sTg = new SmartGalleryUI.h(this.sTb, this.sTe);
      this.sTf = new e(this.sTg);
      e.cMu().am(new d(this.sTd, this.nxV, this.sTc));
      AppMethodBeat.o(111704);
      return;
      ac.e("MicroMsg.SmartGalleryUI", "actionbar is null.");
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
    s.cNf().cNi();
    AppMethodBeat.o(111710);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(111708);
    if ((4 == paramInt) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (bs.aj(this.sTc.getText()))
      {
        setResult(-2, getIntent().putExtra("send_raw_img", this.sTm));
        finish();
      }
      for (;;)
      {
        AppMethodBeat.o(111708);
        return true;
        this.sTc.setText("");
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
    this.sTc.clearFocus();
    AppMethodBeat.o(111709);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(111705);
    super.onResume();
    cNX();
    AppMethodBeat.o(111705);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class d
    implements Runnable
  {
    WeakReference<SmartGalleryUI.b> sTx;
    WeakReference<ProgressDialog> sTy;
    WeakReference<EditText> sTz;
    
    d(SmartGalleryUI.b paramb, ProgressDialog paramProgressDialog, EditText paramEditText)
    {
      AppMethodBeat.i(111689);
      this.sTx = new WeakReference(paramb);
      this.sTy = new WeakReference(paramProgressDialog);
      this.sTz = new WeakReference(paramEditText);
      AppMethodBeat.o(111689);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111690);
      long l1 = System.currentTimeMillis();
      ac.i("MicroMsg.SmartGalleryUI", "start query category album.");
      Object localObject2 = s.cNf();
      Object localObject1 = new ArrayList();
      Object localObject3 = s.BASE_URI.buildUpon().appendEncodedPath("albums").build();
      localObject2 = ((s)localObject2).gne.query((Uri)localObject3, s.cNg(), null, null, null);
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
          ((s.a)localObject3).gG(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
          ((s.a)localObject3).sKV = ((Cursor)localObject2).getString(k);
          ((s.a)localObject3).sJZ = ((Cursor)localObject2).getString(m);
          ((s.a)localObject3).sKW = bs.aLy(((Cursor)localObject2).getString(n));
          ((s.a)localObject3).sKX = bs.aLz(((Cursor)localObject2).getString(i1));
          ((s.a)localObject3).sKY = ((Cursor)localObject2).getString(i2);
          String str = ((Cursor)localObject2).getString(i3);
          if (!bs.isNullOrNil(str)) {
            ((s.a)localObject3).sKZ = s.gF(str, ((s.a)localObject3).sKV);
          }
          ((List)localObject1).add(localObject3);
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = s.dO((List)localObject1);
      ac.i("MicroMsg.SmartGalleryUI", "finish query category album.");
      long l2 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.wUl.f(19165, new Object[] { "", Long.valueOf(l2 - l1) });
      localObject1 = new SmartGalleryUI.g(this.sTx, (s.c)localObject1);
      ((SmartGalleryUI.g)localObject1).sTy = this.sTy;
      ((SmartGalleryUI.g)localObject1).sTz = this.sTz;
      e.cMu().f((Runnable)localObject1);
      AppMethodBeat.o(111690);
    }
  }
  
  static final class e
    implements Runnable
  {
    String sTA;
    SmartGalleryUI.h sTB;
    
    e(SmartGalleryUI.h paramh)
    {
      this.sTB = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(111691);
      if (bs.isNullOrNil(this.sTA))
      {
        ac.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
        AppMethodBeat.o(111691);
        return;
      }
      ac.i("MicroMsg.SmartGalleryUI", "query search start.");
      Object localObject3 = s.cNf();
      Object localObject1 = this.sTA;
      Object localObject2 = new ArrayList();
      Object localObject4 = s.BASE_URI.buildUpon().appendEncodedPath("search").build();
      localObject3 = ((s)localObject3).gne.query((Uri)localObject4, new String[] { "categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag" }, "keyword=?", new String[] { localObject1 }, null);
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
          ((s.a)localObject4).gG(((Cursor)localObject3).getString(i), ((Cursor)localObject3).getString(j));
          ((s.a)localObject4).sKV = ((Cursor)localObject3).getString(k);
          ((s.a)localObject4).sJZ = ((Cursor)localObject3).getString(m);
          ((s.a)localObject4).sKW = bs.aLy(((Cursor)localObject3).getString(n));
          ((s.a)localObject4).sKX = bs.aLz(((Cursor)localObject3).getString(i1));
          ((s.a)localObject4).sKY = ((Cursor)localObject3).getString(i2);
          String str = ((Cursor)localObject3).getString(i3);
          if (!bs.isNullOrNil(str)) {
            ((s.a)localObject4).sKZ = s.gF(str, ((s.a)localObject4).sKV);
          }
          ((List)localObject2).add(localObject4);
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = s.m((List)localObject2, (String)localObject1);
      ac.i("MicroMsg.SmartGalleryUI", "query search finish.");
      for (;;)
      {
        try
        {
          localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
          localObject3 = URLEncoder.encode(this.sTA, "utf-8");
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
        if ((!bs.isNullOrNil(this.sTB.sTA)) && (this.sTB.sTA.equals(this.sTA))) {
          continue;
        }
        ac.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", new Object[] { this.sTA, this.sTB.sTA });
        AppMethodBeat.o(111691);
        return;
        i = 1;
      }
      localObject2 = this.sTB;
      ((SmartGalleryUI.h)localObject2).oXp.clear();
      ((SmartGalleryUI.h)localObject2).oXp.addAll((Collection)localObject1);
      e.cMu().f(this.sTB);
      AppMethodBeat.o(111691);
    }
  }
  
  static final class f
    extends RecyclerView.a<RecyclerView.w>
  {
    private View.OnClickListener iu;
    private Context mContext;
    List<s.i> oXp;
    String sTA;
    SmartGalleryUI.c sTl;
    
    f(Context paramContext)
    {
      AppMethodBeat.i(111695);
      this.iu = new SmartGalleryUI.f.1(this);
      this.mContext = paramContext;
      this.oXp = new ArrayList();
      AppMethodBeat.o(111695);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(111696);
      if (paramInt == 0)
      {
        paramViewGroup = new SmartGalleryUI.f.b(LayoutInflater.from(this.mContext).inflate(2131495476, paramViewGroup, false));
        AppMethodBeat.o(111696);
        return paramViewGroup;
      }
      if (1 == paramInt)
      {
        paramViewGroup = new SmartGalleryUI.f.a(LayoutInflater.from(this.mContext).inflate(2131495475, paramViewGroup, false));
        AppMethodBeat.o(111696);
        return paramViewGroup;
      }
      paramViewGroup = new SmartGalleryUI.f.c(LayoutInflater.from(this.mContext).inflate(2131495477, paramViewGroup, false));
      AppMethodBeat.o(111696);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(111697);
      Object localObject1;
      if ((paramw instanceof SmartGalleryUI.f.b))
      {
        localObject1 = (s.d)this.oXp.get(paramInt);
        SmartGalleryUI.f.b.a((SmartGalleryUI.f.b)paramw).setText(((s.d)localObject1).sLh);
        AppMethodBeat.o(111697);
        return;
      }
      if ((paramw instanceof SmartGalleryUI.f.a))
      {
        localObject1 = (s.a)this.oXp.get(paramInt);
        paramw.asD.setOnClickListener(this.iu);
        paramw.asD.setTag(localObject1);
        Object localObject2 = ((s.a)localObject1).sKZ;
        paramInt = i;
        ImageView localImageView;
        String str1;
        String str2;
        long l;
        if (localObject2 != null)
        {
          if (((s.b)localObject2).sLb) {
            paramInt = 2;
          }
        }
        else
        {
          localObject2 = (SmartGalleryUI.f.a)paramw;
          localImageView = SmartGalleryUI.f.a.a((SmartGalleryUI.f.a)localObject2);
          str1 = ((s.a)localObject1).sKY;
          str2 = ((s.a)localObject1).sKY;
          l = ((s.a)localObject1).sKX;
          if (((s.a)localObject1).sKZ != null) {
            break label220;
          }
        }
        label220:
        for (paramw = null;; paramw = ((s.a)localObject1).sKZ.sJk)
        {
          h.a(localImageView, paramInt, str1, str2, l, paramw);
          SmartGalleryUI.f.a.b((SmartGalleryUI.f.a)localObject2).setText(f.b(((s.a)localObject1).sJZ, this.sTA));
          SmartGalleryUI.f.a.c((SmartGalleryUI.f.a)localObject2).setText(String.valueOf(((s.a)localObject1).sKW));
          AppMethodBeat.o(111697);
          return;
          paramInt = 1;
          break;
        }
      }
      if ((paramw instanceof SmartGalleryUI.f.c)) {
        ac.i("MicroMsg.SmartGalleryUI", "no search result.");
      }
      AppMethodBeat.o(111697);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(111698);
      if (this.oXp.size() == 0)
      {
        s.f localf = new s.f();
        this.oXp.add(localf);
      }
      int i = this.oXp.size();
      AppMethodBeat.o(111698);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(111699);
      paramInt = ((s.i)this.oXp.get(paramInt)).mType;
      AppMethodBeat.o(111699);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI
 * JD-Core Version:    0.7.0.1
 */