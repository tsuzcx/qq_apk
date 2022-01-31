package com.tencent.mm.plugin.fav.ui.gallery;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  implements g.b
{
  private RecyclerView adt;
  Activity cup;
  public long eCX;
  public int eez;
  private TextView ejt;
  public long fAA;
  private ProgressDialog kFY;
  boolean kGk;
  private int kGl;
  public View kgr;
  private acs mBU;
  public g.a mBW;
  TextView mBX;
  public boolean mBY;
  public int mBZ;
  public com.tencent.matrix.trace.e.b mCa;
  private TextView mCb;
  private TextView mCc;
  private View.OnClickListener mCd;
  private View.OnClickListener mCe;
  private View.OnClickListener mCf;
  public List<d> mCg;
  
  public c(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(74551);
    this.mBY = false;
    this.mBZ = -1;
    this.kGk = true;
    this.eCX = 0L;
    this.fAA = 0L;
    this.mCa = new com.tencent.matrix.trace.e.b()
    {
      public final void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(74540);
        super.a(paramAnonymousString, paramAnonymousLong, paramAnonymousInt);
        if ((paramAnonymousInt > 0) && (!bo.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.endsWith(c.this.getClass().getSimpleName()))) {
          c.this.eCX += paramAnonymousInt;
        }
        AppMethodBeat.o(74540);
      }
    };
    this.mCd = new c.4(this);
    this.mCe = new c.5(this);
    this.mCf = new c.6(this);
    this.mCg = new ArrayList();
    this.cup = paramActivity;
    this.kgr = paramView;
    this.mBY = true;
    g.c localc = g.c.mCI;
    paramView = null;
    switch (c.7.mCj[localc.ordinal()])
    {
    }
    for (paramActivity = paramView;; paramActivity = new h(paramActivity))
    {
      paramActivity.a(this);
      this.mBU = new acs();
      this.mBU.scene = 2;
      this.mBU.kbN = 2;
      this.mBU.index = 0;
      this.mBU.cpW = "";
      this.mBU.query = "";
      this.mBU.mtm = "";
      this.mCb = ((TextView)this.kgr.findViewById(2131824060));
      this.mCb.setTag(Integer.valueOf(0));
      this.mCb.setOnClickListener(this.mCf);
      this.mCc = ((TextView)this.kgr.findViewById(2131824061));
      this.mCc.setOnClickListener(this.mCd);
      this.mBX = ((TextView)this.kgr.findViewById(2131824062));
      this.ejt = ((TextView)this.kgr.findViewById(2131821515));
      this.adt = ((RecyclerView)this.kgr.findViewById(2131821516));
      this.adt.setLayoutManager(this.mBW.bgA());
      this.adt.b(this.mBW.dR(this.cup));
      this.adt.setAdapter(this.mBW.bgz());
      ((f)this.mBW.byo()).mBU = this.mBU;
      this.adt.setHasFixedSize(true);
      this.adt.setOnScrollListener(new c.2(this));
      this.adt.a(new c.3(this));
      AppMethodBeat.o(74551);
      return;
    }
  }
  
  private void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(74559);
    ab.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.kFY = p.b(this.cup, this.cup.getString(2131301086), true, null);
      AppMethodBeat.o(74559);
      return;
    }
    if ((this.kFY != null) && (this.kFY.isShowing()))
    {
      this.kFY.dismiss();
      this.kFY = null;
    }
    AppMethodBeat.o(74559);
  }
  
  public final void bP(List<d> paramList)
  {
    AppMethodBeat.i(74558);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(74558);
      return;
    }
    this.mCg.clear();
    this.mCg.addAll(paramList);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("mutil_select_is_ret", true);
    String str2;
    int i;
    if (this.mCg.size() == 1)
    {
      d locald = (d)paramList.get(0);
      String str1 = com.tencent.mm.plugin.fav.a.b.c(locald.cuZ);
      str2 = com.tencent.mm.plugin.fav.a.b.b(locald.cuZ);
      if (e.cN(str1))
      {
        localIntent.putExtra("image_path", str1);
        if ((!locald.byk()) && (!locald.byj())) {
          break label235;
        }
        i = 1;
        label153:
        localIntent.putExtra("Retr_Msg_Type", i);
        localIntent.putExtra("select_is_ret", true);
      }
    }
    for (;;)
    {
      com.tencent.mm.bq.d.b(this.cup, ".ui.transmit.SelectConversationUI", localIntent, 1);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        com.tencent.mm.plugin.fav.a.h.i(((d)paramList.next()).mCk.field_localId, 1, 0);
      }
      localIntent.putExtra("image_path", str2);
      break;
      label235:
      i = 0;
      break label153;
      localIntent.putExtra("scene_from", 1);
      localIntent.putExtra("Retr_Msg_Type", 17);
      localIntent.putExtra("select_fav_select_count", this.mCg.size());
    }
    AppMethodBeat.o(74558);
  }
  
  public final void byh()
  {
    AppMethodBeat.i(74556);
    this.mBW.byh();
    this.mCc.setText(2131299671);
    this.mCb.setText(this.cup.getString(2131304396));
    this.mCb.setVisibility(0);
    this.mCc.setOnClickListener(this.mCe);
    AppMethodBeat.o(74556);
  }
  
  public final void byi()
  {
    AppMethodBeat.i(74557);
    this.mBW.byi();
    this.mCc.setText(2131299673);
    this.mCb.setVisibility(8);
    this.mCc.setOnClickListener(this.mCd);
    AppMethodBeat.o(74557);
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(74553);
    if (paramBoolean)
    {
      gg(true);
      AppMethodBeat.o(74553);
      return;
    }
    this.kGl = ((GridLayoutManager)this.adt.getLayoutManager()).iv();
    AppMethodBeat.o(74553);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(74554);
    ab.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(this.mBZ) });
    if (paramBoolean)
    {
      gg(false);
      this.adt.getAdapter().ajb.notifyChanged();
      if (this.mBZ > 0)
      {
        if (this.mBZ % 4 == 0) {
          this.mBZ += 1;
        }
        this.adt.bJ(this.mBZ);
      }
      while (paramInt <= 0)
      {
        this.ejt.setVisibility(0);
        this.adt.setVisibility(8);
        this.ejt.setText(this.cup.getString(2131299672));
        AppMethodBeat.o(74554);
        return;
        int i = this.adt.getAdapter().getItemCount();
        this.adt.bJ(i - 1);
      }
      this.ejt.setVisibility(8);
      this.adt.setVisibility(0);
      AppMethodBeat.o(74554);
      return;
    }
    if (paramInt > 0)
    {
      this.adt.getAdapter().ajb.notifyChanged();
      AppMethodBeat.o(74554);
      return;
    }
    this.adt.getAdapter().bR(0);
    AppMethodBeat.o(74554);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(74552);
    this.kgr.setVisibility(paramInt);
    AppMethodBeat.o(74552);
  }
  
  public final void wa(int paramInt)
  {
    AppMethodBeat.i(74555);
    if (paramInt > 0)
    {
      this.mCb.setText(this.cup.getString(2131304396) + "(" + paramInt + ")");
      AppMethodBeat.o(74555);
      return;
    }
    this.mCb.setText(this.cup.getString(2131304396));
    AppMethodBeat.o(74555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.c
 * JD-Core Version:    0.7.0.1
 */