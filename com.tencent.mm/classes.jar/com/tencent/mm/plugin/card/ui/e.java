package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e
  implements g.a, n, MMActivity.a
{
  ListView Nn;
  private final String TAG = "MicroMsg.CardDetailUIContoller";
  boolean bNW = false;
  LinearLayout dK;
  View.OnClickListener fvj = new e.4(this);
  com.tencent.mm.plugin.card.base.b ikk;
  List<com.tencent.mm.plugin.card.model.b> iko = new ArrayList();
  ArrayList<mb> ikq;
  public int ipW = 0;
  String ipX = "";
  String ipY = "";
  public ArrayList<String> ipZ = new ArrayList();
  private View ipf;
  public ArrayList<String> iqa = new ArrayList();
  i isA;
  i isB;
  com.tencent.mm.plugin.card.ui.view.d isC;
  i isD;
  j isE;
  boolean isF = true;
  com.tencent.mm.plugin.card.b.f isG;
  public String isH = "";
  public String isI = "";
  HashMap<Integer, String> isJ = new HashMap();
  HashMap<String, String> isK = new HashMap();
  ArrayList<String> isL = new ArrayList();
  e.d isM;
  e.a isN;
  private ah isO = new e.3(this);
  com.tencent.mm.sdk.b.c isP = new e.7(this);
  CardDetailBaseUI isl;
  com.tencent.mm.plugin.card.ui.a.g ism;
  i isn;
  boolean iso = false;
  i isp;
  i isq;
  com.tencent.mm.plugin.card.widget.g isr;
  com.tencent.mm.plugin.card.ui.view.g iss;
  m ist;
  i isu;
  i isv;
  i isw;
  i isx;
  i isy;
  i isz;
  
  public e(CardDetailBaseUI paramCardDetailBaseUI, View paramView)
  {
    this.isl = paramCardDetailBaseUI;
    this.ipf = paramView;
  }
  
  private String aAY()
  {
    if ((!TextUtils.isEmpty(this.ipX)) && (!TextUtils.isEmpty(this.ipY))) {
      return this.ipX + "," + com.tencent.mm.plugin.card.d.l.yV(this.ipY);
    }
    if (!TextUtils.isEmpty(this.ipX)) {
      return this.ipX;
    }
    if (!TextUtils.isEmpty(this.ipY)) {
      return com.tencent.mm.plugin.card.d.l.yV(this.ipY);
    }
    return "";
  }
  
  private void oZ(int paramInt)
  {
    LinkedList localLinkedList = this.ikk.azy().sHD;
    if (localLinkedList == null) {}
    for (;;)
    {
      return;
      this.isK.clear();
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < localLinkedList.size())
      {
        ax localax = (ax)localLinkedList.get(paramInt);
        j = i;
        if (!bk.bl(localax.text))
        {
          j = i;
          if (!bk.bl(localax.url))
          {
            this.isL.add(localax.text);
            this.isJ.put(Integer.valueOf(i), localax.text);
            this.isK.put(localax.text, localax.url);
            j = i + 1;
          }
        }
        paramInt += 1;
        i = j;
      }
    }
  }
  
  private void w(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.isr != null) {
      this.isr.w(paramBoolean1, paramBoolean2);
    }
  }
  
  private void yE(String paramString)
  {
    Intent localIntent = new Intent();
    if ((this.ikk instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.ikk);
    }
    for (;;)
    {
      localIntent.setClass(this.isl, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.isN.drX);
      localIntent.putExtra("key_previous_scene", this.isN.ipv);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.isN.isT);
      this.isl.startActivityForResult(localIntent, 3);
      this.isl.gJb = this;
      return;
      if ((this.ikk instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.ikk);
      }
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.isZ = e.b.isX;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(a.g.card_get_code_network_connet_failure);
    }
    for (;;)
    {
      localc.aox = paramString;
      localMessage.obj = localc;
      this.isO.sendMessage(localMessage);
      return;
      if (paramInt == 2) {
        paramString = getString(a.g.card_code_cannot_get);
      } else {
        paramString = getString(a.g.card_get_code_failure);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, e.a parama, ArrayList<mb> paramArrayList)
  {
    this.ikk = paramb;
    this.isN = parama;
    this.ikq = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    if (paramBoolean1)
    {
      localObject1 = this.ikk.azy().sHF;
      if (this.ikk.azr())
      {
        com.tencent.mm.plugin.card.d.b.a(this.isl, paramb.ild, paramb.ile, paramBoolean2, this.ikk);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11941, new Object[] { Integer.valueOf(17), this.ikk.azB(), this.ikk.azC(), "", this.ikk.azy().sHF.title });
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((ra)localObject1).sIf)) && (!TextUtils.isEmpty(((ra)localObject1).sIg)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.ikk.azB(), (ra)localObject1, this.isN.ipv, this.isN.isT);
        localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
        str1 = this.ikk.azB();
        str2 = this.ikk.azC();
        if (((ra)localObject1).title != null) {}
        for (paramb = ((ra)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((ra)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.y(((ra)localObject1).url, ((ra)localObject1).sJq);
        com.tencent.mm.plugin.card.d.b.a(this.isl, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
        str1 = this.ikk.azB();
        str2 = this.ikk.azC();
        if (((ra)localObject1).title != null) {}
        for (paramb = ((ra)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
      j = this.ikk.azx().ilo;
      localObject2 = this.ikk.azC();
      str1 = this.ikk.azB();
      k = this.isN.ipv;
      str2 = this.isN.irV;
      if (this.ikk.azv()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        yE(paramb.ila);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
    int k = this.ikk.azx().ilo;
    Object localObject2 = this.ikk.azC();
    String str1 = this.ikk.azB();
    int m = this.isN.ipv;
    String str2 = this.isN.irV;
    if (this.ikk.azv()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      yE(paramb.ila);
      return;
    }
  }
  
  public final void aAW()
  {
    if (this.ikk == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.isM != null) {
        this.isM.aBB();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.ikk.azx() != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
        } while (this.isM == null);
        this.isM.aBB();
        return;
        if (this.ikk.azy() != null) {
          break;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      } while (this.isM == null);
      this.isM.aBB();
      return;
      if (this.ikk.azk()) {
        break label229;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.ikk.azx().ilo) });
      if (TextUtils.isEmpty(this.ikk.azx().sIw)) {
        break;
      }
      com.tencent.mm.plugin.card.d.b.a(this.isl, this.ikk.azx().sIw, 0);
    } while (this.isM == null);
    this.isM.aBB();
    return;
    com.tencent.mm.ui.base.h.a(this.isl, getString(a.g.card_not_support_card_type), null, false, new e.2(this));
    return;
    label229:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.ikk.azx().sIR);
    Object localObject1 = this.isG;
    Object localObject2 = this.ikk;
    Object localObject3 = this.ikq;
    int i = this.isN.drX;
    ((com.tencent.mm.plugin.card.b.f)localObject1).ikk = ((com.tencent.mm.plugin.card.base.b)localObject2);
    ((com.tencent.mm.plugin.card.b.f)localObject1).ikq = ((ArrayList)localObject3);
    ((com.tencent.mm.plugin.card.b.f)localObject1).drX = i;
    if (this.ism == null)
    {
      i = 0;
      if (i != 0)
      {
        this.ism.release();
        this.ism = null;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.ikk.azx().ilo) });
      }
      if (this.ism == null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.ikk.azx().ilo) });
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.ikk.azx().ilo) });
        if (!this.ikk.aze()) {
          break label2164;
        }
        this.ism = new com.tencent.mm.plugin.card.ui.a.h(this.isl);
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.ikk.azx().ilo) });
      this.ism.a(this.ikk, this.isN);
      this.ism.aCT();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "");
      if (this.ism.aCB()) {
        break label2336;
      }
      this.isl.setMMTitle("");
      label547:
      if (this.ikk != null) {
        break label2353;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      if (!this.ism.aCC()) {
        break label2851;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.isn.update();
      label589:
      if (!this.ism.aCt()) {
        break label2869;
      }
      if (this.isD == null)
      {
        this.isD = new com.tencent.mm.plugin.card.ui.view.b();
        this.isD.a(this);
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.isD.update();
      label642:
      this.isl.ey(this.ism.aCx());
      if (this.ism.aCy())
      {
        this.isJ.clear();
        this.isL.clear();
        if (!this.ikk.azm()) {
          break label6825;
        }
        this.isL.add(getString(a.g.card_wv_alert_share_to_friend));
        this.isJ.put(Integer.valueOf(0), "menu_func_share_friend");
        this.isL.add(getString(a.g.card_wv_alert_share_timeline));
        this.isJ.put(Integer.valueOf(1), "menu_func_share_timeline");
      }
    }
    label923:
    label1250:
    label6627:
    for (i = 2;; i = 0)
    {
      int j = i;
      if (!TextUtils.isEmpty(this.ikk.azy().sHB))
      {
        this.isL.add(getString(a.g.card_menu_report));
        this.isJ.put(Integer.valueOf(i), "menu_func_report");
        j = i + 1;
      }
      oZ(j);
      if (this.isL.size() > 0) {
        this.isl.ey(true);
      }
      if (this.ism.aCz())
      {
        this.isJ.clear();
        this.isL.clear();
        if ((!this.ikk.azd()) || (!this.ikk.azl())) {
          break label6820;
        }
        if (bk.bl(this.ikk.azx().sJc)) {
          break label2894;
        }
        this.isL.add(this.ikk.azx().sJc);
        this.isJ.put(Integer.valueOf(0), "menu_func_gift");
      }
      label3299:
      for (j = 1;; j = 0)
      {
        i = j;
        if (!TextUtils.isEmpty(this.ikk.azy().sHB))
        {
          this.isL.add(getString(a.g.card_menu_report));
          this.isJ.put(Integer.valueOf(j), "menu_func_report");
          i = j + 1;
        }
        if (this.ikk.azd())
        {
          this.isL.add(getString(a.g.app_delete));
          this.isJ.put(Integer.valueOf(i), "menu_func_delete");
          j = i + 1;
          oZ(j);
          if (this.isL.size() > 0) {
            this.isl.ey(true);
          }
          if (this.ism.aCA())
          {
            this.isJ.clear();
            this.isL.clear();
            if (TextUtils.isEmpty(this.ikk.azy().sHB)) {
              break label6815;
            }
            this.isL.add(getString(a.g.card_menu_report));
            this.isJ.put(Integer.valueOf(0), "menu_func_report");
          }
        }
        label1896:
        label6248:
        for (i = 1;; i = 0)
        {
          oZ(i);
          if (this.isL.size() > 0) {
            this.isl.ey(true);
          }
          if ((this.isr != null) && ((this.isr instanceof com.tencent.mm.plugin.card.widget.b))) {
            ((com.tencent.mm.plugin.card.widget.b)this.isr).aDo();
          }
          w(this.ism.aCv(), this.ism.aCw());
          if ((!this.ikk.azf()) && (this.ism.aCE()))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
            this.isp.update();
            if (this.isr != null) {
              this.isr.eE(this.ism.aBP());
            }
            if (!this.bNW) {
              break label3131;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            if (!this.ism.aCJ()) {
              break label4758;
            }
            if (this.isv == null)
            {
              this.isv = new com.tencent.mm.plugin.card.ui.view.y();
              this.isv.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
            this.isv.update();
            if (!this.ism.aCS()) {
              break label4783;
            }
            if (this.isu == null)
            {
              this.isu = new com.tencent.mm.plugin.card.ui.view.c();
              this.isu.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
            this.isu.update();
            label1396:
            if (!this.ism.aCK()) {
              break label4808;
            }
            if (this.isw == null)
            {
              this.isw = new k();
              this.isw.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
            this.isw.update();
            if (!this.ism.aCL()) {
              break label4833;
            }
            if (this.isx == null)
            {
              this.isx = new w();
              this.isx.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
            this.isx.update();
            if (!this.ism.aCM()) {
              break label4858;
            }
            if (this.isy == null)
            {
              this.isy = new com.tencent.mm.plugin.card.ui.view.l();
              this.isy.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
            this.isy.update();
            if (!this.ism.aCN()) {
              break label4883;
            }
            if (this.isz == null)
            {
              this.isz = new z();
              this.isz.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
            this.isz.update();
            if (!this.ism.aCP()) {
              break label4908;
            }
            if (this.isA == null)
            {
              this.isA = new com.tencent.mm.plugin.card.ui.view.e();
              this.isA.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
            this.isA.update();
            label1661:
            if (!this.ism.aCO()) {
              break label4933;
            }
            if (this.isB == null)
            {
              this.isB = new u();
              this.isB.a(this);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
            this.isB.update();
            if (this.ism.aCG()) {
              break label4958;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            if (!this.ism.aCH()) {
              break label6755;
            }
            localObject1 = this.ikk.azy();
            this.ikk.a((lv)localObject1);
            com.tencent.mm.plugin.card.d.l.h(this.ikk);
            if (!this.ism.aCI()) {
              break label6738;
            }
            if (this.iss != null) {
              break label6703;
            }
            if ((this.ikk.azx().sIV == null) || (!this.ikk.azx().sIV.sRk)) {
              break label6658;
            }
            this.iss = new com.tencent.mm.plugin.card.ui.view.m();
            localObject1 = am.aAI();
            if (((com.tencent.mm.plugin.card.b.g)localObject1).fKm == null) {
              ((com.tencent.mm.plugin.card.b.g)localObject1).fKm = new ArrayList();
            }
            if (this != null) {
              ((com.tencent.mm.plugin.card.b.g)localObject1).fKm.add(new WeakReference(this));
            }
            this.iss.a(this);
            this.iss.update();
            if (this.isr != null) {
              this.isr.eD(true);
            }
            label1913:
            if (!this.ism.aCQ()) {
              break label6797;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
            this.isC.update();
          }
          label4714:
          for (;;)
          {
            this.isE.ikk = this.ikk;
            return;
            if (this.ikk.aze())
            {
              if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.h))
              {
                i = 0;
                break;
              }
              i = 1;
              break;
            }
            if (this.ikk.azf())
            {
              if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.e))
              {
                i = 0;
                break;
              }
              i = 1;
              break;
            }
            if (this.ikk.azi())
            {
              if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.b))
              {
                i = 0;
                break;
              }
              i = 1;
              break;
            }
            if (this.ikk.azg())
            {
              if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.c))
              {
                i = 0;
                break;
              }
              i = 1;
              break;
            }
            if (this.ikk.azh())
            {
              if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.f))
              {
                i = 0;
                break;
              }
              i = 1;
              break;
            }
            if (this.ikk.azj())
            {
              if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.d))
              {
                i = 0;
                break;
              }
              i = 1;
              break;
            }
            if ((this.ism instanceof com.tencent.mm.plugin.card.ui.a.a))
            {
              i = 0;
              break;
            }
            i = 1;
            break;
            label2164:
            switch (this.ikk.azx().ilo)
            {
            default: 
              this.ism = new com.tencent.mm.plugin.card.ui.a.a(this.isl);
              break;
            case 0: 
              this.ism = new com.tencent.mm.plugin.card.ui.a.c(this.isl);
              break;
            case 10: 
              this.ism = new com.tencent.mm.plugin.card.ui.a.e(this.isl);
              break;
            case 11: 
              this.ism = new com.tencent.mm.plugin.card.ui.a.b(this.isl);
              break;
            case 20: 
              this.ism = new com.tencent.mm.plugin.card.ui.a.f(this.isl);
              break;
            case 30: 
              this.ism = new com.tencent.mm.plugin.card.ui.a.d(this.isl);
              break;
              this.isl.setMMTitle(this.isG.getTitle());
              break label547;
              if (this.isr != null) {
                if (this.ikk.azf())
                {
                  if ((this.isr instanceof com.tencent.mm.plugin.card.widget.e)) {
                    break label2708;
                  }
                  i = 1;
                  if (i != 0)
                  {
                    localObject1 = this.isr.gv();
                    if (localObject1 != null) {
                      this.dK.removeView((View)localObject1);
                    }
                    this.dK.removeAllViews();
                    this.dK.invalidate();
                    this.isr.release();
                    this.isr = null;
                  }
                  if (this.isr == null)
                  {
                    if (!this.ikk.azf()) {
                      break label2713;
                    }
                    this.isr = new com.tencent.mm.plugin.card.widget.e(this.isl);
                  }
                }
              }
              for (;;)
              {
                this.isr.i(this.ikk);
                localObject1 = this.isr.gv();
                if (localObject1 != null)
                {
                  localObject2 = this.dK;
                  ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                  ((LinearLayout)localObject2).addView((View)localObject1);
                }
                this.dK.invalidate();
                this.isr.setOnClickListener(this.fvj);
                w(false, false);
                if (this.isr == null) {
                  break;
                }
                if (this.ikk.azh()) {
                  ((com.tencent.mm.plugin.card.widget.f)this.isr).ikq = this.ikq;
                }
                this.isr.d(this.ikk);
                break;
                if (this.ikk.azi())
                {
                  if ((this.isr instanceof com.tencent.mm.plugin.card.widget.c)) {
                    break label2708;
                  }
                  i = 1;
                  break label2384;
                }
                if (this.ikk.azg())
                {
                  if ((this.isr instanceof com.tencent.mm.plugin.card.widget.b)) {
                    break label2708;
                  }
                  i = 1;
                  break label2384;
                }
                if (this.ikk.azh())
                {
                  if ((this.isr instanceof com.tencent.mm.plugin.card.widget.f)) {
                    break label2708;
                  }
                  i = 1;
                  break label2384;
                }
                if ((this.ikk.azj()) && (!(this.isr instanceof com.tencent.mm.plugin.card.widget.d)))
                {
                  i = 1;
                  break label2384;
                }
                i = 0;
                break label2384;
                if (this.ikk.azi()) {
                  this.isr = new com.tencent.mm.plugin.card.widget.c(this.isl);
                } else if (this.ikk.azg()) {
                  this.isr = new com.tencent.mm.plugin.card.widget.b(this.isl);
                } else if (this.ikk.azh()) {
                  this.isr = new com.tencent.mm.plugin.card.widget.f(this.isl);
                } else if (this.ikk.azj()) {
                  this.isr = new com.tencent.mm.plugin.card.widget.d(this.isl);
                } else {
                  this.isr = new com.tencent.mm.plugin.card.widget.b(this.isl);
                }
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
              this.isn.aCU();
              break label589;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
              if (this.isD == null) {
                break label642;
              }
              this.isD.aCU();
              break label642;
              if (this.ikk.azj())
              {
                this.isL.add(getString(a.g.card_menu_invoice_gift_card));
                break label923;
              }
              this.isL.add(getString(a.g.card_menu_gift_card));
              break label923;
              j = i;
              if (!this.ikk.aze()) {
                break label1040;
              }
              localObject1 = com.tencent.mm.model.q.Gj();
              localObject2 = this.ikk.azD();
              if ((localObject1 != null) && (((String)localObject1).equals(localObject2)))
              {
                this.isL.add(getString(a.g.app_delete));
                this.isJ.put(Integer.valueOf(i), "menu_func_delete_share_card");
                j = i + 1;
                break label1040;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
              j = i;
              break label1040;
              if ((this.ikk.azf()) && (this.ism.aCE()))
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.isq.update();
                break label1250;
              }
              if (this.ism.aCF())
              {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.isq.update();
                break label1250;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
              this.isq.aCU();
              this.isp.aCU();
              break label1250;
              if ((this.ikk.azd()) && (this.ikk.azf()))
              {
                this.ipf.findViewById(a.d.card_detain_ui).setBackgroundColor(this.isl.getResources().getColor(a.a.card_bg_color));
                com.tencent.mm.ui.statusbar.a.d(this.ipf, -1, true);
                this.isl.J(-1, true);
                label3199:
                localObject3 = this.ipf.findViewById(a.d.detail_first_container);
                localObject2 = this.ipf.findViewById(a.d.header_view);
                localObject1 = this.ipf.findViewById(a.d.detail_body_layout);
                if ((!this.ikk.azd()) || (!this.ism.aCE())) {
                  break label4390;
                }
                if (!this.ikk.azg()) {
                  break label4256;
                }
                ((View)localObject3).setBackgroundResource(a.c.card_white_sequare_top_bg);
                this.ipf.findViewById(a.d.from_username_container).setBackgroundResource(a.c.card_gray_sequare_bottom_bg);
                ((View)localObject1).setBackgroundResource(0);
                Object localObject5;
                if (this.ikk.azj())
                {
                  localObject4 = (TextView)this.ipf.findViewById(a.d.bottom_wave);
                  localObject5 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.EX(a.c.card_wavy));
                  ((BitmapDrawable)localObject5).setTileModeX(Shader.TileMode.REPEAT);
                  ((TextView)localObject4).setBackgroundDrawable((Drawable)localObject5);
                  ((TextView)localObject4).setVisibility(0);
                }
                localObject4 = new Rect(0, 0, 0, 0);
                ((View)localObject3).setPadding(((Rect)localObject4).left, ((Rect)localObject4).top, ((Rect)localObject4).right, ((Rect)localObject4).bottom);
                ((View)localObject3).invalidate();
                ((View)localObject1).setPadding(((Rect)localObject4).left, ((Rect)localObject4).top, ((Rect)localObject4).right, ((Rect)localObject4).bottom);
                ((View)localObject1).invalidate();
                if ((this.ikk.aze()) && (this.ism.aCC()) && (this.iso))
                {
                  localObject5 = this.ipf.findViewById(a.d.share_users_bottom_layout);
                  ((View)localObject5).setPadding(((Rect)localObject4).left, ((Rect)localObject4).top, ((Rect)localObject4).right, ((Rect)localObject4).bottom);
                  ((View)localObject5).invalidate();
                }
                if ((this.ikk.azd()) && (this.ism.aCE()))
                {
                  localObject5 = this.ipf.findViewById(a.d.from_username_container);
                  ((Rect)localObject4).left = this.isl.getResources().getDimensionPixelOffset(a.b.LargePadding);
                  ((Rect)localObject4).right = this.isl.getResources().getDimensionPixelOffset(a.b.LargePadding);
                  ((View)localObject5).setPadding(((Rect)localObject4).left, ((Rect)localObject4).top, ((Rect)localObject4).right, ((Rect)localObject4).bottom);
                  ((View)localObject5).invalidate();
                  if (this.ikk.azh())
                  {
                    localObject4 = this.ipf.findViewById(a.d.from_username_layout);
                    localObject5 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
                    i = this.isl.getResources().getDimensionPixelSize(a.b.SmallPadding);
                    ((LinearLayout.LayoutParams)localObject5).rightMargin = i;
                    ((LinearLayout.LayoutParams)localObject5).leftMargin = i;
                    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                  }
                }
                if ((!this.ism.aCE()) && (!this.ism.aCC())) {
                  break label4614;
                }
                if ((this.isr != null) && (((this.ikk.azd()) && (this.ikk.azg())) || (this.ikk.aze()))) {
                  this.isr.ph(0);
                }
                if ((this.isr != null) && (this.ikk.azd()) && (this.ikk.azf()))
                {
                  i = this.isl.getResources().getDimensionPixelOffset(a.b.card_member_widget_bg_big_round_radius);
                  localObject4 = com.tencent.mm.plugin.card.d.l.cx(com.tencent.mm.plugin.card.d.l.yR(this.ikk.azx().color), i);
                  this.isr.a((ShapeDrawable)localObject4);
                }
                if ((this.ikk.azd()) && (this.ikk.azf()))
                {
                  localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
                  ((LinearLayout.LayoutParams)localObject4).bottomMargin = 0;
                  ((LinearLayout.LayoutParams)localObject4).topMargin = 0;
                  ((LinearLayout.LayoutParams)localObject4).rightMargin = 0;
                  ((LinearLayout.LayoutParams)localObject4).leftMargin = 0;
                  if (TextUtils.isEmpty(this.ikk.azx().sIB)) {
                    break label4699;
                  }
                  ((LinearLayout.LayoutParams)localObject4).weight = 0.0F;
                  ((LinearLayout.LayoutParams)localObject4).height = -2;
                  ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
                  localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
                  i = this.isl.getResources().getDimensionPixelSize(a.b.MiddlePadding);
                  ((LinearLayout.LayoutParams)localObject3).rightMargin = i;
                  ((LinearLayout.LayoutParams)localObject3).leftMargin = i;
                  if (!this.ikk.azf()) {
                    break label4714;
                  }
                  ((LinearLayout.LayoutParams)localObject3).topMargin = this.isl.getResources().getDimensionPixelSize(a.b.ListPadding);
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = this.isl.getResources().getDimensionPixelSize(a.b.LittlePadding);
                  i = this.isl.getResources().getDimensionPixelSize(a.b.LargerPadding);
                  ((LinearLayout.LayoutParams)localObject3).rightMargin = i;
                  ((LinearLayout.LayoutParams)localObject3).leftMargin = i;
                  ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
                  localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
                  ((LinearLayout.LayoutParams)localObject2).bottomMargin = 0;
                  ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
                  ((LinearLayout.LayoutParams)localObject2).rightMargin = 0;
                  ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
                  if (this.ikk.azf()) {
                    ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.isl.getResources().getDimensionPixelSize(a.b.LargerPadding);
                  }
                  if (TextUtils.isEmpty(this.ikk.azx().sIB)) {
                    break label4743;
                  }
                  ((LinearLayout.LayoutParams)localObject2).weight = 0.0F;
                  ((LinearLayout.LayoutParams)localObject2).height = -2;
                }
              }
              for (;;)
              {
                ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                if (!TextUtils.isEmpty(this.ikk.azx().sIB))
                {
                  localObject1 = findViewById(a.d.advertise_layout);
                  localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
                  ((LinearLayout.LayoutParams)localObject2).height = 0;
                  ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
                  ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                }
                this.ipf.invalidate();
                break;
                i = com.tencent.mm.plugin.card.d.l.yR(this.ikk.azx().color);
                this.ipf.findViewById(a.d.card_detain_ui).setBackgroundColor(i);
                com.tencent.mm.ui.statusbar.a.d(this.ipf, i, true);
                this.isl.J(i, false);
                break label3199;
                if (this.ikk.azf())
                {
                  this.ipf.findViewById(a.d.from_username_container).setBackgroundResource(0);
                  ((View)localObject1).setBackgroundColor(this.isl.getResources().getColor(a.a.card_bg_color));
                  break label3299;
                }
                if (this.ikk.azh())
                {
                  ((View)localObject3).setBackgroundResource(a.c.card_white_sequare_top_bg);
                  this.ipf.findViewById(a.d.from_username_container).setBackgroundResource(a.c.card_gray_sequare_bottom_bg);
                  ((View)localObject1).setBackgroundResource(0);
                  break label3299;
                }
                if ((this.ikk.azi()) || (!this.ikk.azj())) {
                  break label3299;
                }
                ((View)localObject1).setBackgroundColor(this.isl.getResources().getColor(a.a.card_bg_color));
                break label3299;
                if (this.ikk.aze())
                {
                  if ((this.ism.aCC()) && (this.iso))
                  {
                    ((View)localObject3).setBackgroundResource(a.c.card_white_sequare_top_bg);
                    ((View)localObject1).setBackgroundResource(0);
                    break label3299;
                  }
                  if ((this.ism.aCC()) && (!this.iso))
                  {
                    ((View)localObject3).setBackgroundResource(a.c.card_white_bottom_bg);
                    ((View)localObject1).setBackgroundResource(0);
                    break label3299;
                  }
                  ((View)localObject3).setBackgroundResource(0);
                  if (this.ism.aBP())
                  {
                    ((View)localObject1).setBackgroundResource(a.c.card_white_bottom_bg);
                    break label3299;
                  }
                  ((View)localObject1).setBackgroundResource(a.c.card_white_sequare_top_bg);
                  break label3299;
                }
                if (this.ikk.azg())
                {
                  ((View)localObject3).setBackgroundResource(0);
                  if (this.ism.aBP())
                  {
                    ((View)localObject1).setBackgroundResource(a.c.card_white_bottom_bg);
                    break label3299;
                  }
                  ((View)localObject1).setBackgroundResource(a.c.card_white_sequare_top_bg);
                  break label3299;
                }
                if (this.ikk.azh())
                {
                  ((View)localObject3).setBackgroundResource(a.c.card_widget_member_bg);
                  ((View)localObject1).setBackgroundResource(0);
                  break label3299;
                }
                ((View)localObject3).setBackgroundResource(0);
                ((View)localObject1).setBackgroundColor(this.isl.getResources().getColor(a.a.card_bg_color));
                break label3299;
                if ((this.isr == null) || (((!this.ikk.azd()) || (!this.ikk.azg())) && (!this.ikk.aze()))) {
                  break label3752;
                }
                if (this.ism.aBP())
                {
                  this.isr.ph(a.c.card_white_top_bg);
                  break label3752;
                }
                this.isr.ph(a.c.card_white_sequare_bottom_bg);
                break label3752;
                ((LinearLayout.LayoutParams)localObject4).height = 0;
                ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
                break label3918;
                i = this.isl.getResources().getDimensionPixelSize(a.b.BiggerPadding);
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = i;
                ((LinearLayout.LayoutParams)localObject3).topMargin = i;
                break label4035;
                ((LinearLayout.LayoutParams)localObject2).height = 0;
                ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
              }
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
              if (this.isv == null) {
                break label1343;
              }
              this.isv.aCU();
              break label1343;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
              if (this.isu == null) {
                break label1396;
              }
              this.isu.aCU();
              break label1396;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
              if (this.isw == null) {
                break label1449;
              }
              this.isw.aCU();
              break label1449;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
              if (this.isx == null) {
                break label1502;
              }
              this.isx.aCU();
              break label1502;
              label4858:
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
              if (this.isy == null) {
                break label1555;
              }
              this.isy.aCU();
              break label1555;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
              if (this.isz == null) {
                break label1608;
              }
              this.isz.aCU();
              break label1608;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
              if (this.isA == null) {
                break label1661;
              }
              this.isA.aCU();
              break label1661;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
              if (this.isB == null) {
                break label1714;
              }
              this.isB.aCU();
              break label1714;
              this.iko.clear();
              localObject1 = this.iko;
              localObject2 = this.isG;
              ((com.tencent.mm.plugin.card.b.f)localObject2).iko.clear();
              if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHJ != null) && (!bk.bl(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHJ.title)))
              {
                localObject3 = new com.tencent.mm.plugin.card.model.b();
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilz = 1;
                ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHJ.title;
                ((com.tencent.mm.plugin.card.model.b)localObject3).ioU = "";
                ((com.tencent.mm.plugin.card.model.b)localObject3).url = "card://jump_card_gift";
                ((com.tencent.mm.plugin.card.model.b)localObject3).iQn = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHJ.iQn;
                ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(localObject3);
              }
              if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHs != null) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHs.size() > 0))
              {
                localObject3 = com.tencent.mm.plugin.card.d.l.aR(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHs);
                if (localObject3 != null)
                {
                  ((com.tencent.mm.plugin.card.model.b)((List)localObject3).get(0)).ilA = false;
                  ((com.tencent.mm.plugin.card.b.f)localObject2).iko.addAll((Collection)localObject3);
                }
              }
              if (((((com.tencent.mm.plugin.card.b.f)localObject2).drX == 6) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHw <= 0)) || ((com.tencent.mm.plugin.card.d.l.pg(((com.tencent.mm.plugin.card.b.f)localObject2).drX)) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.isNormal()) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azd()) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azl())))
              {
                localObject3 = new com.tencent.mm.plugin.card.model.b();
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilz = 1;
                if (!bk.bl(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sJc))
                {
                  ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sJc;
                  ((com.tencent.mm.plugin.card.model.b)localObject3).ioU = "";
                  ((com.tencent.mm.plugin.card.model.b)localObject3).url = "card://jump_gift";
                  ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(localObject3);
                }
              }
              else
              {
                if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().status != 0) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().status != 1)) {
                  i = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().status;
                }
                if ((((com.tencent.mm.plugin.card.b.f)localObject2).drX != 3) && (((com.tencent.mm.plugin.card.b.f)localObject2).drX == 6)) {
                  i = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHw;
                }
                localObject4 = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sII;
                if (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHC != null) {
                  TextUtils.isEmpty(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().sHC.title);
                }
                localObject3 = new com.tencent.mm.plugin.card.model.b();
                if (!((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azj()) {
                  break label6196;
                }
                i = 0;
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilA = false;
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilz = 1;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.card.b.f)localObject2).getTitle());
                ((StringBuilder)localObject4).append(((com.tencent.mm.plugin.card.b.f)localObject2).getString(a.g.card_detail_info));
                ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((StringBuilder)localObject4).toString();
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilq = "";
                ((com.tencent.mm.plugin.card.model.b)localObject3).ioU = "";
                ((com.tencent.mm.plugin.card.model.b)localObject3).url = "card://jump_detail";
                if (i != 0) {
                  ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(localObject3);
                }
                if ((!((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azh()) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu <= 0))
                {
                  if ((!((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azf()) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu <= 0))
                  {
                    if (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu <= 0) {
                      break label6014;
                    }
                    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailDataMgr", "shop_count:" + ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu);
                    if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu > 0) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikq != null) && (((com.tencent.mm.plugin.card.b.f)localObject2).ikq.size() > 0))
                    {
                      localObject3 = (mb)((com.tencent.mm.plugin.card.b.f)localObject2).ikq.get(0);
                      if ((localObject3 == null) || (((mb)localObject3).sIe >= 50000.0F)) {
                        break label6248;
                      }
                      localObject4 = new com.tencent.mm.plugin.card.model.b();
                      ((com.tencent.mm.plugin.card.model.b)localObject4).ilz = 2;
                      ((com.tencent.mm.plugin.card.model.b)localObject4).title = ((mb)localObject3).name;
                      ((com.tencent.mm.plugin.card.model.b)localObject4).ilq = ((com.tencent.mm.plugin.card.b.f)localObject2).hxN.getString(a.g.card_shop_distance_address, new Object[] { com.tencent.mm.plugin.card.d.l.f(((com.tencent.mm.plugin.card.b.f)localObject2).hxN, ((mb)localObject3).sIe), ((mb)localObject3).ekZ });
                      ((com.tencent.mm.plugin.card.model.b)localObject4).ioU = "";
                      ((com.tencent.mm.plugin.card.model.b)localObject4).url = "card://jump_shop";
                      ((com.tencent.mm.plugin.card.model.b)localObject4).ilD = ((mb)localObject3).ilD;
                      ((com.tencent.mm.plugin.card.model.b)localObject4).color = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().color;
                      ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(localObject4);
                    }
                  }
                  if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu <= 0) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikq != null)) {
                    break label6299;
                  }
                  localObject3 = new com.tencent.mm.plugin.card.model.b();
                  ((com.tencent.mm.plugin.card.model.b)localObject3).ilz = 1;
                  if (TextUtils.isEmpty(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIT)) {
                    break label6283;
                  }
                  ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIT;
                  ((com.tencent.mm.plugin.card.model.b)localObject3).ilq = "";
                  ((com.tencent.mm.plugin.card.model.b)localObject3).ioU = "";
                  ((com.tencent.mm.plugin.card.model.b)localObject3).url = "card://jump_shop_list";
                  ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(localObject3);
                }
              }
              label6014:
              while ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu <= 0) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikq == null) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikq.size() <= 0)) {
                for (;;)
                {
                  if (((!((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azj()) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azy().status != 3)) && (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIn))) {
                    ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(((com.tencent.mm.plugin.card.b.f)localObject2).azW());
                  }
                  ((List)localObject1).addAll(((com.tencent.mm.plugin.card.b.f)localObject2).iko);
                  localObject1 = this.ist;
                  localObject2 = this.iko;
                  ((m)localObject1).iko.clear();
                  ((m)localObject1).iko.addAll((Collection)localObject2);
                  this.ist.ixo = this.ikk.azj();
                  this.ist.notifyDataSetChanged();
                  break;
                  if (((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azj())
                  {
                    ((com.tencent.mm.plugin.card.model.b)localObject3).title = ae.getResources().getString(a.g.card_menu_invoice_gift_card);
                    break label5325;
                  }
                  ((com.tencent.mm.plugin.card.model.b)localObject3).title = ae.getContext().getString(a.g.card_menu_gift_card);
                  break label5325;
                  if ((localObject4 != null) && (((tw)localObject4).sQI != null) && (((tw)localObject4).sQI.size() > 0) && (!TextUtils.isEmpty((CharSequence)((tw)localObject4).sQI.get(0))))
                  {
                    i = 0;
                    break label5508;
                  }
                  i = 1;
                  break label5508;
                  if (localObject3 == null) {
                    break label5903;
                  }
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailDataMgr", "distance:" + ((mb)localObject3).sIe);
                  break label5903;
                  ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).getString(a.g.card_adapted_stores);
                }
              }
              localObject3 = new com.tencent.mm.plugin.card.model.b();
              ((com.tencent.mm.plugin.card.model.b)localObject3).ilz = 1;
              Object localObject4 = (mb)((com.tencent.mm.plugin.card.b.f)localObject2).ikq.get(0);
              if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIT))
              {
                ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIT;
                if ((!((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azf()) || (((mb)localObject4).sIe >= 2000.0F)) {
                  break label6648;
                }
                if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu <= 1) && ((((com.tencent.mm.plugin.card.b.f)localObject2).ikq == null) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikq.size() <= 1))) {
                  break label6627;
                }
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilq = ((com.tencent.mm.plugin.card.b.f)localObject2).hxN.getString(a.g.card_membership_most_nearby_shop, new Object[] { com.tencent.mm.plugin.card.d.l.f(((com.tencent.mm.plugin.card.b.f)localObject2).hxN, ((mb)localObject4).sIe) });
              }
              for (;;)
              {
                ((com.tencent.mm.plugin.card.model.b)localObject3).ioU = "";
                ((com.tencent.mm.plugin.card.model.b)localObject3).url = "card://jump_shop_list";
                ((com.tencent.mm.plugin.card.b.f)localObject2).iko.add(localObject3);
                break;
                if ((!((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azf()) && (((mb)localObject4).sIe < 5000.0F))
                {
                  if ((((com.tencent.mm.plugin.card.b.f)localObject2).ikk.azx().sIu == 1) || (((com.tencent.mm.plugin.card.b.f)localObject2).ikq.size() == 1))
                  {
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                    break;
                  }
                  ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).getString(a.g.card_check_more_adapted_stores);
                  break label6400;
                }
                ((com.tencent.mm.plugin.card.model.b)localObject3).title = ((com.tencent.mm.plugin.card.b.f)localObject2).getString(a.g.card_adapted_stores);
                break label6400;
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilq = com.tencent.mm.plugin.card.d.l.f(((com.tencent.mm.plugin.card.b.f)localObject2).hxN, ((mb)localObject4).sIe);
                continue;
                label6648:
                ((com.tencent.mm.plugin.card.model.b)localObject3).ilq = "";
              }
              if (this.ikk.azx().ilo == 10)
              {
                this.iss = new com.tencent.mm.plugin.card.ui.view.q();
                break label1881;
              }
              this.iss = new com.tencent.mm.plugin.card.ui.view.j();
              break label1881;
              if (!this.iss.f(this.ikk)) {
                break label1896;
              }
              this.iss.b(this.ikk);
              this.iss.update();
              break label1896;
              if (this.iss == null) {
                break label1896;
              }
              this.iss.aCU();
              break label1896;
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
              if (this.iss != null) {
                this.iss.aCU();
              }
              if (this.isr == null) {
                break label1913;
              }
              this.isr.eD(false);
              break label1913;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
              this.isC.aCU();
            }
          }
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.card.base.b aBE()
  {
    return this.ikk;
  }
  
  public final boolean aBF()
  {
    return this.iso;
  }
  
  public final void aBG()
  {
    this.iso = false;
  }
  
  public final MMActivity aBH()
  {
    return this.isl;
  }
  
  public final View.OnClickListener aBI()
  {
    return this.fvj;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g aBJ()
  {
    return this.ism;
  }
  
  public final e.d aBK()
  {
    return this.isM;
  }
  
  public final e.a aBL()
  {
    return this.isN;
  }
  
  public final com.tencent.mm.plugin.card.b.f aBM()
  {
    return this.isG;
  }
  
  public final j aBN()
  {
    return this.isE;
  }
  
  public final int aBO()
  {
    if (this.isG == null) {}
    for (;;)
    {
      return 0;
      com.tencent.mm.plugin.card.b.f localf = this.isG;
      if (localf.ikp == null) {}
      for (boolean bool = false; bool; bool = localf.ikp.ilC) {
        return 1;
      }
    }
  }
  
  public final boolean aBP()
  {
    if (this.ism == null) {
      return false;
    }
    return this.ism.aBP();
  }
  
  public final void azX()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.isZ = e.b.isV;
    localMessage.obj = localc;
    this.isO.sendMessage(localMessage);
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    if (paramb != null)
    {
      this.ikk = paramb;
      if (this.isM != null) {
        this.isM.b(paramb);
      }
      aAW();
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.isZ = e.b.isW;
    localc.ita = paramc;
    localMessage.obj = localc;
    this.isO.sendMessage(localMessage);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        this.isH = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.isH;
        if (this.ikk.azx() == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.ikk.azz().tIn)) && (!this.ikk.azj())) {
            localStringBuilder.append(this.ikk.azz().tIn);
          }
        }
        for (;;)
        {
          String str = this.ikk.azx().title + "\n" + this.ikk.azx().imA;
          t.a.sdu.a(this.isl.mController, localStringBuilder.toString(), this.ikk.azx().ilp, str, true, this.isl.getResources().getString(a.g.app_send), new e.6(this, paramInt1, paramIntent));
          return;
          localStringBuilder.append(getString(a.g.sns_post_to));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(a.g.card_share_to) + this.isG.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(a.g.card_recommend_to) + this.isG.getTitle());
          }
        }
      } while (paramInt2 != -1);
      this.ipW = paramIntent.getIntExtra("Ktag_range_index", 0);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.ipW) });
      if (this.ipW >= 2)
      {
        this.ipX = paramIntent.getStringExtra("Klabel_name_list");
        this.ipY = paramIntent.getStringExtra("Kother_user_name_list");
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.ipW), this.ipX });
        if ((TextUtils.isEmpty(this.ipX)) && (TextUtils.isEmpty(this.ipY)))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
          return;
        }
        paramIntent = Arrays.asList(this.ipX.split(","));
        this.iqa = com.tencent.mm.plugin.card.d.l.aT(paramIntent);
        this.ipZ = com.tencent.mm.plugin.card.d.l.aS(paramIntent);
        if ((this.ipY != null) && (this.ipY.length() > 0))
        {
          paramIntent = Arrays.asList(this.ipY.split(","));
          this.ipZ.addAll(paramIntent);
        }
        if (this.iqa != null) {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.iqa.size());
        }
        if (this.ipZ != null)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.ipZ.size());
          paramIntent = this.ipZ.iterator();
          while (paramIntent.hasNext()) {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
          }
        }
        if (this.ipW == 2)
        {
          this.isC.yH(this.isl.getString(a.g.card_share_card_private_setting_share, new Object[] { aAY() }));
          return;
        }
        if (this.ipW == 3)
        {
          this.isC.yH(this.isl.getString(a.g.card_share_card_private_setting_not_share, new Object[] { aAY() }));
          return;
        }
        this.isC.yH(this.isl.getString(a.g.card_share_card_private_setting));
        return;
      }
      this.isC.yH(this.isl.getString(a.g.card_share_card_private_setting));
      return;
    } while (this.isM == null);
    this.isM.aBD();
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.isZ = e.b.isU;
    localc.ita = paramc;
    localMessage.obj = localc;
    this.isO.sendMessage(localMessage);
  }
  
  public final View findViewById(int paramInt)
  {
    return this.ipf.findViewById(paramInt);
  }
  
  public final String getString(int paramInt)
  {
    return this.isl.getString(paramInt);
  }
  
  private static final class c
  {
    String aox;
    int errCode;
    e.b isZ;
    com.tencent.mm.plugin.card.d.c ita;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */