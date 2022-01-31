package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, com.tencent.mm.plugin.fav.a.p
{
  private boolean cBz;
  private ArrayList<f> iRT;
  private MMGestureGallery kuC;
  private n.d loG;
  private int mwo;
  private a mwp;
  private com.tencent.mm.ui.widget.b.d mwq;
  private Map<String, b> mwr;
  private long mws;
  private com.tencent.mm.sdk.b.c mwt;
  
  public FavImgGalleryUI()
  {
    AppMethodBeat.i(74020);
    this.mwo = 0;
    this.cBz = true;
    this.mwr = new HashMap();
    this.loG = new FavImgGalleryUI.9(this);
    this.mwt = new FavImgGalleryUI.3(this);
    AppMethodBeat.o(74020);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(74023);
    this.mws = getIntent().getLongExtra("key_detail_info_id", -1L);
    String str = getIntent().getStringExtra("key_detail_data_id");
    boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
    Object localObject = getIntent().getStringExtra("fav_note_xml");
    ArrayList localArrayList = new ArrayList();
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mws);
    long l = this.mws;
    boolean bool1;
    if (localg != null)
    {
      bool1 = true;
      ab.i("MicroMsg.FavImgGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((!bool2) || (bo.isNullOrNil((String)localObject))) {
        break label437;
      }
      localg = b.ND((String)localObject);
    }
    label434:
    label437:
    for (;;)
    {
      if (localg != null) {
        localArrayList.add(localg);
      }
      this.iRT.clear();
      final int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label184:
      int j;
      if (k < m)
      {
        localg = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = localg.field_favProto.wVc.size();
        j = 0;
        label218:
        if (j < n)
        {
          localObject = (aca)localg.field_favProto.wVc.get(j);
          if (((((aca)localObject).dataType == 8) && (!r.aoY(b.b((aca)localObject)))) || ((((aca)localObject).dataType != 2) && (((aca)localObject).dataType != 8))) {
            break label434;
          }
          f localf = new f(localg, (aca)localObject);
          this.iRT.add(localf);
          if ((str == null) || (!str.equals(((aca)localObject).mBq))) {
            break label434;
          }
          i = this.iRT.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label218;
        bool1 = false;
        break;
        j = i;
        if (str == null)
        {
          j = i;
          if (localg.field_localId == this.mws) {
            j = this.iRT.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label184;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mwp.notifyDataSetChanged();
        this.kuC.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(74010);
            if (i != -1)
            {
              ab.d("MicroMsg.FavImgGalleryUI", "match selection %d", new Object[] { Integer.valueOf(i) });
              FavImgGalleryUI.a(FavImgGalleryUI.this).setSelection(i);
              FavImgGalleryUI.a(FavImgGalleryUI.this, i);
              AppMethodBeat.o(74010);
              return;
            }
            if ((FavImgGalleryUI.e(FavImgGalleryUI.this) - 1 >= 0) && (FavImgGalleryUI.e(FavImgGalleryUI.this) - 1 < FavImgGalleryUI.i(FavImgGalleryUI.this).size()))
            {
              ab.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.e(FavImgGalleryUI.this) - 1), Integer.valueOf(FavImgGalleryUI.i(FavImgGalleryUI.this).size()) });
              FavImgGalleryUI.a(FavImgGalleryUI.this).setSelection(FavImgGalleryUI.e(FavImgGalleryUI.this) - 1);
              FavImgGalleryUI.a(FavImgGalleryUI.this, FavImgGalleryUI.e(FavImgGalleryUI.this) - 1);
              AppMethodBeat.o(74010);
              return;
            }
            if (FavImgGalleryUI.i(FavImgGalleryUI.this).size() > 0)
            {
              ab.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", new Object[] { Integer.valueOf(FavImgGalleryUI.i(FavImgGalleryUI.this).size()) });
              FavImgGalleryUI.a(FavImgGalleryUI.this).setSelection(0);
              FavImgGalleryUI.a(FavImgGalleryUI.this, 0);
              AppMethodBeat.o(74010);
              return;
            }
            ab.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", new Object[] { Integer.valueOf(FavImgGalleryUI.i(FavImgGalleryUI.this).size()) });
            FavImgGalleryUI.this.finish();
            AppMethodBeat.o(74010);
          }
        });
        AppMethodBeat.o(74023);
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    AppMethodBeat.i(74022);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
      AppMethodBeat.o(74022);
      return;
    }
    if (!com.tencent.mm.platformtools.q.a(paramString1, paramContext, 2131298889)) {
      Toast.makeText(paramContext, paramString2, 1).show();
    }
    AppMethodBeat.o(74022);
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(74028);
    if (paramc != null)
    {
      ab.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", new Object[] { Integer.valueOf(paramc.field_status) });
      f localf = this.mwp.vX(this.mwo);
      if ((localf != null) && (bo.bf(paramc.field_dataId, "").equals(localf.cuL.mBq))) {
        al.d(new FavImgGalleryUI.12(this, paramc));
      }
    }
    AppMethodBeat.o(74028);
  }
  
  public int getLayoutId()
  {
    return 2130969537;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74029);
    if (1 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(74029);
        return;
      }
      f localf = this.mwp.vX(this.mwo);
      if (localf == null)
      {
        ab.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
        AppMethodBeat.o(74029);
        return;
      }
      new k();
      if (k.u(localf.mwn))
      {
        h.bO(getContext(), getString(2131296330));
        AppMethodBeat.o(74029);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Conv_User");
      ab.d("MicroMsg.FavImgGalleryUI", "select %s for sending", new Object[] { str });
      com.tencent.mm.ui.base.p localp = h.b(getContext(), getString(2131299734), false, null);
      i.a(getContext(), str, localf.mwn, localf.cuL, new FavImgGalleryUI.2(this, localp));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74029);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74021);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().addFlags(67108864);
    }
    this.cBz = getIntent().getBooleanExtra("show_share", true);
    this.kuC = ((MMGestureGallery)findViewById(2131822137));
    this.kuC.setVerticalFadingEdgeEnabled(false);
    this.kuC.setHorizontalFadingEdgeEnabled(false);
    this.kuC.setOnItemSelectedListener(this);
    this.kuC.setSingleClickOverListener(new FavImgGalleryUI.1(this));
    if (this.cBz) {
      this.kuC.setLongClickOverListener(new FavImgGalleryUI.5(this));
    }
    fullScreenNoTitleBar(true);
    this.iRT = new ArrayList();
    this.mwp = new a((byte)0);
    this.kuC.setAdapter(this.mwp);
    Kg();
    setBackBtn(new FavImgGalleryUI.6(this));
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    setResult(0, getIntent());
    AppMethodBeat.o(74021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74024);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    super.onDestroy();
    AppMethodBeat.o(74024);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74027);
    this.mwo = paramInt;
    ab.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).dDJ();
    }
    AppMethodBeat.o(74027);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    AppMethodBeat.i(74026);
    super.onPause();
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(this);
    o.La(2);
    AppMethodBeat.o(74026);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74025);
    super.onResume();
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(this);
    o.La(1);
    AppMethodBeat.o(74025);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    SparseBooleanArray mwz;
    
    private a()
    {
      AppMethodBeat.i(74012);
      this.mwz = new SparseBooleanArray();
      AppMethodBeat.o(74012);
    }
    
    private Bitmap a(f paramf)
    {
      AppMethodBeat.i(74017);
      if (paramf != null)
      {
        paramf = l.a(paramf.cuL, paramf.mwn);
        if (paramf != null)
        {
          AppMethodBeat.o(74017);
          return paramf;
        }
      }
      paramf = com.tencent.mm.compatible.g.a.decodeResource(FavImgGalleryUI.this.getResources(), 2131231253);
      AppMethodBeat.o(74017);
      return paramf;
    }
    
    private void a(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(74016);
      paramc.progressBar.setVisibility(8);
      paramc.mwG.setVisibility(8);
      paramc.mwF.setVisibility(8);
      paramc.mwD.setVisibility(0);
      paramc.mwH.setVisibility(8);
      b(paramc, paramBitmap, paramString);
      AppMethodBeat.o(74016);
    }
    
    private void b(FavImgGalleryUI.c paramc, Bitmap paramBitmap, String paramString)
    {
      AppMethodBeat.i(74018);
      n.x(paramc.mwE, paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = paramc.mwE.getWidth();
      int j = paramc.mwE.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.reset();
      float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
      float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      ab.v("MicroMsg.FavImgGalleryUI", "whDiv is " + f1 + " hwDiv is " + f2);
      if ((f2 >= 2.0F) && (paramBitmap.getHeight() >= 480))
      {
        f1 = paramBitmap.getWidth() / i;
        f2 = i / paramBitmap.getWidth();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f2, f2);
          paramBitmap.getHeight();
          localMatrix.postTranslate((i - f2 * paramBitmap.getWidth()) / 2.0F, 0.0F);
        }
      }
      for (;;)
      {
        paramc.mwE.setImageMatrix(localMatrix);
        paramc.mwE.cb(paramBitmap.getWidth(), paramBitmap.getHeight());
        paramc.mwE.setMaxZoomDoubleTab(true);
        if (!bo.isNullOrNil(paramString)) {
          break label524;
        }
        paramc.mwE.setImageBitmap(paramBitmap);
        AppMethodBeat.o(74018);
        return;
        localMatrix.postScale(1.0F, 1.0F);
        localMatrix.postTranslate((i - paramBitmap.getWidth()) / 2, 0.0F);
        continue;
        if ((f1 < 2.0F) || (paramBitmap.getWidth() < 480)) {
          break;
        }
        f1 = paramBitmap.getHeight() / 480.0F;
        f2 = 480.0F / paramBitmap.getHeight();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f1, f2);
          localMatrix.postTranslate(0.0F, (j - 480) / 2);
        }
        else
        {
          localMatrix.postScale(1.0F, 1.0F);
          f1 = (j - paramBitmap.getHeight()) / 2;
          ab.d("MicroMsg.FavImgGalleryUI", " offsety ".concat(String.valueOf(f1)));
          localMatrix.postTranslate(0.0F, f1);
        }
      }
      f1 = i / paramBitmap.getWidth();
      f2 = j / paramBitmap.getHeight();
      label425:
      float f3;
      if (f1 < f2)
      {
        f2 = paramBitmap.getWidth() / i;
        f3 = paramBitmap.getHeight() / j;
        if (f2 <= f3) {
          break label517;
        }
        label455:
        if (f2 <= 1.0D) {
          break label627;
        }
        localMatrix.postScale(f1, f1);
      }
      for (;;)
      {
        localMatrix.postTranslate((i - paramBitmap.getWidth() * f1) / 2.0F, (j - f1 * paramBitmap.getHeight()) / 2.0F);
        break;
        f1 = f2;
        break label425;
        label517:
        f2 = f3;
        break label455;
        try
        {
          label524:
          paramString = new com.tencent.mm.plugin.gif.d(paramString);
          paramc.mwE.setGifDrawable(paramString);
          paramc.mwE.hz(com.tencent.mm.cb.a.gw(FavImgGalleryUI.this.getContext()), com.tencent.mm.cb.a.gx(FavImgGalleryUI.this.getContext()));
          paramc.mwE.cb(paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          paramc.mwE.start();
          paramc.mwE.dEA();
          AppMethodBeat.o(74018);
          return;
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.FavImgGalleryUI", bo.l(paramString));
          paramc.mwE.setImageBitmap(paramBitmap);
          AppMethodBeat.o(74018);
          return;
        }
        label627:
        f1 = 1.0F;
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74013);
      int i = FavImgGalleryUI.i(FavImgGalleryUI.this).size();
      AppMethodBeat.o(74013);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74015);
      f localf;
      Object localObject;
      if (paramView == null)
      {
        paramViewGroup = new FavImgGalleryUI.c(FavImgGalleryUI.this, (byte)0);
        paramView = View.inflate(FavImgGalleryUI.this.getContext(), 2130969536, null);
        paramViewGroup.mwD = paramView.findViewById(2131820630);
        paramViewGroup.mwE = ((MultiTouchImageView)paramView.findViewById(2131820629));
        paramViewGroup.progressBar = ((ProgressBar)paramView.findViewById(2131822683));
        paramViewGroup.mwF = ((ImageView)paramView.findViewById(2131821549));
        paramViewGroup.mwG = ((TextView)paramView.findViewById(2131824027));
        paramViewGroup.mwH = ((LinearLayout)paramView.findViewById(2131824000));
        paramViewGroup.mwI = ((TextView)paramView.findViewById(2131824001));
        paramViewGroup.mwI.setText(2131299691);
        paramView.setTag(paramViewGroup);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        localf = vX(paramInt);
        boolean bool = this.mwz.get(paramInt, true);
        this.mwz.put(paramInt, false);
        localObject = l.a(localf.cuL, localf.mwn, bool);
        if (localf.mwn != null) {
          ab.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localf.mwn.field_id), Long.valueOf(localf.mwn.field_localId), Integer.valueOf(localf.mwn.field_itemStatus) });
        }
        if (localf.cuL != null) {
          ab.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[] { localf.cuL.mBq, localf.cuL.wSC, localf.cuL.wSE, Long.valueOf(localf.cuL.wSX), localf.cuL.fgM, localf.cuL.wSy, Long.valueOf(localf.cuL.wTi) });
        }
        if (localObject != null) {
          break label794;
        }
        FavImgGalleryUI.this.enableOptionMenu(false);
        ab.w("MicroMsg.FavImgGalleryUI", "get big image fail");
        com.tencent.mm.plugin.fav.a.q localq = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage();
        if (localf.cuL == null) {
          break label561;
        }
        localObject = localf.cuL.mBq;
        label434:
        localObject = localq.NP((String)localObject);
        if (localObject != null) {
          break label640;
        }
        paramViewGroup.mwH.setVisibility(8);
        if ((localf.mwn == null) || (localf.mwn.field_id >= 0)) {
          break label569;
        }
        paramViewGroup.progressBar.setVisibility(0);
        paramViewGroup.mwG.setVisibility(0);
        paramViewGroup.mwF.setVisibility(0);
        paramViewGroup.mwD.setVisibility(8);
        paramViewGroup.mwF.setImageBitmap(a(localf));
        paramViewGroup.progressBar.setProgress(0);
        paramViewGroup.mwG.setText("0%");
      }
      for (;;)
      {
        AppMethodBeat.o(74015);
        return paramView;
        paramViewGroup = (FavImgGalleryUI.c)paramView.getTag();
        break;
        label561:
        localObject = "";
        break label434;
        label569:
        paramViewGroup.progressBar.setVisibility(8);
        paramViewGroup.mwG.setVisibility(8);
        paramViewGroup.mwF.setVisibility(8);
        paramViewGroup.mwD.setVisibility(0);
        if (localf.cuL.wTK != 0) {
          paramViewGroup.mwH.setVisibility(0);
        }
        b(paramViewGroup, a(localf), "");
      }
      label640:
      ab.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.c)localObject).field_status) });
      paramViewGroup.progressBar.setVisibility(0);
      paramViewGroup.mwG.setVisibility(0);
      paramViewGroup.mwF.setVisibility(0);
      paramViewGroup.mwD.setVisibility(8);
      paramViewGroup.mwF.setImageBitmap(a(localf));
      if (((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen > 0) {}
      for (paramInt = ((com.tencent.mm.plugin.fav.a.c)localObject).field_offset * 100 / ((com.tencent.mm.plugin.fav.a.c)localObject).field_totalLen - 1;; paramInt = 0)
      {
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        paramViewGroup.progressBar.setProgress(i);
        paramViewGroup.mwG.setText(i + "%");
        AppMethodBeat.o(74015);
        return paramView;
      }
      label794:
      FavImgGalleryUI.this.enableOptionMenu(true);
      if (r.aoY(b.b(localf.cuL))) {
        a(paramViewGroup, (Bitmap)localObject, b.b(localf.cuL));
      }
      for (;;)
      {
        AppMethodBeat.o(74015);
        return paramView;
        a(paramViewGroup, (Bitmap)localObject, "");
      }
    }
    
    public final f vX(int paramInt)
    {
      AppMethodBeat.i(74014);
      if (paramInt >= FavImgGalleryUI.i(FavImgGalleryUI.this).size())
      {
        ab.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(74014);
        return null;
      }
      f localf = (f)FavImgGalleryUI.i(FavImgGalleryUI.this).get(paramInt);
      AppMethodBeat.o(74014);
      return localf;
    }
  }
  
  static final class b
  {
    ny mwA;
    String mwB;
    String mwC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI
 * JD-Core Version:    0.7.0.1
 */