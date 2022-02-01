package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e
  implements g.a, n, MMActivity.a
{
  private final String TAG;
  boolean dtm;
  private View iCR;
  View.OnClickListener jtG;
  ListView mListView;
  public int oCR;
  String oCS;
  String oCT;
  public ArrayList<String> oCU;
  public ArrayList<String> oCV;
  HashMap<Integer, String> oFA;
  HashMap<String, String> oFB;
  ArrayList<String> oFC;
  d oFD;
  a oFE;
  private ap oFF;
  com.tencent.mm.sdk.b.c oFG;
  com.tencent.mm.plugin.card.ui.a.g oFc;
  i oFd;
  boolean oFe;
  i oFf;
  i oFg;
  com.tencent.mm.plugin.card.widget.g oFh;
  LinearLayout oFi;
  com.tencent.mm.plugin.card.ui.view.g oFj;
  m oFk;
  i oFl;
  i oFm;
  i oFn;
  i oFo;
  i oFp;
  i oFq;
  i oFr;
  i oFs;
  com.tencent.mm.plugin.card.ui.view.d oFt;
  i oFu;
  j oFv;
  boolean oFw;
  com.tencent.mm.plugin.card.b.f oFx;
  public String oFy;
  public String oFz;
  com.tencent.mm.plugin.card.base.b owK;
  MMActivity owO;
  List<com.tencent.mm.plugin.card.model.b> owP;
  ArrayList<tl> owR;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.oFe = false;
    this.oFw = true;
    this.owP = new ArrayList();
    this.oFy = "";
    this.oFz = "";
    this.oCR = 0;
    this.oCS = "";
    this.oCT = "";
    this.oCU = new ArrayList();
    this.oCV = new ArrayList();
    this.oFA = new HashMap();
    this.oFB = new HashMap();
    this.oFC = new ArrayList();
    this.dtm = false;
    this.oFF = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.c)))
        {
          paramAnonymousMessage = (e.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.oFQ == e.b.oFO)
          {
            if (e.this.oFj != null)
            {
              com.tencent.mm.plugin.card.d.d.a(e.this.owO, paramAnonymousMessage.errMsg, false);
              e.this.oFj.bYu();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.oFQ == e.b.oFM)
          {
            if (e.this.oFj != null)
            {
              e.this.oFj.d(com.tencent.mm.plugin.card.d.c.oPt);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.this.oFj != null) {
            e.this.oFj.d(paramAnonymousMessage.oFR);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(113265);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getId() == 2131297719) || (paramAnonymousView.getId() == 2131297710)) {
          if (e.this.owK.bTs()) {
            if (e.this.oFD != null) {
              e.this.oFD.bWh();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113265);
          return;
          if ((e.this.owK.bTt()) && (e.this.oFD != null))
          {
            e.this.oFD.bWf();
            continue;
            if ((paramAnonymousView.getId() == 2131300306) || (paramAnonymousView.getId() == 2131296317))
            {
              com.tencent.mm.plugin.card.d.b.ac(e.this.owO, e.this.oFE.oEM);
            }
            else if ((paramAnonymousView.getId() == 2131298400) || (paramAnonymousView.getId() == 2131298384))
            {
              if (paramAnonymousView.getId() == 2131298400)
              {
                e.this.oFw = false;
                label229:
                if ((e.this.oFj instanceof q))
                {
                  localObject = ((q)e.this.oFj).e(com.tencent.mm.plugin.card.d.c.oPv);
                  e.this.oFv.oJz = ((String)localObject);
                }
                localObject = e.this.oFv;
                bool = e.this.oFw;
                ((j)localObject).bXd();
                ((j)localObject).oFw = bool;
                if ((((j)localObject).jtC == null) || (((j)localObject).jtC.isShowing())) {
                  continue;
                }
                ((j)localObject).jtC.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).jtC.setFocusable(true);
                ((j)localObject).jtC.setTouchable(true);
                ((j)localObject).jtC.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).jtC.setOutsideTouchable(true);
                if (!((j)localObject).oFw) {
                  break label776;
                }
                ((j)localObject).oJv.setOnClickListener(((j)localObject).jtG);
                paramAnonymousView = ((j)localObject).oJr;
                if (((j)localObject).oCe == null) {
                  break label688;
                }
                ((j)localObject).oJr = com.tencent.mm.plugin.card.d.l.S(((j)localObject).oCe);
                label429:
                ((j)localObject).oJv.setImageBitmap(((j)localObject).oJr);
                ((j)localObject).oJy.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).jtE.setVisibility(8);
                ((j)localObject).oJu.setVisibility(0);
                paramAnonymousView = ((j)localObject).owK.bTO().code;
                if ((((j)localObject).owK.bTN().FSd != null) && (((j)localObject).owK.bTN().FSd.Gdy)) {
                  break label730;
                }
                if (bt.isNullOrNil(((j)localObject).owK.bTO().FPC)) {
                  break label697;
                }
                paramAnonymousView = ((j)localObject).owK.bTO().FPC;
                label558:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label750;
                }
                ((j)localObject).oJw.setText(com.tencent.mm.plugin.card.d.n.Zo(paramAnonymousView));
                if (!((j)localObject).owK.bTC()) {
                  break label737;
                }
                ((j)localObject).oJw.setVisibility(0);
                label608:
                if (bt.isNullOrNil(((j)localObject).owK.bTN().iTH)) {
                  break label763;
                }
                ((j)localObject).oJx.setText(((j)localObject).owK.bTN().iTH);
                ((j)localObject).oJx.setVisibility(0);
              }
              for (;;)
              {
                ((j)localObject).jtC.update();
                break;
                if (paramAnonymousView.getId() != 2131298384) {
                  break label229;
                }
                e.this.oFw = true;
                break label229;
                label688:
                ((j)localObject).oJr = null;
                break label429;
                label697:
                if (!((j)localObject).owK.bTH()) {
                  break label558;
                }
                if (!bt.isNullOrNil(((j)localObject).oJz))
                {
                  paramAnonymousView = ((j)localObject).oJz;
                  break label558;
                }
                label730:
                paramAnonymousView = "";
                break label558;
                label737:
                ((j)localObject).oJw.setVisibility(8);
                break label608;
                label750:
                ((j)localObject).oJw.setVisibility(8);
                break label608;
                label763:
                ((j)localObject).oJx.setVisibility(8);
              }
              label776:
              ((j)localObject).jtD.setOnClickListener(((j)localObject).jtG);
              ((j)localObject).jtD.setImageBitmap(((j)localObject).jtB);
              paramAnonymousView = ((j)localObject).owK.bTO().code;
              if ((((j)localObject).owK.bTN().FSd == null) || (!((j)localObject).owK.bTN().FSd.Gdy)) {
                if (!bt.isNullOrNil(((j)localObject).owK.bTO().FPC))
                {
                  paramAnonymousView = ((j)localObject).owK.bTO().FPC;
                  label884:
                  if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                    break label1058;
                  }
                  ((j)localObject).oJs.setText(com.tencent.mm.plugin.card.d.n.Zo(paramAnonymousView));
                  if (!((j)localObject).owK.bTC()) {
                    break label1045;
                  }
                  ((j)localObject).oJs.setVisibility(0);
                  label934:
                  if (TextUtils.isEmpty(((j)localObject).owK.bTN().iTH)) {
                    break label1071;
                  }
                  ((j)localObject).oJt.setText(((j)localObject).owK.bTN().iTH);
                  ((j)localObject).oJt.setVisibility(0);
                }
              }
              for (;;)
              {
                ((j)localObject).jtE.setVisibility(0);
                ((j)localObject).oJu.setVisibility(8);
                break;
                if (!((j)localObject).owK.bTH()) {
                  break label884;
                }
                if (!bt.isNullOrNil(((j)localObject).oJz))
                {
                  paramAnonymousView = ((j)localObject).oJz;
                  break label884;
                }
                paramAnonymousView = "";
                break label884;
                label1045:
                ((j)localObject).oJs.setVisibility(8);
                break label934;
                label1058:
                ((j)localObject).oJs.setVisibility(8);
                break label934;
                label1071:
                ((j)localObject).oJt.setVisibility(8);
              }
            }
            else
            {
              int j;
              String str1;
              int k;
              String str2;
              int i;
              if ((paramAnonymousView.getId() == 2131297769) || (paramAnonymousView.getId() == 2131297762) || (paramAnonymousView.getId() == 2131297761) || (paramAnonymousView.getId() == 2131298408) || (paramAnonymousView.getId() == 2131297760))
              {
                if (paramAnonymousView.getId() == 2131297769)
                {
                  if (e.this.owK.bTt())
                  {
                    paramAnonymousView = com.tencent.mm.plugin.report.service.g.yhR;
                    j = e.this.owK.bTN().mrl;
                    localObject = e.this.owK.bTS();
                    str1 = e.this.owK.bTR();
                    k = e.this.oFE.oCq;
                    str2 = e.this.oFE.oEM;
                    if (e.this.owK.bTL()) {}
                    for (i = 1;; i = 0)
                    {
                      paramAnonymousView.f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                      if (e.this.oFD == null) {
                        break;
                      }
                      e.this.oFD.jw(true);
                      break;
                    }
                  }
                  paramAnonymousView = new j.b();
                  e.this.a(true, paramAnonymousView, false);
                }
                else
                {
                  if ((paramAnonymousView.getId() == 2131298408) && (e.this.owK.bTN().FSg))
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (e.this.owK.bTt())
                  {
                    if (e.this.oFD != null) {
                      e.this.oFD.jw(false);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new j.b();
                    e.this.a(false, paramAnonymousView, false);
                  }
                }
              }
              else if (paramAnonymousView.getId() == 2131296510)
              {
                if (!TextUtils.isEmpty(e.this.owK.bTN().FRK))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.owO, e.this.owK.bTN().FRK, 3);
                  com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(13), e.this.owK.bTR(), e.this.owK.bTS(), "", e.this.owK.bTN().FRJ });
                }
              }
              else if (paramAnonymousView.getId() == 2131297878)
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.owK.bTN().mrl), e.this.owK.bTS(), e.this.owK.bTR(), e.this.oFE.oEM });
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KLabel_range_index", e.this.oCR);
                paramAnonymousView.putExtra("Klabel_name_list", e.this.oCS);
                paramAnonymousView.putExtra("Kother_user_name_list", e.this.oCT);
                paramAnonymousView.putExtra("k_sns_label_ui_title", e.this.owO.getString(2131756983));
                paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
                paramAnonymousView.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.bs.d.b(e.this.owO, "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
                e.this.owO.mmSetOnActivityResultCallback(e.this);
              }
              else if (paramAnonymousView.getId() == 2131297891)
              {
                if (e.this.owK.bTO().FPq != null)
                {
                  localObject = e.this.owK.bTO().FPq;
                  i = ((Integer)paramAnonymousView.getTag()).intValue();
                  paramAnonymousView = (aaf)((LinkedList)localObject).get(i);
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.owK.bTR(), paramAnonymousView, e.this.oFE.oCq, e.this.oFE.oFK))
                  {
                    com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(19), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, paramAnonymousView.url, 1);
                    localObject = com.tencent.mm.plugin.report.service.g.yhR;
                    switch (i)
                    {
                    default: 
                      i = 10;
                    }
                    for (;;)
                    {
                      ((com.tencent.mm.plugin.report.service.g)localObject).f(11941, new Object[] { Integer.valueOf(i), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.title });
                      if (!com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.owK.bTR())) {
                        break;
                      }
                      com.tencent.mm.plugin.card.d.l.Zm(e.this.owK.bTR());
                      com.tencent.mm.plugin.card.d.b.b(e.this.owO, e.this.owK.bTN().oze);
                      break;
                      i = 10;
                      continue;
                      i = 11;
                      continue;
                      i = 12;
                      continue;
                      i = 16;
                    }
                  }
                }
              }
              else if (paramAnonymousView.getId() == 2131297892)
              {
                if (e.this.owK.bTO().FPq != null)
                {
                  paramAnonymousView = (aaf)e.this.owK.bTO().FPq.get(0);
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.owK.bTR(), paramAnonymousView, e.this.oFE.oCq, e.this.oFE.oFK))
                  {
                    com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(19), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(10), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.owK.bTR()))
                    {
                      com.tencent.mm.plugin.card.d.l.Zm(e.this.owK.bTR());
                      com.tencent.mm.plugin.card.d.b.b(e.this.owO, e.this.owK.bTN().oze);
                    }
                  }
                }
              }
              else if ((paramAnonymousView.getId() == 2131297922) || (paramAnonymousView.getId() == 2131297869))
              {
                if (e.this.owK.bTO().FPx != null) {
                  if (e.this.owK.bTF())
                  {
                    if (e.this.owK.bTt())
                    {
                      if (e.this.oFD != null) {
                        e.this.oFD.jw(false);
                      }
                    }
                    else
                    {
                      paramAnonymousView = new j.b();
                      e.this.a(false, paramAnonymousView, false);
                    }
                  }
                  else if (e.this.owK.bTG())
                  {
                    paramAnonymousView = new j.b();
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, paramAnonymousView.oxC, paramAnonymousView.oxD, false, e.this.owK);
                  }
                  else
                  {
                    paramAnonymousView = e.this.owK.bTO().FPx;
                    if (com.tencent.mm.plugin.card.d.b.a(e.this.owK.bTR(), paramAnonymousView, e.this.oFE.oCq, e.this.oFE.oFK))
                    {
                      com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(20), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.title });
                    }
                    else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                    {
                      localObject = com.tencent.mm.plugin.card.d.l.Z(paramAnonymousView.url, paramAnonymousView.FSA);
                      com.tencent.mm.plugin.card.d.b.a(e.this.owO, (String)localObject, 1);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(9), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.title });
                      if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.owK.bTR()))
                      {
                        com.tencent.mm.plugin.card.d.l.Zm(e.this.owK.bTR());
                        com.tencent.mm.plugin.card.d.b.b(e.this.owO, e.this.owK.bTN().oze);
                      }
                    }
                  }
                }
              }
              else
              {
                String str3;
                if ((paramAnonymousView.getId() == 2131297784) || (paramAnonymousView.getId() == 2131297727))
                {
                  paramAnonymousView = e.this.owK.bTN().FRQ;
                  localObject = com.tencent.mm.plugin.report.service.g.yhR;
                  j = e.this.owK.bTN().mrl;
                  str1 = e.this.owK.bTS();
                  str2 = e.this.owK.bTR();
                  k = e.this.oFE.oCq;
                  str3 = e.this.oFE.oEM;
                  if (e.this.owK.bTL()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.g)localObject).f(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                      break label3233;
                    }
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, paramAnonymousView.url, 1);
                    break;
                  }
                  label3233:
                  localObject = new Intent();
                  if ((e.this.owK instanceof CardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.this.owK);
                  }
                  for (;;)
                  {
                    ((Intent)localObject).setClass(e.this.owO, CardDetailPreference.class);
                    paramAnonymousView = e.this.owO;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                    if ((e.this.owK instanceof ShareCardInfo)) {
                      ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.this.owK);
                    }
                  }
                }
                if (paramAnonymousView.getId() == 2131304762)
                {
                  if (com.tencent.mm.plugin.card.sharecard.a.b.Yw(e.this.owK.bTS()) <= 1)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = e.this;
                  if (!e.this.oFe) {}
                  for (;;)
                  {
                    paramAnonymousView.oFe = bool;
                    e.this.bVy();
                    break;
                    bool = false;
                  }
                }
                if (paramAnonymousView.getId() == 2131297731)
                {
                  if ((e.this.owK.bTN().FRM != null) && (!TextUtils.isEmpty(e.this.owK.bTN().FRM.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, e.this.owK.bTN().FRM.url, 3);
                    com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(3), e.this.owK.bTR(), e.this.owK.bTS(), "", e.this.owK.bTN().FRM.text });
                  }
                }
                else if (paramAnonymousView.getId() == 2131297717)
                {
                  if ((e.this.owK.bTN().FRT != null) && (!bt.isNullOrNil(e.this.owK.bTN().FRT.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, e.this.owK.bTN().FRT.url, 1);
                    com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(14), e.this.owK.bTR(), e.this.owK.bTS(), "", e.this.owK.bTN().FRT.text });
                  }
                }
                else if ((paramAnonymousView.getId() == 2131304769) || (paramAnonymousView.getId() == 2131304770))
                {
                  if (e.this.owK.bTN().FRD > 0)
                  {
                    if ((e.this.owR == null) || (e.this.owR.size() == 0))
                    {
                      ad.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(113265);
                      return;
                    }
                    paramAnonymousView = (tl)e.this.owR.get(0);
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, paramAnonymousView.dyz, paramAnonymousView.dAp, paramAnonymousView.hWY);
                    localObject = com.tencent.mm.plugin.report.service.g.yhR;
                    j = e.this.owK.bTN().mrl;
                    str1 = e.this.owK.bTS();
                    str2 = e.this.owK.bTR();
                    k = e.this.oFE.oCq;
                    str3 = e.this.oFE.oEM;
                    if (e.this.owK.bTL()) {}
                    for (i = 1;; i = 0)
                    {
                      ((com.tencent.mm.plugin.report.service.g)localObject).f(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                      com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(5), e.this.owK.bTR(), e.this.owK.bTS(), "", paramAnonymousView.name });
                      break;
                    }
                  }
                }
                else if (paramAnonymousView.getId() == 2131305807)
                {
                  if ((e.this.owR == null) || (e.this.owR.size() == 0))
                  {
                    ad.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  localObject = (tl)e.this.owR.get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.this.owO.getString(2131756806))))
                  {
                    e.a(e.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (!TextUtils.isEmpty(((tl)localObject).ozD))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.owO, ((tl)localObject).ozD, 1);
                    com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(4), e.this.owK.bTR(), e.this.owK.bTS(), "", ((tl)localObject).name });
                  }
                }
                else if (paramAnonymousView.getId() == 2131305802)
                {
                  e.a(e.this);
                }
              }
            }
          }
        }
      }
    };
    this.oFG = new e.7(this);
    this.owO = paramMMActivity;
    this.iCR = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void AB(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.owK.bTO().FPv;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.oFB.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      bc localbc = (bc)localLinkedList.get(paramInt);
      j = i;
      if (!bt.isNullOrNil(localbc.text))
      {
        j = i;
        if (!bt.isNullOrNil(localbc.url))
        {
          this.oFC.add(localbc.text);
          this.oFA.put(Integer.valueOf(i), localbc.text);
          this.oFB.put(localbc.text, localbc.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(113300);
  }
  
  private void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.oFh != null) {
      this.oFh.I(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void YK(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.owK instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.owK);
    }
    for (;;)
    {
      localIntent.setClass(this.owO, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.oFE.fPp);
      localIntent.putExtra("key_previous_scene", this.oFE.oCq);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.oFE.oFK);
      this.owO.startActivityForResult(localIntent, 3);
      this.owO.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.owK instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.owK);
      }
    }
  }
  
  private String bVA()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.oCS)) && (!TextUtils.isEmpty(this.oCT)))
    {
      str = this.oCS + "," + com.tencent.mm.plugin.card.d.l.Zk(this.oCT);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.oCS))
    {
      str = this.oCS;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.oCT))
    {
      str = com.tencent.mm.plugin.card.d.l.Zk(this.oCT);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private boolean bWA()
  {
    AppMethodBeat.i(113292);
    if (this.oFh == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.owK.bTu())
    {
      if ((this.oFh instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.owK.bTx())
    {
      if ((this.oFh instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.owK.bTv())
    {
      if ((this.oFh instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.owK.bTw())
    {
      if ((this.oFh instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.owK.bTy())
    {
      if ((this.oFh instanceof com.tencent.mm.plugin.card.widget.d))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    AppMethodBeat.o(113292);
    return false;
  }
  
  private void bWB()
  {
    AppMethodBeat.i(113293);
    if (this.owK.bTu()) {
      this.oFh = new com.tencent.mm.plugin.card.widget.e(this.owO);
    }
    for (;;)
    {
      this.oFh.i(this.owK);
      View localView = this.oFh.jq();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.n.a(localView, this.oFi);
      }
      this.oFi.invalidate();
      this.oFh.setOnClickListener(this.jtG);
      I(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.owK.bTx()) {
        this.oFh = new com.tencent.mm.plugin.card.widget.c(this.owO);
      } else if (this.owK.bTv()) {
        this.oFh = new com.tencent.mm.plugin.card.widget.b(this.owO);
      } else if (this.owK.bTw()) {
        this.oFh = new com.tencent.mm.plugin.card.widget.f(this.owO);
      } else if (this.owK.bTy()) {
        this.oFh = new com.tencent.mm.plugin.card.widget.d(this.owO);
      } else {
        this.oFh = new com.tencent.mm.plugin.card.widget.b(this.owO);
      }
    }
  }
  
  private void bWC()
  {
    AppMethodBeat.i(113294);
    View localView = this.oFh.jq();
    if (localView != null) {
      this.oFi.removeView(localView);
    }
    this.oFi.removeAllViews();
    this.oFi.invalidate();
    this.oFh.release();
    this.oFh = null;
    AppMethodBeat.o(113294);
  }
  
  private void bWD()
  {
    AppMethodBeat.i(113295);
    if ((this.oFh != null) && ((this.oFh instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.oFh).bWD();
    }
    AppMethodBeat.o(113295);
  }
  
  private void bWE()
  {
    AppMethodBeat.i(113296);
    sr localsr = this.owK.bTO();
    this.owK.a(localsr);
    com.tencent.mm.plugin.card.d.l.h(this.owK);
    AppMethodBeat.o(113296);
  }
  
  private void bWF()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.oFA.clear();
    this.oFC.clear();
    if (this.owK.bTB())
    {
      this.oFC.add(getString(2131757029));
      this.oFA.put(Integer.valueOf(0), "menu_func_share_friend");
      this.oFC.add(getString(2131757028));
      this.oFA.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.owK.bTO().FPt))
    {
      this.oFC.add(getString(2131756938));
      this.oFA.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    AB(j);
    if (this.oFC.size() > 0) {
      this.owO.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void bWG()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.oFA.clear();
    this.oFC.clear();
    int i = j;
    if (this.owK.bTs())
    {
      i = j;
      if (this.owK.bTA())
      {
        if (bt.isNullOrNil(this.owK.bTN().FSk)) {
          break label235;
        }
        this.oFC.add(this.owK.bTN().FSk);
        this.oFA.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.owK.bTO().FPt))
    {
      this.oFC.add(getString(2131756938));
      this.oFA.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.owK.bTs())
    {
      this.oFC.add(getString(2131755707));
      this.oFA.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      AB(i);
      if (this.oFC.size() > 0) {
        this.owO.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.owK.bTy())
      {
        this.oFC.add(getString(2131756937));
        break;
      }
      this.oFC.add(getString(2131756936));
      break;
      i = j;
      if (this.owK.bTt())
      {
        String str1 = com.tencent.mm.model.u.aAm();
        String str2 = this.owK.bTT();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.oFC.add(getString(2131755707));
          this.oFA.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          ad.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void bWH()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.oFA.clear();
    this.oFC.clear();
    if (!TextUtils.isEmpty(this.owK.bTO().FPt))
    {
      this.oFC.add(getString(2131756938));
      this.oFA.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    AB(i);
    if (this.oFC.size() > 0) {
      this.owO.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void bWv()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.oFc == null)
    {
      i = 0;
      if (i != 0)
      {
        this.oFc.release();
        this.oFc = null;
        ad.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.owK.bTN().mrl) });
      }
      if (this.oFc == null)
      {
        ad.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.owK.bTN().mrl) });
        ad.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.owK.bTN().mrl) });
        if (!this.owK.bTt()) {
          break label423;
        }
        this.oFc = new com.tencent.mm.plugin.card.ui.a.h(this.owO);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.owK.bTN().mrl) });
      this.oFc.a(this.owK, this.oFE);
      AppMethodBeat.o(113279);
      return;
      if (this.owK.bTt())
      {
        if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.owK.bTu())
      {
        if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.owK.bTx())
      {
        if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.owK.bTv())
      {
        if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.owK.bTw())
      {
        if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.owK.bTy())
      {
        if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.oFc instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.owK.bTN().mrl)
      {
      default: 
        this.oFc = new com.tencent.mm.plugin.card.ui.a.a(this.owO);
        break;
      case 0: 
        this.oFc = new com.tencent.mm.plugin.card.ui.a.c(this.owO);
        break;
      case 10: 
        this.oFc = new com.tencent.mm.plugin.card.ui.a.e(this.owO);
        break;
      case 11: 
        this.oFc = new com.tencent.mm.plugin.card.ui.a.b(this.owO);
        break;
      case 20: 
        this.oFc = new com.tencent.mm.plugin.card.ui.a.f(this.owO);
        break;
      case 30: 
        this.oFc = new com.tencent.mm.plugin.card.ui.a.d(this.owO);
      }
    }
  }
  
  private void bWw()
  {
    AppMethodBeat.i(113285);
    if ((this.owK.bTN().FSd != null) && (this.owK.bTN().FSd.Gdy))
    {
      this.oFj = new com.tencent.mm.plugin.card.ui.view.m();
      am.bVd().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.owK.bTN().mrl == 10)
    {
      this.oFj = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.oFj = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void bWx()
  {
    AppMethodBeat.i(113286);
    if (this.dtm)
    {
      ad.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label197:
    Object localObject3;
    int i;
    if ((this.owK.bTs()) && (this.owK.bTu()))
    {
      this.iCR.findViewById(2131297787).setBackgroundColor(this.owO.getResources().getColor(2131101179));
      this.owO.setActionbarColor(this.owO.getResources().getColor(2131101179));
      localObject2 = this.iCR.findViewById(2131299042);
      localObject1 = this.iCR.findViewById(2131300735);
      localView = this.iCR.findViewById(2131299039);
      if ((!this.owK.bTs()) || (!this.oFc.bXC())) {
        break label1267;
      }
      if (!this.owK.bTv()) {
        break label1133;
      }
      ((View)localObject2).setBackgroundResource(2131231515);
      this.iCR.findViewById(2131300307).setBackgroundResource(2131231456);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.owK.bTy())
      {
        localObject3 = (TextView)this.iCR.findViewById(2131297477);
        localObject4 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.aat(2131231510));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.owK.bTt()) && (this.oFc.bXA()) && (this.oFe))
      {
        localObject4 = this.iCR.findViewById(2131304758);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.owK.bTs()) && (this.oFc.bXC()))
      {
        localObject4 = this.iCR.findViewById(2131300307);
        ((Rect)localObject3).left = this.owO.getResources().getDimensionPixelOffset(2131165480);
        ((Rect)localObject3).right = this.owO.getResources().getDimensionPixelOffset(2131165480);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.owK.bTw())
        {
          localObject3 = this.iCR.findViewById(2131300308);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.owO.getResources().getDimensionPixelSize(2131165568);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.oFc.bXC()) && (!this.oFc.bXA())) {
        break label1491;
      }
      if ((this.oFh != null) && (((this.owK.bTs()) && (this.owK.bTv())) || (this.owK.bTt()))) {
        this.oFh.AQ(0);
      }
      label650:
      if ((this.oFh != null) && (this.owK.bTs()) && (this.owK.bTu()))
      {
        i = this.owO.getResources().getDimensionPixelOffset(2131165983);
        localObject3 = com.tencent.mm.plugin.card.d.l.eU(com.tencent.mm.plugin.card.d.l.Zh(this.owK.bTN().hAD), i);
        this.oFh.a((ShapeDrawable)localObject3);
      }
      if ((this.owK.bTs()) && (this.owK.bTu()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.owK.bTN().FRJ)) {
          break label1576;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label816:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.owO.getResources().getDimensionPixelSize(2131165500);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.owK.bTu()) {
          break label1591;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.owO.getResources().getDimensionPixelSize(2131165489);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.owO.getResources().getDimensionPixelSize(2131165490);
        i = this.owO.getResources().getDimensionPixelSize(2131165483);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label932:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.owK.bTu()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.owO.getResources().getDimensionPixelSize(2131165483);
        }
        if (TextUtils.isEmpty(this.owK.bTN().FRJ)) {
          break label1620;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.owK.bTN().FRJ))
      {
        localView = findViewById(2131296509);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.iCR.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.d.l.Zh(this.owK.bTN().hAD);
      this.iCR.findViewById(2131297787).setBackgroundColor(i);
      this.owO.setActionbarColor(i);
      break;
      label1133:
      if (this.owK.bTu())
      {
        this.iCR.findViewById(2131300307).setBackgroundResource(0);
        localView.setBackgroundColor(this.owO.getResources().getColor(2131101179));
        break label197;
      }
      if (this.owK.bTw())
      {
        ((View)localObject2).setBackgroundResource(2131231515);
        this.iCR.findViewById(2131300307).setBackgroundResource(2131231456);
        localView.setBackgroundResource(0);
        break label197;
      }
      if ((this.owK.bTx()) || (!this.owK.bTy())) {
        break label197;
      }
      localView.setBackgroundColor(this.owO.getResources().getColor(2131101179));
      break label197;
      label1267:
      if (this.owK.bTt())
      {
        if ((this.oFc.bXA()) && (this.oFe))
        {
          ((View)localObject2).setBackgroundResource(2131231515);
          localView.setBackgroundResource(0);
          break label197;
        }
        if ((this.oFc.bXA()) && (!this.oFe))
        {
          ((View)localObject2).setBackgroundResource(2131231511);
          localView.setBackgroundResource(0);
          break label197;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.oFc.bWJ())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.owK.bTv())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.oFc.bWJ())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.owK.bTw())
      {
        ((View)localObject2).setBackgroundResource(2131231519);
        localView.setBackgroundResource(0);
        break label197;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.owO.getResources().getColor(2131101179));
      break label197;
      label1491:
      if ((this.oFh == null) || (((!this.owK.bTs()) || (!this.owK.bTv())) && (!this.owK.bTt()))) {
        break label650;
      }
      if (this.oFc.bWJ())
      {
        this.oFh.AQ(2131231516);
        break label650;
      }
      this.oFh.AQ(2131231514);
      break label650;
      label1576:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label816;
      label1591:
      i = this.owO.getResources().getDimensionPixelSize(2131165198);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label932;
      label1620:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void bWy()
  {
    AppMethodBeat.i(113290);
    if (!this.oFc.bXE())
    {
      ad.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.owP.clear();
    this.owP.addAll(this.oFx.bUo());
    this.oFk.setData(this.owP);
    this.oFk.oKe = this.owK.bTy();
    this.oFk.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void bWz()
  {
    AppMethodBeat.i(113291);
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (bWA()) {
      bWC();
    }
    if (this.oFh == null) {
      bWB();
    }
    if (this.oFh != null)
    {
      if (this.owK.bTw()) {
        ((com.tencent.mm.plugin.card.widget.f)this.oFh).owR = this.owR;
      }
      this.oFh.d(this.owK);
    }
    AppMethodBeat.o(113291);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(113289);
    if (!this.oFc.bXz())
    {
      this.owO.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.owO.setMMTitle(this.oFx.getTitle());
    AppMethodBeat.o(113289);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, a parama, ArrayList<tl> paramArrayList)
  {
    this.owK = paramb;
    this.oFE = parama;
    this.owR = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.owK.bTO().FPx;
      if (this.owK.bTG())
      {
        com.tencent.mm.plugin.card.d.b.a(this.owO, paramb.oxC, paramb.oxD, paramBoolean2, this.owK);
        com.tencent.mm.plugin.report.service.g.yhR.f(11941, new Object[] { Integer.valueOf(17), this.owK.bTR(), this.owK.bTS(), "", this.owK.bTO().FPx.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((aaf)localObject1).FRk)) && (!TextUtils.isEmpty(((aaf)localObject1).FRl)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.owK.bTR(), (aaf)localObject1, this.oFE.oCq, this.oFE.oFK);
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
        str1 = this.owK.bTR();
        str2 = this.owK.bTS();
        if (((aaf)localObject1).title != null) {}
        for (paramb = ((aaf)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((aaf)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.Z(((aaf)localObject1).url, ((aaf)localObject1).FSA);
        com.tencent.mm.plugin.card.d.b.a(this.owO, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
        str1 = this.owK.bTR();
        str2 = this.owK.bTS();
        if (((aaf)localObject1).title != null) {}
        for (paramb = ((aaf)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
      j = this.owK.bTN().mrl;
      localObject2 = this.owK.bTS();
      str1 = this.owK.bTR();
      k = this.oFE.oCq;
      str2 = this.oFE.oEM;
      if (this.owK.bTL()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        YK(paramb.oxz);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
    int k = this.owK.bTN().mrl;
    Object localObject2 = this.owK.bTS();
    String str1 = this.owK.bTR();
    int m = this.oFE.oCq;
    String str2 = this.oFE.oEM;
    if (this.owK.bTL()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      YK(paramb.oxz);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    ad.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oFQ = e.b.oFO;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(2131756842);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.oFF.sendMessage(localMessage);
      AppMethodBeat.o(113282);
      return;
      if (paramInt == 2) {
        paramString = getString(2131756811);
      } else {
        paramString = getString(2131756841);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113277);
    if (paramb != null)
    {
      this.owK = paramb;
      if (this.oFD != null) {
        this.oFD.b(paramb);
      }
      bVy();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113284);
    ad.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oFQ = e.b.oFN;
    localc.oFR = paramc;
    localMessage.obj = localc;
    this.oFF.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void bUs()
  {
    AppMethodBeat.i(113283);
    ad.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oFQ = e.b.oFM;
    localMessage.obj = localc;
    this.oFF.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final void bVy()
  {
    AppMethodBeat.i(113280);
    if (this.owK == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.oFD != null) {
        this.oFD.bWi();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.owK.bTN() == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.oFD != null) {
        this.oFD.bWi();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.owK.bTO() == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.oFD != null) {
        this.oFD.bWi();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.owK.bTz())
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.owK.bTN().mrl) });
      if (!TextUtils.isEmpty(this.owK.bTN().FRE))
      {
        com.tencent.mm.plugin.card.d.b.a(this.owO, this.owK.bTN().FRE, 0);
        if (this.oFD != null)
        {
          this.oFD.bWi();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.owO, getString(2131756947), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.this.oFD != null) {
              e.this.oFD.bWi();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    ad.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    ad.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.owK.bTN().FRZ);
    this.oFx.a(this.owK, this.owR, this.oFE.fPp);
    bWv();
    this.oFc.bXR();
    ad.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    bWz();
    if (this.oFc.bXA())
    {
      ad.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.oFd.update();
      if (!this.oFc.bXr()) {
        break label1156;
      }
      if (this.oFu == null)
      {
        this.oFu = new com.tencent.mm.plugin.card.ui.view.b();
        this.oFu.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.oFu.update();
      label436:
      this.owO.showOptionMenu(this.oFc.bXv());
      if (this.oFc.bXw()) {
        bWF();
      }
      if (this.oFc.bXx()) {
        bWG();
      }
      if (this.oFc.bXy()) {
        bWH();
      }
      bWD();
      I(this.oFc.bXt(), this.oFc.bXu());
      if ((this.owK.bTu()) || (!this.oFc.bXC())) {
        break label1181;
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.oFf.update();
      label565:
      if (this.oFh != null) {
        this.oFh.jC(this.oFc.bWJ());
      }
      bWx();
      if (!this.oFc.bXH()) {
        break label1278;
      }
      if (this.oFm == null)
      {
        this.oFm = new com.tencent.mm.plugin.card.ui.view.y();
        this.oFm.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.oFm.update();
      label647:
      if (!this.oFc.bXQ()) {
        break label1303;
      }
      if (this.oFl == null)
      {
        this.oFl = new com.tencent.mm.plugin.card.ui.view.c();
        this.oFl.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.oFl.update();
      label700:
      if (!this.oFc.bXI()) {
        break label1328;
      }
      if (this.oFn == null)
      {
        this.oFn = new k();
        this.oFn.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.oFn.update();
      label753:
      if (!this.oFc.bXJ()) {
        break label1353;
      }
      if (this.oFo == null)
      {
        this.oFo = new w();
        this.oFo.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.oFo.update();
      label806:
      if (!this.oFc.bXK()) {
        break label1378;
      }
      if (this.oFp == null)
      {
        this.oFp = new com.tencent.mm.plugin.card.ui.view.l();
        this.oFp.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.oFp.update();
      label859:
      if (!this.oFc.bXL()) {
        break label1403;
      }
      if (this.oFq == null)
      {
        this.oFq = new z();
        this.oFq.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.oFq.update();
      label912:
      if (!this.oFc.bXN()) {
        break label1428;
      }
      if (this.oFr == null)
      {
        this.oFr = new com.tencent.mm.plugin.card.ui.view.e();
        this.oFr.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.oFr.update();
      label965:
      if (!this.oFc.bXM()) {
        break label1453;
      }
      if (this.oFs == null)
      {
        this.oFs = new com.tencent.mm.plugin.card.ui.view.u();
        this.oFs.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.oFs.update();
      label1018:
      bWy();
      if (!this.oFc.bXF()) {
        break label1530;
      }
      bWE();
      if (!this.oFc.bXG()) {
        break label1513;
      }
      if (this.oFj != null) {
        break label1478;
      }
      bWw();
      this.oFj.a(this);
      this.oFj.update();
      label1076:
      if (this.oFh != null) {
        this.oFh.jB(true);
      }
      label1093:
      if (!this.oFc.bXO()) {
        break label1572;
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.oFt.update();
    }
    for (;;)
    {
      this.oFv.owK = this.owK;
      AppMethodBeat.o(113280);
      return;
      ad.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.oFd.bYr();
      break;
      label1156:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.oFu == null) {
        break label436;
      }
      this.oFu.bYr();
      break label436;
      label1181:
      if ((this.owK.bTu()) && (this.oFc.bXC()))
      {
        ad.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.oFg.update();
        break label565;
      }
      if (this.oFc.bXD())
      {
        ad.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.oFg.update();
        break label565;
      }
      ad.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.oFg.bYr();
      this.oFf.bYr();
      break label565;
      label1278:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.oFm == null) {
        break label647;
      }
      this.oFm.bYr();
      break label647;
      label1303:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.oFl == null) {
        break label700;
      }
      this.oFl.bYr();
      break label700;
      label1328:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.oFn == null) {
        break label753;
      }
      this.oFn.bYr();
      break label753;
      label1353:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.oFo == null) {
        break label806;
      }
      this.oFo.bYr();
      break label806;
      label1378:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.oFp == null) {
        break label859;
      }
      this.oFp.bYr();
      break label859;
      label1403:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.oFq == null) {
        break label912;
      }
      this.oFq.bYr();
      break label912;
      label1428:
      ad.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.oFr == null) {
        break label965;
      }
      this.oFr.bYr();
      break label965;
      label1453:
      ad.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.oFs == null) {
        break label1018;
      }
      this.oFs.bYr();
      break label1018;
      label1478:
      if (!this.oFj.f(this.owK)) {
        break label1076;
      }
      this.oFj.b(this.owK);
      this.oFj.update();
      break label1076;
      label1513:
      if (this.oFj == null) {
        break label1076;
      }
      this.oFj.bYw();
      break label1076;
      label1530:
      ad.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.oFj != null) {
        this.oFj.bYw();
      }
      if (this.oFh == null) {
        break label1093;
      }
      this.oFh.jB(false);
      break label1093;
      label1572:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.oFt.bYr();
    }
  }
  
  public final int bWI()
  {
    AppMethodBeat.i(113304);
    if (this.oFx == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.oFx.bUq())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean bWJ()
  {
    AppMethodBeat.i(113305);
    if (this.oFc == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.oFc.bWJ();
    AppMethodBeat.o(113305);
    return bool;
  }
  
  public final com.tencent.mm.plugin.card.base.b bWl()
  {
    return this.owK;
  }
  
  public final boolean bWm()
  {
    return this.oFe;
  }
  
  public final void bWn()
  {
    this.oFe = false;
  }
  
  public final MMActivity bWo()
  {
    return this.owO;
  }
  
  public final View.OnClickListener bWp()
  {
    return this.jtG;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g bWq()
  {
    return this.oFc;
  }
  
  public final d bWr()
  {
    return this.oFD;
  }
  
  public final a bWs()
  {
    return this.oFE;
  }
  
  public final com.tencent.mm.plugin.card.b.f bWt()
  {
    return this.oFx;
  }
  
  public final j bWu()
  {
    return this.oFv;
  }
  
  public final void c(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(113301);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113301);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.oFy = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.oFy;
        if ((this.owK == null) || (this.owK.bTN() == null))
        {
          ad.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.owK.bTP().Hsf)) && (!this.owK.bTy())) {
            localStringBuilder.append(this.owK.bTP().Hsf);
          }
        }
        for (;;)
        {
          String str = this.owK.bTN().title + "\n" + this.owK.bTN().oze;
          ab.a.EXc.a(this.owO.getController(), localStringBuilder.toString(), this.owK.bTN().hzB, str, true, this.owO.getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(113270);
              if (paramAnonymousBoolean)
              {
                e.this.oFz = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.this.oFD != null) {
                    e.this.oFD.YJ(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.owK.bTN().mrl), e.this.owK.bTS(), e.this.owK.bTR(), e.this.oFy });
                  com.tencent.mm.ui.base.h.cl(e.this.owO, e.this.owO.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 1)
                {
                  paramAnonymousString = e.this;
                  paramAnonymousString.owK.bTP().Hsf = (paramAnonymousString.getString(2131756994) + paramAnonymousString.oFx.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.owK, paramAnonymousString.oFy, paramAnonymousString.oFE.oEO, 2);
                  com.tencent.mm.plugin.card.d.l.fg(paramAnonymousString.oFz, paramAnonymousString.oFy);
                  com.tencent.mm.ui.base.h.cl(e.this.owO, e.this.owO.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 4)
                {
                  paramAnonymousString = e.this;
                  if (TextUtils.isEmpty(paramAnonymousString.owK.bTT())) {
                    paramAnonymousString.owK.Yc(com.tencent.mm.model.u.aAm());
                  }
                  paramAnonymousString.owK.bTP().Hsf = (paramAnonymousString.getString(2131756955) + paramAnonymousString.oFx.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.owK, paramAnonymousString.oFy, paramAnonymousString.oFE.oEO, 23);
                  com.tencent.mm.plugin.card.d.l.fg(paramAnonymousString.oFz, paramAnonymousString.oFy);
                  com.tencent.mm.plugin.report.service.g.yhR.f(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.this.oFE.fPp), Integer.valueOf(e.this.owK.bTN().mrl), e.this.owK.bTS(), e.this.owK.bTR(), e.this.oFy });
                  com.tencent.mm.ui.base.h.cl(e.this.owO, e.this.owO.getResources().getString(2131756873));
                }
              }
              AppMethodBeat.o(113270);
            }
          });
          AppMethodBeat.o(113301);
          return;
          localStringBuilder.append(getString(2131763948));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(2131756994) + this.oFx.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(2131756955) + this.oFx.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.oCR = paramIntent.getIntExtra("Ktag_range_index", 0);
        ad.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.oCR) });
        if (this.oCR >= 2)
        {
          this.oCS = paramIntent.getStringExtra("Klabel_name_list");
          this.oCT = paramIntent.getStringExtra("Kother_user_name_list");
          ad.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.oCR), this.oCS });
          if ((TextUtils.isEmpty(this.oCS)) && (TextUtils.isEmpty(this.oCT)))
          {
            ad.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.oCS.split(","));
          this.oCV = com.tencent.mm.plugin.card.d.l.cH(paramIntent);
          this.oCU = com.tencent.mm.plugin.card.d.l.cG(paramIntent);
          if ((this.oCT != null) && (this.oCT.length() > 0))
          {
            paramIntent = Arrays.asList(this.oCT.split(","));
            this.oCU.addAll(paramIntent);
          }
          if (this.oCV != null) {
            ad.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.oCV.size());
          }
          if (this.oCU != null)
          {
            ad.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.oCU.size());
            paramIntent = this.oCU.iterator();
            while (paramIntent.hasNext()) {
              ad.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.oCR == 2)
          {
            this.oFt.YX(this.owO.getString(2131756982, new Object[] { bVA() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.oCR == 3)
          {
            this.oFt.YX(this.owO.getString(2131756981, new Object[] { bVA() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.oFt.YX(this.owO.getString(2131756980));
          AppMethodBeat.o(113301);
          return;
        }
        this.oFt.YX(this.owO.getString(2131756980));
        AppMethodBeat.o(113301);
        return;
        if (this.oFD != null) {
          this.oFD.bWk();
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113281);
    ad.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oFQ = e.b.oFL;
    localc.oFR = paramc;
    localMessage.obj = localc;
    this.oFF.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.iCR.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.owO.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public static final class a
  {
    public int fPp = 3;
    public int oCq = -1;
    public String oEM = "";
    public String oEN = "";
    public String oEO = "";
    public String oEt = "";
    public String oEu = "";
    public int oFK = 0;
    public String oww = "";
    public boolean oxW = false;
  }
  
  static final class c
  {
    int errCode;
    String errMsg;
    e.b oFQ;
    com.tencent.mm.plugin.card.d.c oFR;
  }
  
  public static abstract interface d
  {
    public abstract void YJ(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void bWe();
    
    public abstract void bWf();
    
    public abstract void bWg();
    
    public abstract void bWh();
    
    public abstract void bWi();
    
    public abstract void bWj();
    
    public abstract void bWk();
    
    public abstract void jw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */