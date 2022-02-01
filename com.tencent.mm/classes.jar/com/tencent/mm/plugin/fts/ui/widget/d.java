package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.ciw;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.protocal.protobuf.edw;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public final class d
  implements View.OnFocusChangeListener, com.tencent.mm.ak.f
{
  public View contentView;
  public boolean dmj;
  public ImageView fQl;
  public long lSe;
  public String query;
  private long tGT;
  public long tJJ;
  private View tJX;
  private View tJY;
  public View tJZ;
  public int tJu;
  private View tKa;
  public LinearLayout tKb;
  public TextView tKc;
  private TextView tKd;
  private ciy tKe;
  public long tKg;
  public aq tNN;
  public View tNb;
  public TextView tNc;
  public FTSMainUI tOM;
  public View tON;
  private int tOO;
  private int tOP;
  private int tOQ;
  public View tOR;
  public TextView tOS;
  public TextView tOT;
  public TextView tOU;
  public View tOV;
  public View tOW;
  public TextView tOX;
  public TextView tOY;
  public View tOZ;
  private View.OnClickListener tPA;
  private View.OnClickListener tPB;
  private com.tencent.mm.sdk.b.c<mg> tPC;
  public ImageView tPa;
  public TextView tPb;
  public TextView tPc;
  public TextView tPd;
  public TextView tPe;
  public View tPf;
  public ImageView tPg;
  public TextView tPh;
  public TextView tPi;
  public TextView tPj;
  public View tPk;
  public ImageView tPl;
  public ImageView tPm;
  public TextView tPn;
  public TextView tPo;
  public TextView tPp;
  public e tPq;
  public r tPr;
  public b tPs;
  public boolean tPt;
  public boolean tPu;
  private boolean tPv;
  private boolean tPw;
  private com.tencent.mm.plugin.websearch.api.q tPx;
  private long tPy;
  private long tPz;
  
  public d(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(112351);
    this.tOO = 0;
    this.tOP = 0;
    this.tOQ = 0;
    this.tPs = b.tPF;
    this.tPt = false;
    this.tPu = false;
    this.dmj = false;
    this.tPv = false;
    this.tPw = false;
    this.tJu = 1;
    this.tNN = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(112332);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112332);
          return;
          if (paramAnonymousMessage.obj.equals(Long.valueOf(d.a(d.this))))
          {
            d.this.a(d.b.tPK);
            d.a(d.this, System.currentTimeMillis());
            ae.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", new Object[] { Long.valueOf(d.b(d.this) - d.c(d.this)) });
            l.O(d.a(d.this), 5);
            d.this.cVx();
            d.this.cjk();
          }
        }
      }
    };
    this.tPz = 60L;
    this.tPA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112336);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = (ajh)paramAnonymousView.getTag();
        d.this.C(paramAnonymousView.GyJ.Hxp, 22, paramAnonymousView.GyJ.Hvr);
        d.d(d.this).tKW.tKy = true;
        l.a(d.e(d.this), 1, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 28, "", "", "");
        d.d(d.this).tKW.tKD.Hv(28);
        d.a(d.this, 0, "", "", "", paramAnonymousView.GyJ.Hvr, paramAnonymousView.FUF + 1, "");
        d.this.Hz(6);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(112336);
      }
    };
    this.tPB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(112343);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = (qz)paramAnonymousView.getTag();
        switch (paramAnonymousView.nJA)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112343);
          return;
        }
        int j = 2;
        if (!d.f(d.this)) {
          j = 1;
        }
        localObject1 = (ciu)paramAnonymousView.Gfo.getFirst();
        Object localObject2 = ((ciu)localObject1).Hvo;
        d.this.a((civ)localObject2);
        int i;
        if (paramAnonymousView.nJA == 512) {
          i = 7;
        }
        for (;;)
        {
          localObject2 = l.alM(((ciu)localObject1).Hvn.Title);
          l.a(d.e(d.this), j, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, i + "$" + (String)localObject2, ((ciu)localObject1).Hvn.Hvr, "");
          d.d(d.this).tKW.tKD.Hv(27);
          d.a(d.this, paramAnonymousView.nJA, ((ciu)localObject1).Hvn.Hvr, (String)localObject2, "", "", 0, "");
          ae.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", new Object[] { Integer.valueOf(i), localObject2, ((ciu)localObject1).Hvn.Hvr });
          break;
          if (paramAnonymousView.nJA == 4194304) {
            i = 6;
          } else {
            i = 0;
          }
        }
      }
    };
    this.tPC = new d.4(this);
    this.tOM = paramFTSMainUI;
    this.tOO = (com.tencent.mm.cb.a.iu(paramFTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix(paramFTSMainUI.getContext(), 100));
    this.tOP = (com.tencent.mm.cb.a.iu(paramFTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix(paramFTSMainUI.getContext(), 116));
    this.tOQ = (com.tencent.mm.cb.a.iu(paramFTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix(paramFTSMainUI.getContext(), 48));
    cWS();
    AppMethodBeat.o(112351);
  }
  
  public static com.tencent.mm.ay.f a(String paramString1, TimeLineObject paramTimeLineObject, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(112368);
    if ((paramTimeLineObject == null) || (paramTimeLineObject.HUG == null) || (paramTimeLineObject.HUG.Gtx == null) || (paramTimeLineObject.HUG.Gtx.size() <= 0))
    {
      AppMethodBeat.o(112368);
      return null;
    }
    bzh localbzh = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
    if (localbzh == null)
    {
      AppMethodBeat.o(112368);
      return null;
    }
    com.tencent.mm.ay.f localf = new com.tencent.mm.ay.f();
    localf.ijX = 9;
    localf.ijZ = paramString2;
    localf.ika = 0.0F;
    localf.ikd = "";
    if (!TextUtils.isEmpty(localbzh.songAlbumUrl)) {
      localf.ikq = localbzh.songAlbumUrl;
    }
    localf.ike = localbzh.Hmj;
    localf.ikj = null;
    localf.ijY = 1;
    localf.iki = localbzh.songLyric;
    localf.ikb = localbzh.Title;
    localf.ikc = localbzh.Desc;
    paramString2 = localObject;
    if (paramTimeLineObject.HUG != null) {
      paramString2 = paramTimeLineObject.HUG.Url;
    }
    localf.ikh = paramString2;
    localf.ikg = localbzh.Hmn;
    localf.ikf = localbzh.Url;
    localf.ikn = localbzh.Hmk;
    localf.ikp = localbzh.Id;
    localf.ikk = paramString1;
    localf.ikm = paramTimeLineObject.HUF.Id;
    localf.ikt = paramTimeLineObject.nIJ;
    localf.ikA = paramTimeLineObject.Id;
    AppMethodBeat.o(112368);
    return localf;
  }
  
  private void cWS()
  {
    AppMethodBeat.i(112355);
    if (System.currentTimeMillis() - this.tPy > this.tPz * 1000L)
    {
      ae.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
      cWT();
      this.tPx = new com.tencent.mm.plugin.websearch.api.q(new cis());
      g.ajj().a(1417, this);
      g.ajj().a(this.tPx, 0);
      this.tPy = System.currentTimeMillis();
    }
    AppMethodBeat.o(112355);
  }
  
  @SuppressLint({"ResourceType"})
  private void cWV()
  {
    AppMethodBeat.i(176933);
    Object localObject1;
    int j;
    Object localObject2;
    int i;
    if ((this.tKe == null) || (this.tKe.Hvw == null))
    {
      localObject1 = null;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label523;
      }
      this.tPu = true;
      this.tOR.setVisibility(0);
      j = ((dlx)((List)localObject1).get(0)).Hxp.length() + 0;
      localObject2 = new ajh();
      ((ajh)localObject2).GyJ = ((dlx)((List)localObject1).get(0));
      ((ajh)localObject2).FUF = 0;
      this.tOS.setTag(localObject2);
      this.tOS.setText(((dlx)((List)localObject1).get(0)).Hxp);
      this.tOS.setOnClickListener(this.tPA);
      this.tOS.setVisibility(0);
      this.tOM.tKW.tKD.p(System.currentTimeMillis(), "PardusSug");
      if (((List)localObject1).size() <= 1) {
        break label485;
      }
      j += ((dlx)((List)localObject1).get(1)).Hxp.length();
      this.tOT.setOnClickListener(this.tPA);
      localObject2 = new ajh();
      ((ajh)localObject2).GyJ = ((dlx)((List)localObject1).get(1));
      ((ajh)localObject2).FUF = 1;
      this.tOT.setTag(localObject2);
      this.tOT.setText(((dlx)((List)localObject1).get(1)).Hxp);
      this.tOT.setVisibility(0);
      i = 2;
      label286:
      if (((List)localObject1).size() <= 2) {
        break label511;
      }
      if (((dlx)((List)localObject1).get(2)).Hxp.length() + j > 24) {
        break label499;
      }
      this.tOU.setOnClickListener(this.tPA);
      localObject2 = new ajh();
      ((ajh)localObject2).GyJ = ((dlx)((List)localObject1).get(2));
      ((ajh)localObject2).FUF = 2;
      this.tOU.setTag(localObject2);
      this.tOU.setText(((dlx)((List)localObject1).get(2)).Hxp);
      this.tOU.setVisibility(0);
      i += 1;
    }
    label523:
    for (;;)
    {
      label405:
      if (this.tPu)
      {
        localObject2 = "";
        j = 0;
        for (;;)
        {
          if (j < i)
          {
            localObject2 = (String)localObject2 + ((dlx)((List)localObject1).get(j)).Hvr + "_";
            j += 1;
            continue;
            localObject1 = this.tKe.Hvw.FQQ;
            break;
            label485:
            this.tOT.setVisibility(8);
            i = 1;
            break label286;
            label499:
            this.tOU.setVisibility(8);
            break label405;
            label511:
            this.tOU.setVisibility(8);
            break label405;
            this.tOR.setVisibility(8);
            i = 0;
            break label405;
          }
        }
        e(0, "", "", (String)localObject2, "");
      }
    }
    int k = 2;
    if (!this.tPu) {
      k = 1;
    }
    if (this.tKe.Hvx.size() > 0) {}
    for (qz localqz = (qz)this.tKe.Hvx.getFirst();; localqz = null)
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str1;
      Object localObject3;
      if (localqz != null)
      {
        localObject4 = "";
        localObject2 = "";
        str2 = "";
        this.tOW.setTag(localqz);
        switch (localqz.nJA)
        {
        default: 
          localObject5 = "";
          localObject1 = "";
          str1 = "";
          localObject3 = "";
          switch (localqz.nJA)
          {
          default: 
            this.dmj = false;
            this.tOV.setVisibility(8);
            this.contentView.measure(-2147483648, 0);
            label785:
            this.tOW.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112338);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                d.this.dJ(d.e(d.this), 21);
                qz localqz = (qz)paramAnonymousView.getTag();
                paramAnonymousView = "";
                localObject = "";
                String str1;
                String str2;
                switch (localqz.nJA)
                {
                default: 
                  str1 = "";
                  str2 = "";
                }
                for (;;)
                {
                  int i = 2;
                  if (!d.f(d.this)) {
                    i = 1;
                  }
                  l.a(d.e(d.this), i, 2, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, paramAnonymousView, (String)localObject, "");
                  d.d(d.this).tKW.tKD.Hv(27);
                  d.d(d.this).tKW.tKy = true;
                  d.a(d.this, localqz.nJA, "more", str2, str1, "", 0, "");
                  d.this.Hz(5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112338);
                  return;
                  localObject = (ov)localqz.Gfi.getFirst();
                  str2 = l.alM(((ov)localObject).GcB.Title);
                  paramAnonymousView = "1$".concat(String.valueOf(str2));
                  localObject = ((ov)localObject).GcB.Hvr;
                  str1 = "";
                  continue;
                  localObject = (edw)localqz.Gfj.getFirst();
                  str2 = l.alM(((edw)localObject).GcB.Title);
                  paramAnonymousView = "2$".concat(String.valueOf(str2));
                  localObject = ((edw)localObject).GcB.Hvr;
                  str1 = "";
                  continue;
                  localObject = (afi)localqz.Gfk.getFirst();
                  str1 = ((afi)localObject).uqf;
                  str2 = l.alM(((afi)localObject).GcB.Title);
                  paramAnonymousView = "4$".concat(String.valueOf(str2));
                  localObject = ((afi)localObject).GcB.Hvr;
                  continue;
                  localObject = (ciu)localqz.Gfo.getFirst();
                  str2 = l.alM(((ciu)localObject).Hvn.Title);
                  paramAnonymousView = "8$".concat(String.valueOf(str2));
                  localObject = ((ciu)localObject).Hvn.Hvr;
                  str1 = "";
                  continue;
                  localObject = (ciu)localqz.Gfo.getFirst();
                  str2 = l.alM(((ciu)localObject).Hvn.Title);
                  paramAnonymousView = "7$".concat(String.valueOf(str2));
                  localObject = ((ciu)localObject).Hvn.Hvr;
                  str1 = "";
                  continue;
                  localObject = (ciu)localqz.Gfo.getFirst();
                  str2 = l.alM(((ciu)localObject).Hvn.Title);
                  paramAnonymousView = "6$".concat(String.valueOf(str2));
                  localObject = ((ciu)localObject).Hvn.Hvr;
                  str1 = "";
                }
              }
            });
            this.tNb.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112339);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
                if (!d.f(d.this)) {}
                for (int i = 1;; i = 2) {
                  try
                  {
                    paramAnonymousView = (qz)paramAnonymousView.getTag();
                    if (paramAnonymousView.nJA == 64)
                    {
                      localObject1 = (edw)paramAnonymousView.Gfj.getFirst();
                      localObject2 = new vq();
                      ((vq)localObject2).dKT.userName = ((edw)localObject1).nIJ;
                      ((vq)localObject2).dKT.scene = 1027;
                      ((vq)localObject2).dKT.dlj = "2";
                      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
                      localObject2 = l.alM(((edw)localObject1).GcB.Title);
                      l.a(d.e(d.this), i, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, "2$".concat(String.valueOf(localObject2)), ((edw)localObject1).GcB.Hvr, ((edw)localObject1).nIJ);
                      d.d(d.this).tKW.tKD.Hv(27);
                      d.a(d.this, paramAnonymousView.nJA, ((edw)localObject1).GcB.Hvr, (String)localObject2, "", "", 0, "");
                      ae.i("MicroMsg.FTS.PardusSearchLogic", "click result weapp %s %s", new Object[] { ((edw)localObject1).nIJ, ((edw)localObject1).GcB.Hvr });
                      d.this.Hz(4);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(112339);
                      return;
                    }
                    if (paramAnonymousView.nJA == 1)
                    {
                      localObject1 = (ov)paramAnonymousView.Gfi.getFirst();
                      localObject2 = new JSONObject(((ov)localObject1).GcC);
                      localObject3 = new Intent();
                      ((Intent)localObject3).putExtra("Contact_User", ((JSONObject)localObject2).optString("userName", ""));
                      ((Intent)localObject3).putExtra("Contact_Nick", ((JSONObject)localObject2).optString("nickName", ""));
                      ((Intent)localObject3).putExtra("Contact_Alias", ((JSONObject)localObject2).optString("aliasName", ""));
                      ((Intent)localObject3).putExtra("Contact_BrandIconURL", ((JSONObject)localObject2).optString("iconUrl", ""));
                      ((Intent)localObject3).putExtra("Contact_Signature", ((JSONObject)localObject2).optString("signature", ""));
                      ((Intent)localObject3).putExtra("Contact_VUser_Info_Flag", ((JSONObject)localObject2).optInt("verifyFlag", 0));
                      ((Intent)localObject3).putExtra("Contact_Scene", 3);
                      localObject4 = new aco();
                      ((aco)localObject4).jgj = ((JSONObject)localObject2).optInt("brandFlag", 0);
                      ((aco)localObject4).jgm = ((JSONObject)localObject2).optString("iconUrl", "");
                      ((aco)localObject4).jgl = ((JSONObject)localObject2).optString("brandInfo", "");
                      ((aco)localObject4).jgk = ((JSONObject)localObject2).optString("externalInfo", "");
                    }
                  }
                  catch (Exception paramAnonymousView)
                  {
                    try
                    {
                      label527:
                      do
                      {
                        for (;;)
                        {
                          ((Intent)localObject3).putExtra("Contact_customInfo", ((aco)localObject4).toByteArray());
                          Object localObject4 = new Bundle();
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Search_Id", String.valueOf(d.a(d.this)));
                          ((Bundle)localObject4).putString("Contact_Ext_Args_Query_String", d.e(d.this));
                          ((Bundle)localObject4).putInt("Contact_Scene", 3);
                          ((Bundle)localObject4).putInt("Contact_Ext_Args_Index", 0);
                          ((Bundle)localObject4).putString("Contact_Ext_Extra_Params", "");
                          ((Intent)localObject3).putExtra("preChatTYPE", 10);
                          ((Intent)localObject3).putExtra("Contact_Ext_Args", (Bundle)localObject4);
                          com.tencent.mm.br.d.b(ak.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject3);
                          Object localObject3 = l.alM(((ov)localObject1).GcB.Title);
                          l.a(d.e(d.this), i, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, "1$".concat(String.valueOf(localObject3)), ((ov)localObject1).GcB.Hvr, "");
                          d.this.Hz(4);
                          d.d(d.this).tKW.tKD.Hv(27);
                          d.d(d.this).tKW.tKy = true;
                          d.a(d.this, paramAnonymousView.nJA, ((ov)localObject1).GcB.Hvr, (String)localObject3, "", "", 0, "");
                          ae.i("MicroMsg.FTS.PardusSearchLogic", "click result biz %s %s", new Object[] { ((JSONObject)localObject2).optString("userName", ""), ((ov)localObject1).GcB.Hvr });
                          continue;
                          paramAnonymousView = paramAnonymousView;
                          ae.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                        }
                      } while (paramAnonymousView.nJA != 5);
                      localObject1 = (ciu)paramAnonymousView.Gfo.getFirst();
                      Object localObject2 = ((ciu)localObject1).Hvo;
                      d.this.a((civ)localObject2);
                      localObject2 = l.alM(((ciu)localObject1).Hvn.Title);
                      l.a(d.e(d.this), i, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, "8$".concat(String.valueOf(localObject2)), ((ciu)localObject1).Hvn.Hvr, "");
                      d.d(d.this).tKW.tKD.Hv(27);
                      d.a(d.this, paramAnonymousView.nJA, ((ciu)localObject1).Hvn.Hvr, (String)localObject2, "", "", 0, "");
                      ae.i("MicroMsg.FTS.PardusSearchLogic", "click result game %s %s", new Object[] { localObject2, ((ciu)localObject1).Hvn.Hvr });
                    }
                    catch (IOException localIOException)
                    {
                      break label527;
                    }
                  }
                }
              }
            });
            this.tOZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112340);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (qz)paramAnonymousView.getTag();
                    localObject1 = (afi)paramAnonymousView.Gfk.getFirst();
                    if (((afi)localObject1).uqI != 1) {
                      continue;
                    }
                    localObject2 = new vq();
                    ((vq)localObject2).dKT.userName = ((afi)localObject1).nIJ;
                    ((vq)localObject2).dKT.dKV = ((afi)localObject1).GvL;
                    ((vq)localObject2).dKT.aDD = ((afi)localObject1).GvM;
                    ((vq)localObject2).dKT.scene = 1027;
                    ((vq)localObject2).dKT.dlj = (((afi)localObject1).GvN + ":2");
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
                    localObject2 = l.alM(((afi)localObject1).GcB.Title);
                    l.a(d.e(d.this), i, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, "4$".concat(String.valueOf(localObject2)), ((afi)localObject1).GcB.Hvr, "");
                    d.this.Hz(4);
                    d.d(d.this).tKW.tKD.Hv(27);
                    d.d(d.this).tKW.tKy = true;
                    d.a(d.this, paramAnonymousView.nJA, ((afi)localObject1).GcB.Hvr, (String)localObject2, ((afi)localObject1).uqf, "", 0, "");
                    ae.i("MicroMsg.FTS.PardusSearchLogic", "click result article %s", new Object[] { ((afi)localObject1).GcB.Hvr });
                  }
                  catch (Exception paramAnonymousView)
                  {
                    Object localObject2;
                    ae.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramAnonymousView, "", new Object[0]);
                    continue;
                  }
                  d.this.Hz(4);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(112340);
                  return;
                  if (((afi)localObject1).uqI == 0)
                  {
                    localObject2 = new Intent();
                    ((Intent)localObject2).putExtra("rawUrl", ((afi)localObject1).uqf);
                    com.tencent.mm.br.d.b(ak.getContext(), "webview", ".ui.tools.WebviewMpUI", (Intent)localObject2);
                  }
                }
              }
            });
            this.tPl.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112341);
                Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
                int i = 2;
                if (!d.f(d.this)) {
                  i = 1;
                }
                paramAnonymousView = (qz)paramAnonymousView.getTag();
                localObject1 = (ciu)paramAnonymousView.Gfo.getFirst();
                Object localObject2 = ((ciu)localObject1).Hvn.Hvr;
                if (com.tencent.mm.ay.a.aJZ())
                {
                  com.tencent.mm.ay.f localf = com.tencent.mm.ay.a.aKc();
                  if ((localf.ijX == 9) && (localf.ijZ.equals(localObject2)))
                  {
                    com.tencent.mm.ay.a.aJX();
                    d.g(d.this).setImageResource(2131691022);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(112341);
                    return;
                  }
                }
                localObject2 = ((com.tencent.mm.plugin.sns.b.n)g.ab(com.tencent.mm.plugin.sns.b.n.class)).GZ(((ciu)paramAnonymousView.Gfo.getFirst()).Hvo.Hvq);
                g.ajS();
                com.tencent.mm.ay.a.c(d.a(g.ajR().gDT, (TimeLineObject)localObject2, ((ciu)localObject1).Hvn.Hvr));
                d.g(d.this).setImageResource(2131691021);
                localObject2 = l.alM(((ciu)localObject1).Hvn.Title);
                l.a(d.e(d.this), i, 1, d.d(d.this).lox, d.d(d.this).tKW.tKD, 27, "7$".concat(String.valueOf(localObject2)), ((ciu)localObject1).Hvn.Hvr, "");
                d.d(d.this).tKW.tKD.Hv(27);
                d.a(d.this, paramAnonymousView.nJA, ((ciu)localObject1).Hvn.Hvr, (String)localObject2, "", "", 0, "");
                ae.i("MicroMsg.FTS.PardusSearchLogic", "click music play %d %s %s", new Object[] { Integer.valueOf(7), localObject2, ((ciu)localObject1).Hvn.Hvr });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112341);
              }
            });
            this.tPk.setOnClickListener(this.tPB);
            this.tPf.setOnClickListener(this.tPB);
            label867:
            if (this.dmj) {
              this.tJu = 2;
            }
            localObject1 = this.tOM.tKW.tKD;
            if (!this.dmj) {}
            break;
          }
          break;
        }
      }
      for (j = 2;; j = 0)
      {
        ((com.tencent.mm.plugin.fts.ui.c.b)localObject1).gg(i, j);
        if ((!this.tPu) && (!this.dmj)) {
          break label2753;
        }
        i = this.contentView.getMeasuredHeight();
        localObject1 = ValueAnimator.ofInt(new int[] { 0, i });
        ((ValueAnimator)localObject1).addUpdateListener(new d.11(this));
        ((ValueAnimator)localObject1).addListener(new a(this.tKg));
        ((ValueAnimator)localObject1).setDuration(400L);
        ((ValueAnimator)localObject1).start();
        this.contentView.setVisibility(0);
        ae.i("MicroMsg.FTS.PardusSearchLogic", "updateHeaderView measureHeight:%s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(176933);
        return;
        localObject1 = (ov)localqz.Gfi.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.alr(((ov)localObject1).GcB.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.alr(((ov)localObject1).GcB.Desc);
        localObject2 = ((ov)localObject1).GcB.IconUrl;
        str1 = ((ov)localObject1).GcB.Hvs;
        this.tOM.tKW.tKD.a(k, System.currentTimeMillis(), "PardusMore", 1, ((ov)localObject1).GcB.Hvr);
        this.tOM.tKW.tKD.a(k + 1, System.currentTimeMillis(), ((ov)localObject1).GcB.Hvr, 1, ((ov)localObject1).GcB.Hvr);
        e(localqz.nJA, ((ov)localObject1).GcB.Hvr, l.alM(((ov)localObject1).GcB.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject1 = (edw)localqz.Gfj.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.alr(((edw)localObject1).GcB.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.alr(((edw)localObject1).GcB.Desc);
        localObject2 = ((edw)localObject1).GcB.IconUrl;
        str1 = ((edw)localObject1).GcB.Hvs;
        this.tOM.tKW.tKD.a(k, System.currentTimeMillis(), "PardusMore", 2, ((edw)localObject1).GcB.Hvr);
        this.tOM.tKW.tKD.a(k + 1, System.currentTimeMillis(), ((edw)localObject1).GcB.Hvr, 2, ((edw)localObject1).GcB.Hvr);
        e(localqz.nJA, ((edw)localObject1).GcB.Hvr, l.alM(((edw)localObject1).GcB.Title), "", "");
        localObject5 = "";
        localObject1 = "";
        break;
        localObject5 = (afi)localqz.Gfk.get(0);
        localObject4 = com.tencent.mm.plugin.fts.a.f.alr(((afi)localObject5).GcB.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.alr(((afi)localObject5).GcB.Desc);
        localObject2 = ((afi)localObject5).GcB.IconUrl;
        str1 = ((afi)localObject5).GcB.Hvs;
        localObject1 = ((afi)localObject5).GvK;
        this.tOM.tKW.tKD.a(k, System.currentTimeMillis(), "PardusMore", 4, ((afi)localObject5).GcB.Hvr);
        this.tOM.tKW.tKD.a(k + 1, System.currentTimeMillis(), ((afi)localObject5).GcB.Hvr, 4, ((afi)localObject5).GcB.Hvr);
        e(localqz.nJA, ((afi)localObject5).GcB.Hvr, l.alM(((afi)localObject5).GcB.Title), "", "");
        localObject5 = "";
        break;
        ciu localciu = (ciu)localqz.Gfo.getFirst();
        localObject5 = localciu.Hvn.Hvr;
        localObject4 = com.tencent.mm.plugin.fts.a.f.alr(localciu.Hvn.Title);
        localObject3 = com.tencent.mm.plugin.fts.a.f.alr(localciu.Hvn.Desc);
        localObject2 = localciu.Hvn.IconUrl;
        str1 = localciu.Hvn.Hvs;
        j = localciu.Hvn.udk;
        if ((j <= 0) || (j >= 86400L))
        {
          str2 = null;
          j = 0;
          if (localqz.nJA != 5) {
            break label1782;
          }
          j = 8;
        }
        for (;;)
        {
          this.tOM.tKW.tKD.a(k, System.currentTimeMillis(), "PardusMore", j, (String)localObject5);
          this.tOM.tKW.tKD.a(k + 1, System.currentTimeMillis(), (String)localObject5, j, (String)localObject5);
          e(localqz.nJA, (String)localObject5, l.alM(localciu.Hvn.Title), "", "");
          localObject1 = "";
          break;
          if (j < 3600L) {}
          for (localObject1 = "mm:ss";; localObject1 = "HH:mm:ss")
          {
            localObject1 = new SimpleDateFormat((String)localObject1);
            ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
            str2 = ((SimpleDateFormat)localObject1).format(Long.valueOf(j * 1000L));
            break;
          }
          label1782:
          if (localqz.nJA == 4194304) {
            j = 6;
          } else if (localqz.nJA == 512) {
            j = 7;
          }
        }
        this.dmj = true;
        this.tOV.setVisibility(0);
        this.tNb.setVisibility(0);
        this.tNb.setTag(localqz);
        this.tOZ.setVisibility(8);
        this.tPf.setVisibility(8);
        this.tPk.setVisibility(8);
        this.tOX.setText((CharSequence)localObject4);
        if (!bu.ah((CharSequence)localObject3)) {
          if (this.tNc.getPaint().measureText(((CharSequence)localObject3).toString()) >= this.tOO)
          {
            this.tNc.setMaxLines(2);
            label1924:
            this.tNc.setText((CharSequence)localObject3);
            this.tNc.setVisibility(0);
            label1941:
            localObject1 = this.tOM.getContext();
            localObject3 = this.fQl;
            if (localqz.nJA == 5) {
              break label2029;
            }
          }
        }
        label2029:
        for (boolean bool = true;; bool = false)
        {
          com.tencent.mm.plugin.fts.ui.n.a((Context)localObject1, (ImageView)localObject3, (String)localObject2, null, 2131231342, bool);
          this.tOY.setText(str1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.tNc.setMaxLines(1);
          break label1924;
          this.tNc.setVisibility(8);
          break label1941;
        }
        this.dmj = true;
        this.tOV.setVisibility(0);
        this.tNb.setVisibility(8);
        this.tOZ.setVisibility(0);
        this.tPf.setVisibility(8);
        this.tPk.setVisibility(8);
        this.tOZ.setTag(localqz);
        if (!bu.ah((CharSequence)localObject4)) {
          if (!bu.isNullOrNil((String)localObject2))
          {
            this.tPb.setMaxLines(1);
            this.tPc.setMaxLines(2);
            this.tPa.setVisibility(0);
            localObject5 = new c.a();
            ((c.a)localObject5).igj = true;
            ((c.a)localObject5).igv = 2131231879;
            ((c.a)localObject5).igC = 1.0F;
            ((c.a)localObject5).hhW = true;
            localObject5 = ((c.a)localObject5).aJu();
            com.tencent.mm.av.q.aJb().a((String)localObject2, this.tPa, (com.tencent.mm.av.a.a.c)localObject5);
            label2188:
            this.tPb.setText((CharSequence)localObject4);
            this.tPb.setVisibility(0);
            label2205:
            if (bu.ah((CharSequence)localObject3)) {
              break label2347;
            }
            this.tPc.setText((CharSequence)localObject3);
            this.tPc.setVisibility(0);
          }
        }
        for (;;)
        {
          this.tPd.setText(str1);
          this.tPe.setText((CharSequence)localObject1);
          this.contentView.measure(-2147483648, 0);
          break;
          this.tPa.setVisibility(8);
          if (this.tPb.getPaint().measureText(((CharSequence)localObject4).toString()) >= this.tOQ)
          {
            this.tPb.setMaxLines(2);
            this.tPc.setMaxLines(1);
            break label2188;
          }
          this.tPb.setMaxLines(1);
          this.tPc.setMaxLines(2);
          break label2188;
          this.tPb.setVisibility(8);
          break label2205;
          label2347:
          this.tPc.setVisibility(8);
        }
        this.dmj = true;
        this.tOV.setVisibility(0);
        this.tNb.setVisibility(8);
        this.tOZ.setVisibility(8);
        this.tPk.setVisibility(8);
        this.tPf.setVisibility(0);
        this.tPf.setTag(localqz);
        this.tPi.setText((CharSequence)localObject4);
        this.tPj.setText(str1);
        this.tPh.setText(str2);
        localObject1 = new c.a();
        ((c.a)localObject1).igj = true;
        ((c.a)localObject1).igv = 2131231884;
        ((c.a)localObject1).igC = 1.0F;
        ((c.a)localObject1).hhW = true;
        localObject1 = ((c.a)localObject1).aJu();
        com.tencent.mm.av.q.aJb().a((String)localObject2, this.tPg, (com.tencent.mm.av.a.a.c)localObject1);
        this.contentView.measure(-2147483648, 0);
        break label785;
        this.dmj = true;
        this.tOV.setVisibility(0);
        this.tNb.setVisibility(8);
        this.tOZ.setVisibility(8);
        this.tPf.setVisibility(8);
        this.tPk.setVisibility(0);
        this.tPk.setTag(localqz);
        this.tPl.setTag(localqz);
        this.tPn.setText((CharSequence)localObject4);
        this.tPo.setText((CharSequence)localObject3);
        this.tPp.setText(str1);
        if ((com.tencent.mm.ay.a.aJZ()) && (com.tencent.mm.ay.a.aKc().ijZ.equals(localObject5))) {
          this.tPl.setImageResource(2131691021);
        }
        for (;;)
        {
          localObject1 = new c.a();
          ((c.a)localObject1).igj = true;
          ((c.a)localObject1).igv = 2131231882;
          ((c.a)localObject1).igC = 1.0F;
          ((c.a)localObject1).hhW = true;
          localObject1 = ((c.a)localObject1).aJu();
          com.tencent.mm.av.q.aJb().a((String)localObject2, this.tPm, (com.tencent.mm.av.a.a.c)localObject1);
          this.contentView.measure(-2147483648, 0);
          this.tPC.alive();
          break;
          this.tPl.setImageResource(2131691022);
        }
        this.tOV.setVisibility(8);
        this.contentView.measure(0, 0);
        break label867;
      }
      label2753:
      this.contentView.setVisibility(8);
      AppMethodBeat.o(176933);
      return;
    }
  }
  
  private void gS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(112363);
    this.tOM.tKW.tKy = true;
    if ((paramString1 == null) || (bu.isNullOrNil(paramString1.trim())))
    {
      AppMethodBeat.o(112363);
      return;
    }
    if (System.currentTimeMillis() - this.lSe <= 1000L)
    {
      AppMethodBeat.o(112363);
      return;
    }
    this.lSe = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.tEn;
    HashMap localHashMap = new HashMap();
    localHashMap.put("sceneActionType", "1");
    localHashMap.put("parentSearchID", paramString2);
    localHashMap.put("clickType", "17");
    ((h)g.ab(h.class)).a(this.tOM.getContext(), 3, paramString1, String.valueOf(l), localHashMap);
    AppMethodBeat.o(112363);
  }
  
  private String getSearchId()
  {
    AppMethodBeat.i(112366);
    if (this.tKe != null)
    {
      String str = this.tKe.HkY;
      AppMethodBeat.o(112366);
      return str;
    }
    long l = this.tKg;
    AppMethodBeat.o(112366);
    return String.valueOf(l);
  }
  
  public final void C(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(184533);
    String str = "";
    if (this.tKe != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.tKe.HkY, paramString2, Long.valueOf(this.tKg) });
    }
    paramString2 = new HashMap();
    paramString2.put("prefixSug", this.query);
    if (!bu.isNullOrNil(str)) {
      paramString2.put("parentSearchID", str);
    }
    paramString2.put("sceneActionType", "6");
    l(paramString2, paramString1);
    AppMethodBeat.o(184533);
  }
  
  public final void Hz(int paramInt)
  {
    AppMethodBeat.i(184532);
    if ((!this.tPw) && (!bu.isNullOrNil(this.query)))
    {
      am.p(this.query, this.tJu, paramInt, 3);
      this.tPw = true;
    }
    AppMethodBeat.o(184532);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(112367);
    ae.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", new Object[] { this.tPs, paramb });
    this.tPs = paramb;
    AppMethodBeat.o(112367);
  }
  
  public final void a(civ paramciv)
  {
    AppMethodBeat.i(176934);
    switch (paramciv.GbY)
    {
    }
    for (;;)
    {
      Hz(4);
      AppMethodBeat.o(176934);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramciv.uqf);
      com.tencent.mm.br.d.b(this.tOM, "webview", ".ui.tools.WebviewMpUI", (Intent)localObject);
      continue;
      localObject = new vq();
      ((vq)localObject).dKT.userName = paramciv.nIJ;
      ((vq)localObject).dKT.dKV = paramciv.GvL;
      ((vq)localObject).dKT.aDD = paramciv.GvM;
      ((vq)localObject).dKT.dlj = paramciv.GvN;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    }
  }
  
  public final View cMv()
  {
    AppMethodBeat.i(112361);
    if (this.tJX == null)
    {
      this.tJX = this.tOM.getLayoutInflater().inflate(2131494224, null, false);
      this.tJZ = this.tJX.findViewById(2131306903);
      this.tJY = this.tJX.findViewById(2131306906);
      this.tKa = this.tJX.findViewById(2131306905);
      this.tKc = ((TextView)this.tJX.findViewById(2131306907));
      this.tKd = ((TextView)this.tJX.findViewById(2131306904));
      this.tKb = ((LinearLayout)this.tJY.findViewById(2131303971));
    }
    try
    {
      Object localObject = af.aHj("webSearchBar").optString("wording");
      ae.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", new Object[] { localObject });
      this.tKd.setText((CharSequence)localObject);
      label163:
      this.tJZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(112333);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          d.d(d.this).tKW.tKy = true;
          if (!d.d(d.this).tKW.tKp)
          {
            d.d(d.this).tKW.tKp = true;
            l.a(d.e(d.this), true, d.d(d.this).tKW.getCount(), 0, d.d(d.this).tKW.tKD);
          }
          d.this.dJ(d.e(d.this), 15);
          d.d(d.this).tKW.tKy = true;
          d.this.Hz(2);
          am.WS(3);
          d.d(d.this).tKW.tKD.Hv(18);
          l.a(d.e(d.this), d.d(d.this).tKW.getCount(), d.d(d.this).lox, d.d(d.this).tKW.tKD, 18);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(112333);
        }
      });
      localObject = this.tJX;
      AppMethodBeat.o(112361);
      return localObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final void cVx()
  {
    AppMethodBeat.i(112352);
    this.tNN.removeMessages(1);
    if (this.tPr != null)
    {
      g.ajj().a(this.tPr);
      g.ajj().b(1076, this);
      this.tPr = null;
    }
    AppMethodBeat.o(112352);
  }
  
  public final void cWT()
  {
    AppMethodBeat.i(112356);
    if (this.tPx != null)
    {
      g.ajj().a(this.tPx);
      g.ajj().b(1417, this);
      this.tPx = null;
    }
    AppMethodBeat.o(112356);
  }
  
  @TargetApi(8)
  public final void cWU()
  {
    AppMethodBeat.i(112357);
    if (this.contentView != null)
    {
      this.tOM.mN(true);
      this.contentView.clearAnimation();
      this.contentView.setVisibility(8);
    }
    if (this.tKb != null)
    {
      this.tKb.removeAllViews();
      this.tKb.setVisibility(8);
    }
    if (this.tJY != null) {
      this.tJY.setVisibility(8);
    }
    if (this.tJZ != null) {
      this.tJZ.setVisibility(8);
    }
    if (this.tPq != null) {
      this.tPq.cWW();
    }
    AppMethodBeat.o(112357);
  }
  
  public final void cjk()
  {
    AppMethodBeat.i(112360);
    if (!this.dmj)
    {
      this.tKb.removeAllViews();
      LinkedList localLinkedList;
      if ((this.tKe == null) || (this.tKe.HvB == null)) {
        localLinkedList = null;
      }
      while ((!this.tPu) && (localLinkedList != null) && (localLinkedList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localLinkedList.size())
          {
            dlx localdlx = (dlx)localLinkedList.get(i);
            ajh localajh = new ajh();
            localajh.GyJ = localdlx;
            localajh.FUF = i;
            View localView = this.tOM.getLayoutInflater().inflate(2131494228, this.tKb, false);
            localView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(112337);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                paramAnonymousView = (ajh)paramAnonymousView.getTag();
                d.this.C(paramAnonymousView.GyJ.Hxp, 7, paramAnonymousView.GyJ.Hvr);
                localObject = d.d(d.this).tKW.tKD;
                l.a(d.e(d.this), d.d(d.this).tKW.getCount(), d.d(d.this).lox, (com.tencent.mm.plugin.fts.ui.c.b)localObject, 23);
                d.d(d.this).tKW.tKy = true;
                if (!d.d(d.this).tKW.tKp)
                {
                  d.d(d.this).tKW.tKp = true;
                  l.a(paramAnonymousView.GyJ.Hxp, true, d.d(d.this).tKW.getCount(), 0, (com.tencent.mm.plugin.fts.ui.c.b)localObject);
                }
                d.this.Hz(7);
                am.WS(3);
                d.d(d.this).tKW.tKD.Hv(23);
                d.a(d.this, 0, "", "", "", "", paramAnonymousView.FUF + 1, paramAnonymousView.GyJ.Hvr);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(112337);
              }
            });
            ((TextView)localView.findViewById(2131298739)).setText(localdlx.Hxp);
            localView.setTag(localajh);
            this.tKb.addView(localView);
            i += 1;
            continue;
            localLinkedList = this.tKe.HvB.FQQ;
            break;
          }
        }
        this.tOM.tKW.tKD.gh(localLinkedList.size(), 1);
        this.tKb.setVisibility(0);
        this.tOM.tKW.tKD.ea(localLinkedList);
      }
      for (;;)
      {
        this.tJY.setVisibility(0);
        this.tJZ.setVisibility(0);
        this.tOM.tKW.tKD.cWq();
        AppMethodBeat.o(112360);
        return;
        this.tOM.tKW.tKD.gh(0, 1);
        this.tKb.setVisibility(8);
      }
    }
    this.tOM.tKW.tKD.gh(0, 0);
    this.tJZ.setVisibility(8);
    this.tJY.setVisibility(8);
    AppMethodBeat.o(112360);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(112353);
    this.tPs = b.tPF;
    this.tJu = 1;
    this.tKg = 0L;
    this.tJJ = 0L;
    this.tGT = 0L;
    this.tPt = false;
    this.tPu = false;
    this.dmj = false;
    this.tPw = false;
    this.query = null;
    this.tKe = null;
    this.tPC.dead();
    if (this.tPq != null) {
      this.tPq.clearData();
    }
    AppMethodBeat.o(112353);
  }
  
  public final void dJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(176935);
    String str = "";
    if (this.tKe != null) {
      str = String.format("%s:%s:%s:%s", new Object[] { Integer.valueOf(paramInt), this.tKe.HkY, paramString, Long.valueOf(this.tKg) });
    }
    gS(paramString, str);
    AppMethodBeat.o(176935);
  }
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(112365);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("pardussearch=expose&searchid=");
      localStringBuffer.append(getSearchId());
      localStringBuffer.append("&query=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(this.query, "utf8"));
      localStringBuffer.append("&type=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&docid=");
      localStringBuffer.append(paramString1);
      localStringBuffer.append("&title=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(paramString2, "utf8"));
      localStringBuffer.append("&clienttimestamp=");
      localStringBuffer.append(System.currentTimeMillis());
      localStringBuffer.append("&sug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(paramString3, "utf8"));
      localStringBuffer.append("&relatedsug=");
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(paramString4, "utf8"));
      ae.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", new Object[] { localStringBuffer.toString() });
      paramString1 = new cvj();
      paramString1.HFU = localStringBuffer.toString();
      paramString1 = new z(paramString1);
      g.ajj().a(paramString1, 0);
      AppMethodBeat.o(112365);
      return;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", paramString1, "realtimeSearchExposeReport", new Object[0]);
      AppMethodBeat.o(112365);
    }
  }
  
  public final void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112362);
    if ((paramBoolean2) || (paramInt != 0)) {
      this.tKa.setVisibility(0);
    }
    for (;;)
    {
      if (paramBoolean1)
      {
        com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
        b.a locala = b.a.qKW;
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
        if (localb.a(locala, com.tencent.mm.util.c.fSe()) == 0) {
          cjk();
        }
      }
      AppMethodBeat.o(112362);
      return;
      this.tKa.setVisibility(8);
    }
  }
  
  public final void l(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(176936);
    this.tOM.tKW.tKy = true;
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(176936);
      return;
    }
    if (System.currentTimeMillis() - this.lSe <= 1000L)
    {
      AppMethodBeat.o(176936);
      return;
    }
    this.lSe = System.currentTimeMillis();
    long l = com.tencent.mm.plugin.fts.a.e.tEn;
    paramMap.put("clickType", "7");
    ((h)g.ab(h.class)).a(this.tOM.getContext(), paramString, String.valueOf(l), paramMap);
    AppMethodBeat.o(176936);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(112354);
    ae.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      cWS();
    }
    AppMethodBeat.o(112354);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(112359);
    boolean bool;
    label230:
    Object localObject;
    if (paramn.equals(this.tPx))
    {
      g.ajj().b(1417, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tPz = this.tPx.DST.Hvm;
        ae.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", new Object[] { Long.valueOf(this.tPz) });
        AppMethodBeat.o(112359);
      }
    }
    else if ((paramn.equals(this.tPr)) && (this.tPr.DSV.Hvt.equals(String.valueOf(this.tKg))))
    {
      a(b.tPH);
      this.tNN.removeMessages(1);
      g.ajj().b(1076, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label412;
      }
      l.O(this.tKg, 4);
      this.tKe = this.tPr.DSU;
      if ((this.tKe == null) || (bu.isNullOrNil(this.tKe.HvC))) {
        break label333;
      }
      bool = true;
      this.tPv = bool;
      bool = this.tPv;
      paramInt2 = this.tKe.Hvx.size();
      if (this.tKe.Hvw != null) {
        break label339;
      }
      paramInt1 = i;
      ae.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (!this.tPt)
      {
        if (!this.tPv) {
          break label405;
        }
        paramString = this.tPq;
        paramn = this.tKe.HvC;
        localObject = this.query;
        if (paramString.tPO) {
          break label356;
        }
        ae.i("MicroMsg.FTS.PardusWebViewLogic", "webview not ready");
      }
    }
    for (;;)
    {
      if (!this.tPv) {
        cjk();
      }
      AppMethodBeat.o(112359);
      return;
      label333:
      bool = false;
      break;
      label339:
      paramInt1 = this.tKe.Hvw.FQQ.size();
      break label230;
      label356:
      paramString.dCK = ((String)localObject);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("info", paramn);
        label382:
        paramString.tKE.tOM.runOnUiThread(new e.1(paramString, (JSONObject)localObject));
        continue;
        label405:
        cWV();
        continue;
        label412:
        l.O(this.tKg, 5);
      }
      catch (Exception paramn)
      {
        break label382;
      }
    }
  }
  
  final class a
    implements Animator.AnimatorListener
  {
    private long tPE;
    
    public a(long paramLong)
    {
      this.tPE = paramLong;
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(176932);
      ae.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.tPE), Long.valueOf(d.a(d.this)) });
      if (this.tPE == d.a(d.this))
      {
        d.d(d.this).mN(true);
        if (d.i(d.this) == d.b.tPI)
        {
          d.this.a(d.b.tPJ);
          l.O(d.a(d.this), 7);
        }
      }
      AppMethodBeat.o(176932);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(176931);
      ae.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", new Object[] { Long.valueOf(this.tPE), Long.valueOf(d.a(d.this)) });
      if (this.tPE == d.a(d.this))
      {
        d.d(d.this).mN(false);
        d.this.a(d.b.tPI);
        l.O(d.a(d.this), 6);
      }
      AppMethodBeat.o(176931);
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(112350);
      tPF = new b("None", 0);
      tPG = new b("StartSearch", 1);
      tPH = new b("ReturnResult", 2);
      tPI = new b("StartAnimation", 3);
      tPJ = new b("ShowResult", 4);
      tPK = new b("Timeout", 5);
      tPL = new b[] { tPF, tPG, tPH, tPI, tPJ, tPK };
      AppMethodBeat.o(112350);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */