package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI
  extends MMActivity
  implements AdapterView.OnItemSelectedListener, p
{
  private boolean cBz;
  private ArrayList<f> iRT;
  private l igW;
  private MMGestureGallery kuC;
  private n.d loG;
  private int mBQ;
  private FavVideoView mBR;
  private FavMediaGalleryUI.a mBS;
  private List<FavVideoView> mBT;
  acs mBU;
  private int mwo;
  private Map<String, ny> mwr;
  private long mws;
  private com.tencent.mm.sdk.b.c mwt;
  
  public FavMediaGalleryUI()
  {
    AppMethodBeat.i(74528);
    this.mwo = 0;
    this.mBQ = -1;
    this.mBR = null;
    this.cBz = true;
    this.mBT = new ArrayList();
    this.mBU = new acs();
    this.mwr = new HashMap();
    this.loG = new FavMediaGalleryUI.8(this);
    this.mwt = new FavMediaGalleryUI.3(this);
    AppMethodBeat.o(74528);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(74530);
    Object localObject1 = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
    ArrayList localArrayList = new ArrayList();
    String str = getIntent().getStringExtra("key_detail_data_id");
    this.mws = getIntent().getLongExtra("key_detail_info_id", -1L);
    Object localObject2;
    long l;
    boolean bool1;
    if (localObject1 == null)
    {
      boolean bool2 = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
      localObject2 = getIntent().getStringExtra("fav_note_xml");
      localObject1 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mws);
      l = this.mws;
      if (localObject1 != null)
      {
        bool1 = true;
        ab.i("MicroMsg.FavMediaGalleryUI", "show one fav info, local id is %d, get from db ok ? %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
        if ((!bool2) || (bo.isNullOrNil((String)localObject2))) {
          break label558;
        }
        localObject1 = b.ND((String)localObject2);
      }
    }
    label555:
    label558:
    for (;;)
    {
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      label180:
      this.iRT.clear();
      int i = -1;
      int m = localArrayList.size();
      int k = 0;
      label200:
      int j;
      if (k < m)
      {
        localObject1 = (com.tencent.mm.plugin.fav.a.g)localArrayList.get(k);
        int n = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.size();
        j = 0;
        label234:
        if (j < n)
        {
          localObject2 = (aca)((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.wVc.get(j);
          if (((((aca)localObject2).dataType == 8) && (!r.aoY(b.b((aca)localObject2)))) || ((((aca)localObject2).dataType != 2) && (((aca)localObject2).dataType != 4) && (((aca)localObject2).dataType != 15) && (((aca)localObject2).dataType != 8))) {
            break label555;
          }
          f localf = new f((com.tencent.mm.plugin.fav.a.g)localObject1, (aca)localObject2);
          this.iRT.add(localf);
          if ((str == null) || (!str.equals(((aca)localObject2).mBq)) || (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId != this.mws)) {
            break label555;
          }
          i = this.iRT.size() - 1;
        }
      }
      for (;;)
      {
        j += 1;
        break label234;
        bool1 = false;
        break;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          l = localObject1[i];
          localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
          if ((localObject2 != null) && (!localArrayList.contains(localObject2))) {
            localArrayList.add(localObject2);
          }
          i += 1;
        }
        break label180;
        j = i;
        if (str == null)
        {
          j = i;
          if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId == this.mws) {
            j = this.iRT.size() - 1;
          }
        }
        k += 1;
        i = j;
        break label200;
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mBS.notifyDataSetChanged();
        this.kuC.post(new FavMediaGalleryUI.9(this, i));
        AppMethodBeat.o(74530);
        return;
      }
    }
  }
  
  public final void d(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(74535);
    if (paramc != null)
    {
      f localf = this.mBS.vX(this.mwo);
      if ((localf != null) && (bo.bf(paramc.field_dataId, "").equals(localf.cuL.mBq)) && (localf.cuL.dataType == 2)) {
        al.d(new FavMediaGalleryUI.10(this, paramc));
      }
    }
    AppMethodBeat.o(74535);
  }
  
  public int getLayoutId()
  {
    return 2130969537;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74536);
    if (1 == paramInt1)
    {
      if (-1 != paramInt2)
      {
        AppMethodBeat.o(74536);
        return;
      }
      f localf = this.mBS.vX(this.mwo);
      if (localf == null)
      {
        ab.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
        AppMethodBeat.o(74536);
        return;
      }
      String str = b.b(localf.cuL);
      new k();
      if (k.u(localf.mwn))
      {
        h.bO(getContext(), getString(2131296330));
        AppMethodBeat.o(74536);
        return;
      }
      Object localObject2 = paramIntent.getStringExtra("Select_Conv_User");
      Object localObject1 = bo.P(((String)localObject2).split(","));
      ab.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", new Object[] { localObject2 });
      localObject2 = h.b(getContext(), getString(2131299734), false, null);
      if (r.aoY(str))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          i.a(getContext(), str, localf.mwn, localf.cuL, new FavMediaGalleryUI.11(this, (Dialog)localObject2));
        }
      }
      localObject2 = new FavMediaGalleryUI.2(this, (Dialog)localObject2);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        i.a(this, (String)((Iterator)localObject1).next(), localf.cuL, (Runnable)localObject2);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74529);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    this.cBz = getIntent().getBooleanExtra("show_share", true);
    this.kuC = ((MMGestureGallery)findViewById(2131822137));
    this.kuC.setVerticalFadingEdgeEnabled(false);
    this.kuC.setHorizontalFadingEdgeEnabled(false);
    this.kuC.setOnItemSelectedListener(this);
    this.kuC.setSingleClickOverListener(new FavMediaGalleryUI.1(this));
    if (this.cBz) {
      this.kuC.setLongClickOverListener(new FavMediaGalleryUI.4(this));
    }
    fullScreenNoTitleBar(true);
    this.iRT = new ArrayList();
    this.mBS = new FavMediaGalleryUI.a(this, (byte)0);
    this.kuC.setAdapter(this.mBS);
    Kg();
    setBackBtn(new FavMediaGalleryUI.5(this));
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    setResult(0, getIntent());
    this.mBU.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.mBU.kbN = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.mBU.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.mBU.query = getIntent().getStringExtra("key_detail_fav_query");
    this.mBU.cpW = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.mBU.mtm = getIntent().getStringExtra("key_detail_fav_tags");
    acs localacs = this.mBU;
    if (this.mBU.query == null)
    {
      paramBundle = "";
      localacs.query = paramBundle;
      localacs = this.mBU;
      if (this.mBU.cpW != null) {
        break label393;
      }
      paramBundle = "";
      label346:
      localacs.cpW = paramBundle;
      localacs = this.mBU;
      if (this.mBU.mtm != null) {
        break label404;
      }
    }
    label393:
    label404:
    for (paramBundle = "";; paramBundle = this.mBU.mtm)
    {
      localacs.mtm = paramBundle;
      AppMethodBeat.o(74529);
      return;
      paramBundle = this.mBU.query;
      break;
      paramBundle = this.mBU.cpW;
      break label346;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74531);
    getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs());
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    Iterator localIterator = this.mBT.iterator();
    while (localIterator.hasNext())
    {
      FavVideoView localFavVideoView = (FavVideoView)localIterator.next();
      if (localFavVideoView != null) {
        localFavVideoView.onDestroy();
      }
    }
    super.onDestroy();
    AppMethodBeat.o(74531);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74534);
    this.mwo = paramInt;
    ab.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(paramInt)));
    if ((paramView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)paramView).dDJ();
    }
    if (this.mBR != null) {
      this.mBR.onDestroy();
    }
    if ((paramView instanceof FavVideoView))
    {
      paramAdapterView = (FavVideoView)paramView;
      if (((this.mBS.getItemViewType(paramInt) == 15) || (this.mBS.getItemViewType(paramInt) == 4)) && (paramAdapterView != null)) {
        if (paramAdapterView.kvG != null) {
          break label131;
        }
      }
    }
    label131:
    for (boolean bool = false;; bool = paramAdapterView.kvG.isPlaying())
    {
      if (!bool)
      {
        paramAdapterView.onResume();
        this.mBR = paramAdapterView;
        this.mBQ = paramInt;
      }
      AppMethodBeat.o(74534);
      return;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    AppMethodBeat.i(74533);
    super.onPause();
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().b(this);
    o.La(2);
    AppMethodBeat.o(74533);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74532);
    super.onResume();
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnStorage().a(this);
    o.La(1);
    AppMethodBeat.o(74532);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
  {
    View mwD;
    MultiTouchImageView mwE;
    ImageView mwF;
    TextView mwG;
    LinearLayout mwH;
    TextView mwI;
    ProgressBar progressBar;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI
 * JD-Core Version:    0.7.0.1
 */