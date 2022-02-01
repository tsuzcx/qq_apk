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
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
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
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.bg;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.h.d;
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
  boolean dLD;
  private View jBN;
  View.OnClickListener kuO;
  ListView mListView;
  com.tencent.mm.plugin.card.base.b pQV;
  MMActivity pQZ;
  List<com.tencent.mm.plugin.card.model.b> pRa;
  ArrayList<us> pRc;
  public int pXh;
  String pXi;
  String pXj;
  public ArrayList<String> pXk;
  public ArrayList<String> pXl;
  m pZA;
  i pZB;
  i pZC;
  i pZD;
  i pZE;
  i pZF;
  i pZG;
  i pZH;
  i pZI;
  com.tencent.mm.plugin.card.ui.view.d pZJ;
  i pZK;
  j pZL;
  boolean pZM;
  com.tencent.mm.plugin.card.b.f pZN;
  public String pZO;
  public String pZP;
  HashMap<Integer, String> pZQ;
  HashMap<String, String> pZR;
  ArrayList<String> pZS;
  d pZT;
  a pZU;
  private MMHandler pZV;
  IListener pZW;
  com.tencent.mm.plugin.card.ui.a.g pZs;
  i pZt;
  boolean pZu;
  i pZv;
  i pZw;
  com.tencent.mm.plugin.card.widget.g pZx;
  LinearLayout pZy;
  com.tencent.mm.plugin.card.ui.view.g pZz;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.pZu = false;
    this.pZM = true;
    this.pRa = new ArrayList();
    this.pZO = "";
    this.pZP = "";
    this.pXh = 0;
    this.pXi = "";
    this.pXj = "";
    this.pXk = new ArrayList();
    this.pXl = new ArrayList();
    this.pZQ = new HashMap();
    this.pZR = new HashMap();
    this.pZS = new ArrayList();
    this.dLD = false;
    this.pZV = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.c)))
        {
          paramAnonymousMessage = (e.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.qag == e.b.qae)
          {
            if (e.this.pZz != null)
            {
              com.tencent.mm.plugin.card.d.d.a(e.this.pQZ, paramAnonymousMessage.errMsg, false);
              e.this.pZz.cxz();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.qag == e.b.qac)
          {
            if (e.this.pZz != null)
            {
              e.this.pZz.d(com.tencent.mm.plugin.card.d.c.qkP);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.this.pZz != null) {
            e.this.pZz.d(paramAnonymousMessage.qah);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(113265);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getId() == 2131298023) || (paramAnonymousView.getId() == 2131298014)) {
          if (e.this.pQV.csv()) {
            if (e.this.pZT != null) {
              e.this.pZT.cvm();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113265);
          return;
          if ((e.this.pQV.csw()) && (e.this.pZT != null))
          {
            e.this.pZT.cvk();
            continue;
            if ((paramAnonymousView.getId() == 2131301798) || (paramAnonymousView.getId() == 2131296330))
            {
              com.tencent.mm.plugin.card.d.b.am(e.this.pQZ, e.this.pZU.pZc);
            }
            else if ((paramAnonymousView.getId() == 2131298809) || (paramAnonymousView.getId() == 2131298793))
            {
              if (paramAnonymousView.getId() == 2131298809)
              {
                e.this.pZM = false;
                label229:
                if ((e.this.pZz instanceof q))
                {
                  localObject = ((q)e.this.pZz).e(com.tencent.mm.plugin.card.d.c.qkR);
                  e.this.pZL.qdP = ((String)localObject);
                }
                localObject = e.this.pZL;
                bool = e.this.pZM;
                ((j)localObject).cwi();
                ((j)localObject).pZM = bool;
                if ((((j)localObject).kuK == null) || (((j)localObject).kuK.isShowing())) {
                  continue;
                }
                ((j)localObject).kuK.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).kuK.setFocusable(true);
                ((j)localObject).kuK.setTouchable(true);
                ((j)localObject).kuK.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).kuK.setOutsideTouchable(true);
                if (!((j)localObject).pZM) {
                  break label776;
                }
                ((j)localObject).qdL.setOnClickListener(((j)localObject).kuO);
                paramAnonymousView = ((j)localObject).qdH;
                if (((j)localObject).pWu == null) {
                  break label688;
                }
                ((j)localObject).qdH = com.tencent.mm.plugin.card.d.l.Y(((j)localObject).pWu);
                label429:
                ((j)localObject).qdL.setImageBitmap(((j)localObject).qdH);
                ((j)localObject).qdO.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).kuM.setVisibility(8);
                ((j)localObject).qdK.setVisibility(0);
                paramAnonymousView = ((j)localObject).pQV.csR().code;
                if ((((j)localObject).pQV.csQ().Lff != null) && (((j)localObject).pQV.csQ().Lff.LrL)) {
                  break label730;
                }
                if (Util.isNullOrNil(((j)localObject).pQV.csR().LcE)) {
                  break label697;
                }
                paramAnonymousView = ((j)localObject).pQV.csR().LcE;
                label558:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label750;
                }
                ((j)localObject).qdM.setText(com.tencent.mm.plugin.card.d.n.akl(paramAnonymousView));
                if (!((j)localObject).pQV.csF()) {
                  break label737;
                }
                ((j)localObject).qdM.setVisibility(0);
                label608:
                if (Util.isNullOrNil(((j)localObject).pQV.csQ().jTx)) {
                  break label763;
                }
                ((j)localObject).qdN.setText(((j)localObject).pQV.csQ().jTx);
                ((j)localObject).qdN.setVisibility(0);
              }
              for (;;)
              {
                ((j)localObject).kuK.update();
                break;
                if (paramAnonymousView.getId() != 2131298793) {
                  break label229;
                }
                e.this.pZM = true;
                break label229;
                label688:
                ((j)localObject).qdH = null;
                break label429;
                label697:
                if (!((j)localObject).pQV.csK()) {
                  break label558;
                }
                if (!Util.isNullOrNil(((j)localObject).qdP))
                {
                  paramAnonymousView = ((j)localObject).qdP;
                  break label558;
                }
                label730:
                paramAnonymousView = "";
                break label558;
                label737:
                ((j)localObject).qdM.setVisibility(8);
                break label608;
                label750:
                ((j)localObject).qdM.setVisibility(8);
                break label608;
                label763:
                ((j)localObject).qdN.setVisibility(8);
              }
              label776:
              ((j)localObject).kuL.setOnClickListener(((j)localObject).kuO);
              ((j)localObject).kuL.setImageBitmap(((j)localObject).kuJ);
              paramAnonymousView = ((j)localObject).pQV.csR().code;
              if ((((j)localObject).pQV.csQ().Lff == null) || (!((j)localObject).pQV.csQ().Lff.LrL)) {
                if (!Util.isNullOrNil(((j)localObject).pQV.csR().LcE))
                {
                  paramAnonymousView = ((j)localObject).pQV.csR().LcE;
                  label884:
                  if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                    break label1058;
                  }
                  ((j)localObject).qdI.setText(com.tencent.mm.plugin.card.d.n.akl(paramAnonymousView));
                  if (!((j)localObject).pQV.csF()) {
                    break label1045;
                  }
                  ((j)localObject).qdI.setVisibility(0);
                  label934:
                  if (TextUtils.isEmpty(((j)localObject).pQV.csQ().jTx)) {
                    break label1071;
                  }
                  ((j)localObject).qdJ.setText(((j)localObject).pQV.csQ().jTx);
                  ((j)localObject).qdJ.setVisibility(0);
                }
              }
              for (;;)
              {
                ((j)localObject).kuM.setVisibility(0);
                ((j)localObject).qdK.setVisibility(8);
                break;
                if (!((j)localObject).pQV.csK()) {
                  break label884;
                }
                if (!Util.isNullOrNil(((j)localObject).qdP))
                {
                  paramAnonymousView = ((j)localObject).qdP;
                  break label884;
                }
                paramAnonymousView = "";
                break label884;
                label1045:
                ((j)localObject).qdI.setVisibility(8);
                break label934;
                label1058:
                ((j)localObject).qdI.setVisibility(8);
                break label934;
                label1071:
                ((j)localObject).qdJ.setVisibility(8);
              }
            }
            else
            {
              int j;
              String str1;
              int k;
              String str2;
              int i;
              if ((paramAnonymousView.getId() == 2131298083) || (paramAnonymousView.getId() == 2131298076) || (paramAnonymousView.getId() == 2131298075) || (paramAnonymousView.getId() == 2131298817) || (paramAnonymousView.getId() == 2131298074))
              {
                if (paramAnonymousView.getId() == 2131298083)
                {
                  if (e.this.pQV.csw())
                  {
                    paramAnonymousView = com.tencent.mm.plugin.report.service.h.CyF;
                    j = e.this.pQV.csQ().nHh;
                    localObject = e.this.pQV.csV();
                    str1 = e.this.pQV.csU();
                    k = e.this.pZU.pWG;
                    str2 = e.this.pZU.pZc;
                    if (e.this.pQV.csO()) {}
                    for (i = 1;; i = 0)
                    {
                      paramAnonymousView.a(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                      if (e.this.pZT == null) {
                        break;
                      }
                      e.this.pZT.kx(true);
                      break;
                    }
                  }
                  paramAnonymousView = new j.b();
                  e.this.a(true, paramAnonymousView, false);
                }
                else
                {
                  if ((paramAnonymousView.getId() == 2131298817) && (e.this.pQV.csQ().Lfi))
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (e.this.pQV.csw())
                  {
                    if (e.this.pZT != null) {
                      e.this.pZT.kx(false);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new j.b();
                    e.this.a(false, paramAnonymousView, false);
                  }
                }
              }
              else if (paramAnonymousView.getId() == 2131296584)
              {
                if (!TextUtils.isEmpty(e.this.pQV.csQ().LeM))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, e.this.pQV.csQ().LeM, 3);
                  com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(13), e.this.pQV.csU(), e.this.pQV.csV(), "", e.this.pQV.csQ().LeL });
                }
              }
              else if (paramAnonymousView.getId() == 2131298195)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.pQV.csQ().nHh), e.this.pQV.csV(), e.this.pQV.csU(), e.this.pZU.pZc });
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KLabel_range_index", e.this.pXh);
                paramAnonymousView.putExtra("Klabel_name_list", e.this.pXi);
                paramAnonymousView.putExtra("Kother_user_name_list", e.this.pXj);
                paramAnonymousView.putExtra("k_sns_label_ui_title", e.this.pQZ.getString(2131757153));
                paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
                paramAnonymousView.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.br.c.b(e.this.pQZ, "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
                e.this.pQZ.mmSetOnActivityResultCallback(e.this);
              }
              else if (paramAnonymousView.getId() == 2131298209)
              {
                if (e.this.pQV.csR().Lcs != null)
                {
                  localObject = e.this.pQV.csR().Lcs;
                  i = ((Integer)paramAnonymousView.getTag()).intValue();
                  paramAnonymousView = (abz)((LinkedList)localObject).get(i);
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.pQV.csU(), paramAnonymousView, e.this.pZU.pWG, e.this.pZU.qaa))
                  {
                    com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(19), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, paramAnonymousView.url, 1);
                    localObject = com.tencent.mm.plugin.report.service.h.CyF;
                    switch (i)
                    {
                    default: 
                      i = 10;
                    }
                    for (;;)
                    {
                      ((com.tencent.mm.plugin.report.service.h)localObject).a(11941, new Object[] { Integer.valueOf(i), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.title });
                      if (!com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.pQV.csU())) {
                        break;
                      }
                      com.tencent.mm.plugin.card.d.l.akj(e.this.pQV.csU());
                      com.tencent.mm.plugin.card.d.b.b(e.this.pQZ, e.this.pQV.csQ().gTG);
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
              else if (paramAnonymousView.getId() == 2131298210)
              {
                if (e.this.pQV.csR().Lcs != null)
                {
                  paramAnonymousView = (abz)e.this.pQV.csR().Lcs.get(0);
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.pQV.csU(), paramAnonymousView, e.this.pZU.pWG, e.this.pZU.qaa))
                  {
                    com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(19), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(10), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.pQV.csU()))
                    {
                      com.tencent.mm.plugin.card.d.l.akj(e.this.pQV.csU());
                      com.tencent.mm.plugin.card.d.b.b(e.this.pQZ, e.this.pQV.csQ().gTG);
                    }
                  }
                }
              }
              else if ((paramAnonymousView.getId() == 2131298240) || (paramAnonymousView.getId() == 2131298186))
              {
                if (e.this.pQV.csR().Lcz != null) {
                  if (e.this.pQV.csI())
                  {
                    if (e.this.pQV.csw())
                    {
                      if (e.this.pZT != null) {
                        e.this.pZT.kx(false);
                      }
                    }
                    else
                    {
                      paramAnonymousView = new j.b();
                      e.this.a(false, paramAnonymousView, false);
                    }
                  }
                  else if (e.this.pQV.csJ())
                  {
                    paramAnonymousView = new j.b();
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, paramAnonymousView.pRN, paramAnonymousView.pRO, false, e.this.pQV);
                  }
                  else
                  {
                    paramAnonymousView = e.this.pQV.csR().Lcz;
                    if (com.tencent.mm.plugin.card.d.b.a(e.this.pQV.csU(), paramAnonymousView, e.this.pZU.pWG, e.this.pZU.qaa))
                    {
                      com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(20), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.title });
                    }
                    else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                    {
                      localObject = com.tencent.mm.plugin.card.d.l.Y(paramAnonymousView.url, paramAnonymousView.LfD);
                      com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, (String)localObject, 1);
                      com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(9), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.title });
                      if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.pQV.csU()))
                      {
                        com.tencent.mm.plugin.card.d.l.akj(e.this.pQV.csU());
                        com.tencent.mm.plugin.card.d.b.b(e.this.pQZ, e.this.pQV.csQ().gTG);
                      }
                    }
                  }
                }
              }
              else
              {
                String str3;
                if ((paramAnonymousView.getId() == 2131298099) || (paramAnonymousView.getId() == 2131298031))
                {
                  paramAnonymousView = e.this.pQV.csQ().LeS;
                  localObject = com.tencent.mm.plugin.report.service.h.CyF;
                  j = e.this.pQV.csQ().nHh;
                  str1 = e.this.pQV.csV();
                  str2 = e.this.pQV.csU();
                  k = e.this.pZU.pWG;
                  str3 = e.this.pZU.pZc;
                  if (e.this.pQV.csO()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.h)localObject).a(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                      break label3233;
                    }
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, paramAnonymousView.url, 1);
                    break;
                  }
                  label3233:
                  localObject = new Intent();
                  if ((e.this.pQV instanceof CardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.this.pQV);
                  }
                  for (;;)
                  {
                    ((Intent)localObject).setClass(e.this.pQZ, CardDetailPreference.class);
                    paramAnonymousView = e.this.pQZ;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                    if ((e.this.pQV instanceof ShareCardInfo)) {
                      ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.this.pQV);
                    }
                  }
                }
                if (paramAnonymousView.getId() == 2131307837)
                {
                  if (com.tencent.mm.plugin.card.sharecard.a.b.ajs(e.this.pQV.csV()) <= 1)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = e.this;
                  if (!e.this.pZu) {}
                  for (;;)
                  {
                    paramAnonymousView.pZu = bool;
                    e.this.cuE();
                    break;
                    bool = false;
                  }
                }
                if (paramAnonymousView.getId() == 2131298035)
                {
                  if ((e.this.pQV.csQ().LeO != null) && (!TextUtils.isEmpty(e.this.pQV.csQ().LeO.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, e.this.pQV.csQ().LeO.url, 3);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(3), e.this.pQV.csU(), e.this.pQV.csV(), "", e.this.pQV.csQ().LeO.text });
                  }
                }
                else if (paramAnonymousView.getId() == 2131298021)
                {
                  if ((e.this.pQV.csQ().LeV != null) && (!Util.isNullOrNil(e.this.pQV.csQ().LeV.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, e.this.pQV.csQ().LeV.url, 1);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(14), e.this.pQV.csU(), e.this.pQV.csV(), "", e.this.pQV.csQ().LeV.text });
                  }
                }
                else if ((paramAnonymousView.getId() == 2131307845) || (paramAnonymousView.getId() == 2131307846))
                {
                  if (e.this.pQV.csQ().LeF > 0)
                  {
                    if ((e.this.pRc == null) || (e.this.pRc.size() == 0))
                    {
                      Log.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(113265);
                      return;
                    }
                    paramAnonymousView = (us)e.this.pRc.get(0);
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, paramAnonymousView.latitude, paramAnonymousView.dTj, paramAnonymousView.iUO);
                    localObject = com.tencent.mm.plugin.report.service.h.CyF;
                    j = e.this.pQV.csQ().nHh;
                    str1 = e.this.pQV.csV();
                    str2 = e.this.pQV.csU();
                    k = e.this.pZU.pWG;
                    str3 = e.this.pZU.pZc;
                    if (e.this.pQV.csO()) {}
                    for (i = 1;; i = 0)
                    {
                      ((com.tencent.mm.plugin.report.service.h)localObject).a(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                      com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(5), e.this.pQV.csU(), e.this.pQV.csV(), "", paramAnonymousView.name });
                      break;
                    }
                  }
                }
                else if (paramAnonymousView.getId() == 2131309082)
                {
                  if ((e.this.pRc == null) || (e.this.pRc.size() == 0))
                  {
                    Log.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  localObject = (us)e.this.pRc.get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.this.pQZ.getString(2131756971))))
                  {
                    e.a(e.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (!TextUtils.isEmpty(((us)localObject).pTL))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.pQZ, ((us)localObject).pTL, 1);
                    com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(4), e.this.pQV.csU(), e.this.pQV.csV(), "", ((us)localObject).name });
                  }
                }
                else if (paramAnonymousView.getId() == 2131309077)
                {
                  e.a(e.this);
                }
              }
            }
          }
        }
      }
    };
    this.pZW = new e.7(this);
    this.pQZ = paramMMActivity;
    this.jBN = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void Es(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.pQV.csR().Lcx;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.pZR.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      bg localbg = (bg)localLinkedList.get(paramInt);
      j = i;
      if (!Util.isNullOrNil(localbg.text))
      {
        j = i;
        if (!Util.isNullOrNil(localbg.url))
        {
          this.pZS.add(localbg.text);
          this.pZQ.put(Integer.valueOf(i), localbg.text);
          this.pZR.put(localbg.text, localbg.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(113300);
  }
  
  private void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.pZx != null) {
      this.pZx.H(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void ajG(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.pQV instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.pQV);
    }
    for (;;)
    {
      localIntent.setClass(this.pQZ, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.pZU.gwE);
      localIntent.putExtra("key_previous_scene", this.pZU.pWG);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.pZU.qaa);
      this.pQZ.startActivityForResult(localIntent, 3);
      this.pQZ.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.pQV instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.pQV);
      }
    }
  }
  
  private String cuG()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.pXi)) && (!TextUtils.isEmpty(this.pXj)))
    {
      str = this.pXi + "," + com.tencent.mm.plugin.card.d.l.akh(this.pXj);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.pXi))
    {
      str = this.pXi;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.pXj))
    {
      str = com.tencent.mm.plugin.card.d.l.akh(this.pXj);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private void cvA()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.pZs == null)
    {
      i = 0;
      if (i != 0)
      {
        this.pZs.release();
        this.pZs = null;
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.pQV.csQ().nHh) });
      }
      if (this.pZs == null)
      {
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.pQV.csQ().nHh) });
        Log.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.pQV.csQ().nHh) });
        if (!this.pQV.csw()) {
          break label423;
        }
        this.pZs = new com.tencent.mm.plugin.card.ui.a.h(this.pQZ);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.pQV.csQ().nHh) });
      this.pZs.a(this.pQV, this.pZU);
      AppMethodBeat.o(113279);
      return;
      if (this.pQV.csw())
      {
        if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.pQV.csx())
      {
        if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.pQV.csA())
      {
        if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.pQV.csy())
      {
        if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.pQV.csz())
      {
        if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.pQV.csB())
      {
        if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.pZs instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.pQV.csQ().nHh)
      {
      default: 
        this.pZs = new com.tencent.mm.plugin.card.ui.a.a(this.pQZ);
        break;
      case 0: 
        this.pZs = new com.tencent.mm.plugin.card.ui.a.c(this.pQZ);
        break;
      case 10: 
        this.pZs = new com.tencent.mm.plugin.card.ui.a.e(this.pQZ);
        break;
      case 11: 
        this.pZs = new com.tencent.mm.plugin.card.ui.a.b(this.pQZ);
        break;
      case 20: 
        this.pZs = new com.tencent.mm.plugin.card.ui.a.f(this.pQZ);
        break;
      case 30: 
        this.pZs = new com.tencent.mm.plugin.card.ui.a.d(this.pQZ);
      }
    }
  }
  
  private void cvB()
  {
    AppMethodBeat.i(113285);
    if ((this.pQV.csQ().Lff != null) && (this.pQV.csQ().Lff.LrL))
    {
      this.pZz = new com.tencent.mm.plugin.card.ui.view.m();
      am.cug().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.pQV.csQ().nHh == 10)
    {
      this.pZz = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.pZz = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void cvC()
  {
    AppMethodBeat.i(113286);
    if (this.dLD)
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label197:
    Object localObject3;
    int i;
    if ((this.pQV.csv()) && (this.pQV.csx()))
    {
      this.jBN.findViewById(2131298102).setBackgroundColor(this.pQZ.getResources().getColor(2131101424));
      this.pQZ.setActionbarColor(this.pQZ.getResources().getColor(2131101424));
      localObject2 = this.jBN.findViewById(2131299548);
      localObject1 = this.jBN.findViewById(2131302316);
      localView = this.jBN.findViewById(2131299543);
      if ((!this.pQV.csv()) || (!this.pZs.cwH())) {
        break label1267;
      }
      if (!this.pQV.csy()) {
        break label1133;
      }
      ((View)localObject2).setBackgroundResource(2131231579);
      this.jBN.findViewById(2131301799).setBackgroundResource(2131231520);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.pQV.csB())
      {
        localObject3 = (TextView)this.jBN.findViewById(2131297715);
        localObject4 = new BitmapDrawable(BitmapUtil.getBitmapNative(2131231574));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.pQV.csw()) && (this.pZs.cwF()) && (this.pZu))
      {
        localObject4 = this.jBN.findViewById(2131307833);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.pQV.csv()) && (this.pZs.cwH()))
      {
        localObject4 = this.jBN.findViewById(2131301799);
        ((Rect)localObject3).left = this.pQZ.getResources().getDimensionPixelOffset(2131165498);
        ((Rect)localObject3).right = this.pQZ.getResources().getDimensionPixelOffset(2131165498);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.pQV.csz())
        {
          localObject3 = this.jBN.findViewById(2131301800);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.pQZ.getResources().getDimensionPixelSize(2131165586);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.pZs.cwH()) && (!this.pZs.cwF())) {
        break label1491;
      }
      if ((this.pZx != null) && (((this.pQV.csv()) && (this.pQV.csy())) || (this.pQV.csw()))) {
        this.pZx.EK(0);
      }
      label650:
      if ((this.pZx != null) && (this.pQV.csv()) && (this.pQV.csx()))
      {
        i = this.pQZ.getResources().getDimensionPixelOffset(2131166015);
        localObject3 = com.tencent.mm.plugin.card.d.l.fi(com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw), i);
        this.pZx.a((ShapeDrawable)localObject3);
      }
      if ((this.pQV.csv()) && (this.pQV.csx()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.pQV.csQ().LeL)) {
          break label1576;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label816:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.pQZ.getResources().getDimensionPixelSize(2131165518);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.pQV.csx()) {
          break label1591;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.pQZ.getResources().getDimensionPixelSize(2131165507);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.pQZ.getResources().getDimensionPixelSize(2131165508);
        i = this.pQZ.getResources().getDimensionPixelSize(2131165501);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label932:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.pQV.csx()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.pQZ.getResources().getDimensionPixelSize(2131165501);
        }
        if (TextUtils.isEmpty(this.pQV.csQ().LeL)) {
          break label1620;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.pQV.csQ().LeL))
      {
        localView = findViewById(2131296583);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.jBN.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.d.l.ake(this.pQV.csQ().ixw);
      this.jBN.findViewById(2131298102).setBackgroundColor(i);
      this.pQZ.setActionbarColor(i);
      break;
      label1133:
      if (this.pQV.csx())
      {
        this.jBN.findViewById(2131301799).setBackgroundResource(0);
        localView.setBackgroundColor(this.pQZ.getResources().getColor(2131101424));
        break label197;
      }
      if (this.pQV.csz())
      {
        ((View)localObject2).setBackgroundResource(2131231579);
        this.jBN.findViewById(2131301799).setBackgroundResource(2131231520);
        localView.setBackgroundResource(0);
        break label197;
      }
      if ((this.pQV.csA()) || (!this.pQV.csB())) {
        break label197;
      }
      localView.setBackgroundColor(this.pQZ.getResources().getColor(2131101424));
      break label197;
      label1267:
      if (this.pQV.csw())
      {
        if ((this.pZs.cwF()) && (this.pZu))
        {
          ((View)localObject2).setBackgroundResource(2131231579);
          localView.setBackgroundResource(0);
          break label197;
        }
        if ((this.pZs.cwF()) && (!this.pZu))
        {
          ((View)localObject2).setBackgroundResource(2131231575);
          localView.setBackgroundResource(0);
          break label197;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.pZs.cvO())
        {
          localView.setBackgroundResource(2131231575);
          break label197;
        }
        localView.setBackgroundResource(2131231579);
        break label197;
      }
      if (this.pQV.csy())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.pZs.cvO())
        {
          localView.setBackgroundResource(2131231575);
          break label197;
        }
        localView.setBackgroundResource(2131231579);
        break label197;
      }
      if (this.pQV.csz())
      {
        ((View)localObject2).setBackgroundResource(2131231583);
        localView.setBackgroundResource(0);
        break label197;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.pQZ.getResources().getColor(2131101424));
      break label197;
      label1491:
      if ((this.pZx == null) || (((!this.pQV.csv()) || (!this.pQV.csy())) && (!this.pQV.csw()))) {
        break label650;
      }
      if (this.pZs.cvO())
      {
        this.pZx.EK(2131231580);
        break label650;
      }
      this.pZx.EK(2131231578);
      break label650;
      label1576:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label816;
      label1591:
      i = this.pQZ.getResources().getDimensionPixelSize(2131165201);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label932;
      label1620:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void cvD()
  {
    AppMethodBeat.i(113290);
    if (!this.pZs.cwJ())
    {
      Log.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.pRa.clear();
    this.pRa.addAll(this.pZN.ctr());
    this.pZA.setData(this.pRa);
    this.pZA.qeu = this.pQV.csB();
    this.pZA.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void cvE()
  {
    AppMethodBeat.i(113291);
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (cvF()) {
      cvH();
    }
    if (this.pZx == null) {
      cvG();
    }
    if (this.pZx != null)
    {
      if (this.pQV.csz()) {
        ((com.tencent.mm.plugin.card.widget.f)this.pZx).pRc = this.pRc;
      }
      this.pZx.d(this.pQV);
    }
    AppMethodBeat.o(113291);
  }
  
  private boolean cvF()
  {
    AppMethodBeat.i(113292);
    if (this.pZx == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.pQV.csx())
    {
      if ((this.pZx instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.pQV.csA())
    {
      if ((this.pZx instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.pQV.csy())
    {
      if ((this.pZx instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.pQV.csz())
    {
      if ((this.pZx instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.pQV.csB())
    {
      if ((this.pZx instanceof com.tencent.mm.plugin.card.widget.d))
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
  
  private void cvG()
  {
    AppMethodBeat.i(113293);
    if (this.pQV.csx()) {
      this.pZx = new com.tencent.mm.plugin.card.widget.e(this.pQZ);
    }
    for (;;)
    {
      this.pZx.i(this.pQV);
      View localView = this.pZx.jz();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.n.a(localView, this.pZy);
      }
      this.pZy.invalidate();
      this.pZx.setOnClickListener(this.kuO);
      H(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.pQV.csA()) {
        this.pZx = new com.tencent.mm.plugin.card.widget.c(this.pQZ);
      } else if (this.pQV.csy()) {
        this.pZx = new com.tencent.mm.plugin.card.widget.b(this.pQZ);
      } else if (this.pQV.csz()) {
        this.pZx = new com.tencent.mm.plugin.card.widget.f(this.pQZ);
      } else if (this.pQV.csB()) {
        this.pZx = new com.tencent.mm.plugin.card.widget.d(this.pQZ);
      } else {
        this.pZx = new com.tencent.mm.plugin.card.widget.b(this.pQZ);
      }
    }
  }
  
  private void cvH()
  {
    AppMethodBeat.i(113294);
    View localView = this.pZx.jz();
    if (localView != null) {
      this.pZy.removeView(localView);
    }
    this.pZy.removeAllViews();
    this.pZy.invalidate();
    this.pZx.release();
    this.pZx = null;
    AppMethodBeat.o(113294);
  }
  
  private void cvI()
  {
    AppMethodBeat.i(113295);
    if ((this.pZx != null) && ((this.pZx instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.pZx).cvI();
    }
    AppMethodBeat.o(113295);
  }
  
  private void cvJ()
  {
    AppMethodBeat.i(113296);
    ty localty = this.pQV.csR();
    this.pQV.a(localty);
    com.tencent.mm.plugin.card.d.l.h(this.pQV);
    AppMethodBeat.o(113296);
  }
  
  private void cvK()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.pZQ.clear();
    this.pZS.clear();
    if (this.pQV.csE())
    {
      this.pZS.add(getString(2131757199));
      this.pZQ.put(Integer.valueOf(0), "menu_func_share_friend");
      this.pZS.add(getString(2131757198));
      this.pZQ.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.pQV.csR().Lcv))
    {
      this.pZS.add(getString(2131757108));
      this.pZQ.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    Es(j);
    if (this.pZS.size() > 0) {
      this.pQZ.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void cvL()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.pZQ.clear();
    this.pZS.clear();
    int i = j;
    if (this.pQV.csv())
    {
      i = j;
      if (this.pQV.csD())
      {
        if (Util.isNullOrNil(this.pQV.csQ().Lfl)) {
          break label235;
        }
        this.pZS.add(this.pQV.csQ().Lfl);
        this.pZQ.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.pQV.csR().Lcv))
    {
      this.pZS.add(getString(2131757108));
      this.pZQ.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.pQV.csv())
    {
      this.pZS.add(getString(2131755778));
      this.pZQ.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      Es(i);
      if (this.pZS.size() > 0) {
        this.pQZ.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.pQV.csB())
      {
        this.pZS.add(getString(2131757107));
        break;
      }
      this.pZS.add(getString(2131757106));
      break;
      i = j;
      if (this.pQV.csw())
      {
        String str1 = com.tencent.mm.model.z.aTY();
        String str2 = this.pQV.csW();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.pZS.add(getString(2131755778));
          this.pZQ.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          Log.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void cvM()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.pZQ.clear();
    this.pZS.clear();
    if (!TextUtils.isEmpty(this.pQV.csR().Lcv))
    {
      this.pZS.add(getString(2131757108));
      this.pZQ.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    Es(i);
    if (this.pZS.size() > 0) {
      this.pQZ.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(113289);
    if (!this.pZs.cwE())
    {
      this.pQZ.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.pQZ.setMMTitle(this.pZN.getTitle());
    AppMethodBeat.o(113289);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, a parama, ArrayList<us> paramArrayList)
  {
    this.pQV = paramb;
    this.pZU = parama;
    this.pRc = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.pQV.csR().Lcz;
      if (this.pQV.csJ())
      {
        com.tencent.mm.plugin.card.d.b.a(this.pQZ, paramb.pRN, paramb.pRO, paramBoolean2, this.pQV);
        com.tencent.mm.plugin.report.service.h.CyF.a(11941, new Object[] { Integer.valueOf(17), this.pQV.csU(), this.pQV.csV(), "", this.pQV.csR().Lcz.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((abz)localObject1).Leo)) && (!TextUtils.isEmpty(((abz)localObject1).Lep)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.pQV.csU(), (abz)localObject1, this.pZU.pWG, this.pZU.qaa);
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
        str1 = this.pQV.csU();
        str2 = this.pQV.csV();
        if (((abz)localObject1).title != null) {}
        for (paramb = ((abz)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((abz)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.Y(((abz)localObject1).url, ((abz)localObject1).LfD);
        com.tencent.mm.plugin.card.d.b.a(this.pQZ, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
        str1 = this.pQV.csU();
        str2 = this.pQV.csV();
        if (((abz)localObject1).title != null) {}
        for (paramb = ((abz)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
      j = this.pQV.csQ().nHh;
      localObject2 = this.pQV.csV();
      str1 = this.pQV.csU();
      k = this.pZU.pWG;
      str2 = this.pZU.pZc;
      if (this.pQV.csO()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        ajG(paramb.pRK);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
    int k = this.pQV.csQ().nHh;
    Object localObject2 = this.pQV.csV();
    String str1 = this.pQV.csU();
    int m = this.pZU.pWG;
    String str2 = this.pZU.pZc;
    if (this.pQV.csO()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      ajG(paramb.pRK);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aM(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    Log.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.qag = b.qae;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(2131757007);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.pZV.sendMessage(localMessage);
      AppMethodBeat.o(113282);
      return;
      if (paramInt == 2) {
        paramString = getString(2131756976);
      } else {
        paramString = getString(2131757006);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113277);
    if (paramb != null)
    {
      this.pQV = paramb;
      if (this.pZT != null) {
        this.pZT.b(paramb);
      }
      cuE();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113284);
    Log.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.qag = b.qad;
    localc.qah = paramc;
    localMessage.obj = localc;
    this.pZV.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113281);
    Log.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.qag = b.qab;
    localc.qah = paramc;
    localMessage.obj = localc;
    this.pZV.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final void ctv()
  {
    AppMethodBeat.i(113283);
    Log.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.qag = b.qac;
    localMessage.obj = localc;
    this.pZV.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final void cuE()
  {
    AppMethodBeat.i(113280);
    if (this.pQV == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.pZT != null) {
        this.pZT.cvn();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.pQV.csQ() == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.pZT != null) {
        this.pZT.cvn();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.pQV.csR() == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.pZT != null) {
        this.pZT.cvn();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.pQV.csC())
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.pQV.csQ().nHh) });
      if (!TextUtils.isEmpty(this.pQV.csQ().LeG))
      {
        com.tencent.mm.plugin.card.d.b.a(this.pQZ, this.pQV.csQ().LeG, 0);
        if (this.pZT != null)
        {
          this.pZT.cvn();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.pQZ, getString(2131757117), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.this.pZT != null) {
              e.this.pZT.cvn();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    Log.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    Log.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.pQV.csQ().Lfb);
    this.pZN.a(this.pQV, this.pRc, this.pZU.gwE);
    cvA();
    this.pZs.cwW();
    Log.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    cvE();
    if (this.pZs.cwF())
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.pZt.update();
      if (!this.pZs.cww()) {
        break label1156;
      }
      if (this.pZK == null)
      {
        this.pZK = new com.tencent.mm.plugin.card.ui.view.b();
        this.pZK.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.pZK.update();
      label436:
      this.pQZ.showOptionMenu(this.pZs.cwA());
      if (this.pZs.cwB()) {
        cvK();
      }
      if (this.pZs.cwC()) {
        cvL();
      }
      if (this.pZs.cwD()) {
        cvM();
      }
      cvI();
      H(this.pZs.cwy(), this.pZs.cwz());
      if ((this.pQV.csx()) || (!this.pZs.cwH())) {
        break label1181;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.pZv.update();
      label565:
      if (this.pZx != null) {
        this.pZx.kE(this.pZs.cvO());
      }
      cvC();
      if (!this.pZs.cwM()) {
        break label1278;
      }
      if (this.pZC == null)
      {
        this.pZC = new y();
        this.pZC.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.pZC.update();
      label647:
      if (!this.pZs.cwV()) {
        break label1303;
      }
      if (this.pZB == null)
      {
        this.pZB = new com.tencent.mm.plugin.card.ui.view.c();
        this.pZB.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.pZB.update();
      label700:
      if (!this.pZs.cwN()) {
        break label1328;
      }
      if (this.pZD == null)
      {
        this.pZD = new k();
        this.pZD.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.pZD.update();
      label753:
      if (!this.pZs.cwO()) {
        break label1353;
      }
      if (this.pZE == null)
      {
        this.pZE = new w();
        this.pZE.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.pZE.update();
      label806:
      if (!this.pZs.cwP()) {
        break label1378;
      }
      if (this.pZF == null)
      {
        this.pZF = new com.tencent.mm.plugin.card.ui.view.l();
        this.pZF.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.pZF.update();
      label859:
      if (!this.pZs.cwQ()) {
        break label1403;
      }
      if (this.pZG == null)
      {
        this.pZG = new com.tencent.mm.plugin.card.ui.view.z();
        this.pZG.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.pZG.update();
      label912:
      if (!this.pZs.cwS()) {
        break label1428;
      }
      if (this.pZH == null)
      {
        this.pZH = new com.tencent.mm.plugin.card.ui.view.e();
        this.pZH.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.pZH.update();
      label965:
      if (!this.pZs.cwR()) {
        break label1453;
      }
      if (this.pZI == null)
      {
        this.pZI = new com.tencent.mm.plugin.card.ui.view.u();
        this.pZI.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.pZI.update();
      label1018:
      cvD();
      if (!this.pZs.cwK()) {
        break label1530;
      }
      cvJ();
      if (!this.pZs.cwL()) {
        break label1513;
      }
      if (this.pZz != null) {
        break label1478;
      }
      cvB();
      this.pZz.a(this);
      this.pZz.update();
      label1076:
      if (this.pZx != null) {
        this.pZx.kD(true);
      }
      label1093:
      if (!this.pZs.cwT()) {
        break label1572;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.pZJ.update();
    }
    for (;;)
    {
      this.pZL.pQV = this.pQV;
      AppMethodBeat.o(113280);
      return;
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.pZt.cxw();
      break;
      label1156:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.pZK == null) {
        break label436;
      }
      this.pZK.cxw();
      break label436;
      label1181:
      if ((this.pQV.csx()) && (this.pZs.cwH()))
      {
        Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.pZw.update();
        break label565;
      }
      if (this.pZs.cwI())
      {
        Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.pZw.update();
        break label565;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.pZw.cxw();
      this.pZv.cxw();
      break label565;
      label1278:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.pZC == null) {
        break label647;
      }
      this.pZC.cxw();
      break label647;
      label1303:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.pZB == null) {
        break label700;
      }
      this.pZB.cxw();
      break label700;
      label1328:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.pZD == null) {
        break label753;
      }
      this.pZD.cxw();
      break label753;
      label1353:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.pZE == null) {
        break label806;
      }
      this.pZE.cxw();
      break label806;
      label1378:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.pZF == null) {
        break label859;
      }
      this.pZF.cxw();
      break label859;
      label1403:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.pZG == null) {
        break label912;
      }
      this.pZG.cxw();
      break label912;
      label1428:
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.pZH == null) {
        break label965;
      }
      this.pZH.cxw();
      break label965;
      label1453:
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.pZI == null) {
        break label1018;
      }
      this.pZI.cxw();
      break label1018;
      label1478:
      if (!this.pZz.f(this.pQV)) {
        break label1076;
      }
      this.pZz.b(this.pQV);
      this.pZz.update();
      break label1076;
      label1513:
      if (this.pZz == null) {
        break label1076;
      }
      this.pZz.cxA();
      break label1076;
      label1530:
      Log.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.pZz != null) {
        this.pZz.cxA();
      }
      if (this.pZx == null) {
        break label1093;
      }
      this.pZx.kD(false);
      break label1093;
      label1572:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.pZJ.cxw();
    }
  }
  
  public final int cvN()
  {
    AppMethodBeat.i(113304);
    if (this.pZN == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.pZN.ctt())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean cvO()
  {
    AppMethodBeat.i(113305);
    if (this.pZs == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.pZs.cvO();
    AppMethodBeat.o(113305);
    return bool;
  }
  
  public final com.tencent.mm.plugin.card.base.b cvq()
  {
    return this.pQV;
  }
  
  public final boolean cvr()
  {
    return this.pZu;
  }
  
  public final void cvs()
  {
    this.pZu = false;
  }
  
  public final MMActivity cvt()
  {
    return this.pQZ;
  }
  
  public final View.OnClickListener cvu()
  {
    return this.kuO;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g cvv()
  {
    return this.pZs;
  }
  
  public final d cvw()
  {
    return this.pZT;
  }
  
  public final a cvx()
  {
    return this.pZU;
  }
  
  public final com.tencent.mm.plugin.card.b.f cvy()
  {
    return this.pZN;
  }
  
  public final j cvz()
  {
    return this.pZL;
  }
  
  public final void d(final int paramInt1, int paramInt2, final Intent paramIntent)
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
        this.pZO = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.pZO;
        if ((this.pQV == null) || (this.pQV.csQ() == null))
        {
          Log.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.pQV.csS().MXq)) && (!this.pQV.csB())) {
            localStringBuilder.append(this.pQV.csS().MXq);
          }
        }
        for (;;)
        {
          String str = this.pQV.csQ().title + "\n" + this.pQV.csQ().gTG;
          ab.a.Kgn.a(this.pQZ.getController(), localStringBuilder.toString(), this.pQV.csQ().iwv, str, true, this.pQZ.getResources().getString(2131755976), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(113270);
              if (paramAnonymousBoolean)
              {
                e.this.pZP = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.this.pZT != null) {
                    e.this.pZT.ajF(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.pQV.csQ().nHh), e.this.pQV.csV(), e.this.pQV.csU(), e.this.pZO });
                  com.tencent.mm.ui.base.h.cD(e.this.pQZ, e.this.pQZ.getResources().getString(2131757038));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 1)
                {
                  paramAnonymousString = e.this;
                  paramAnonymousString.pQV.csS().MXq = (paramAnonymousString.getString(2131757164) + paramAnonymousString.pZN.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.pQV, paramAnonymousString.pZO, paramAnonymousString.pZU.pZe, 2);
                  com.tencent.mm.plugin.card.d.l.fB(paramAnonymousString.pZP, paramAnonymousString.pZO);
                  com.tencent.mm.ui.base.h.cD(e.this.pQZ, e.this.pQZ.getResources().getString(2131757038));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 4)
                {
                  paramAnonymousString = e.this;
                  if (TextUtils.isEmpty(paramAnonymousString.pQV.csW())) {
                    paramAnonymousString.pQV.aiY(com.tencent.mm.model.z.aTY());
                  }
                  paramAnonymousString.pQV.csS().MXq = (paramAnonymousString.getString(2131757125) + paramAnonymousString.pZN.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.pQV, paramAnonymousString.pZO, paramAnonymousString.pZU.pZe, 23);
                  com.tencent.mm.plugin.card.d.l.fB(paramAnonymousString.pZP, paramAnonymousString.pZO);
                  com.tencent.mm.plugin.report.service.h.CyF.a(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.this.pZU.gwE), Integer.valueOf(e.this.pQV.csQ().nHh), e.this.pQV.csV(), e.this.pQV.csU(), e.this.pZO });
                  com.tencent.mm.ui.base.h.cD(e.this.pQZ, e.this.pQZ.getResources().getString(2131757038));
                }
              }
              AppMethodBeat.o(113270);
            }
          });
          AppMethodBeat.o(113301);
          return;
          localStringBuilder.append(getString(2131766179));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(2131757164) + this.pZN.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(2131757125) + this.pZN.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.pXh = paramIntent.getIntExtra("Ktag_range_index", 0);
        Log.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.pXh) });
        if (this.pXh >= 2)
        {
          this.pXi = paramIntent.getStringExtra("Klabel_name_list");
          this.pXj = paramIntent.getStringExtra("Kother_user_name_list");
          Log.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.pXh), this.pXi });
          if ((TextUtils.isEmpty(this.pXi)) && (TextUtils.isEmpty(this.pXj)))
          {
            Log.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.pXi.split(","));
          this.pXl = com.tencent.mm.plugin.card.d.l.cZ(paramIntent);
          this.pXk = com.tencent.mm.plugin.card.d.l.cY(paramIntent);
          if ((this.pXj != null) && (this.pXj.length() > 0))
          {
            paramIntent = Arrays.asList(this.pXj.split(","));
            this.pXk.addAll(paramIntent);
          }
          if (this.pXl != null) {
            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.pXl.size());
          }
          if (this.pXk != null)
          {
            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.pXk.size());
            paramIntent = this.pXk.iterator();
            while (paramIntent.hasNext()) {
              Log.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.pXh == 2)
          {
            this.pZJ.ajU(this.pQZ.getString(2131757152, new Object[] { cuG() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.pXh == 3)
          {
            this.pZJ.ajU(this.pQZ.getString(2131757151, new Object[] { cuG() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.pZJ.ajU(this.pQZ.getString(2131757150));
          AppMethodBeat.o(113301);
          return;
        }
        this.pZJ.ajU(this.pQZ.getString(2131757150));
        AppMethodBeat.o(113301);
        return;
        if (this.pZT != null) {
          this.pZT.cvp();
        }
      }
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.jBN.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.pQZ.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public static final class a
  {
    public int gwE = 3;
    public String pQH = "";
    public boolean pSh = false;
    public int pWG = -1;
    public String pYJ = "";
    public String pYK = "";
    public String pZc = "";
    public String pZd = "";
    public String pZe = "";
    public int qaa = 0;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(113274);
      qab = new b("onGetCodeSuccess", 0);
      qac = new b("onShowTimeExpired", 1);
      qad = new b("onReceiveCodeUnavailable", 2);
      qae = new b("onGetCodeFail", 3);
      qaf = new b[] { qab, qac, qad, qae };
      AppMethodBeat.o(113274);
    }
    
    private b() {}
  }
  
  static final class c
  {
    int errCode;
    String errMsg;
    e.b qag;
    com.tencent.mm.plugin.card.d.c qah;
  }
  
  public static abstract interface d
  {
    public abstract void ajF(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void cvj();
    
    public abstract void cvk();
    
    public abstract void cvl();
    
    public abstract void cvm();
    
    public abstract void cvn();
    
    public abstract void cvo();
    
    public abstract void cvp();
    
    public abstract void kx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */