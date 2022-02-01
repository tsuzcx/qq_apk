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
import com.tencent.mm.g.a.cg;
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
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  boolean dhO;
  private View ijA;
  View.OnClickListener jax;
  ListView mListView;
  com.tencent.mm.plugin.card.base.b nTp;
  MMActivity nTt;
  List<com.tencent.mm.plugin.card.model.b> nTu;
  ArrayList<rr> nTw;
  public ArrayList<String> nZA;
  public ArrayList<String> nZB;
  public int nZx;
  String nZy;
  String nZz;
  com.tencent.mm.plugin.card.ui.a.g obJ;
  i obK;
  boolean obL;
  i obM;
  i obN;
  com.tencent.mm.plugin.card.widget.g obO;
  LinearLayout obP;
  com.tencent.mm.plugin.card.ui.view.g obQ;
  m obR;
  i obS;
  i obT;
  i obU;
  i obV;
  i obW;
  i obX;
  i obY;
  i obZ;
  com.tencent.mm.plugin.card.ui.view.d oca;
  i ocb;
  j occ;
  boolean ocd;
  com.tencent.mm.plugin.card.b.f oce;
  public String ocf;
  public String ocg;
  HashMap<Integer, String> och;
  HashMap<String, String> oci;
  ArrayList<String> ocj;
  d ock;
  a ocl;
  private ao ocm;
  com.tencent.mm.sdk.b.c ocn;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.obL = false;
    this.ocd = true;
    this.nTu = new ArrayList();
    this.ocf = "";
    this.ocg = "";
    this.nZx = 0;
    this.nZy = "";
    this.nZz = "";
    this.nZA = new ArrayList();
    this.nZB = new ArrayList();
    this.och = new HashMap();
    this.oci = new HashMap();
    this.ocj = new ArrayList();
    this.dhO = false;
    this.ocm = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.c)))
        {
          paramAnonymousMessage = (e.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.ocx == e.b.ocv)
          {
            if (e.this.obQ != null)
            {
              com.tencent.mm.plugin.card.d.d.a(e.this.nTt, paramAnonymousMessage.errMsg, false);
              e.this.obQ.bTP();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.ocx == e.b.oct)
          {
            if (e.this.obQ != null)
            {
              e.this.obQ.d(com.tencent.mm.plugin.card.d.c.olY);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.this.obQ != null) {
            e.this.obQ.d(paramAnonymousMessage.ocy);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(113265);
        if ((paramAnonymousView.getId() == 2131297719) || (paramAnonymousView.getId() == 2131297710))
        {
          if (e.this.nTp.bON())
          {
            if (e.this.ock != null)
            {
              e.this.ock.bRC();
              AppMethodBeat.o(113265);
            }
          }
          else if ((e.this.nTp.bOO()) && (e.this.ock != null))
          {
            e.this.ock.bRA();
            AppMethodBeat.o(113265);
          }
        }
        else
        {
          if ((paramAnonymousView.getId() == 2131300306) || (paramAnonymousView.getId() == 2131296317))
          {
            com.tencent.mm.plugin.card.d.b.ad(e.this.nTt, e.this.ocl.obt);
            AppMethodBeat.o(113265);
            return;
          }
          Object localObject;
          if ((paramAnonymousView.getId() == 2131298400) || (paramAnonymousView.getId() == 2131298384))
          {
            if (paramAnonymousView.getId() == 2131298400)
            {
              e.this.ocd = false;
              if ((e.this.obQ instanceof q))
              {
                localObject = ((q)e.this.obQ).e(com.tencent.mm.plugin.card.d.c.oma);
                e.this.occ.ogg = ((String)localObject);
              }
              localObject = e.this.occ;
              bool = e.this.ocd;
              ((j)localObject).bSy();
              ((j)localObject).ocd = bool;
              if ((((j)localObject).jat != null) && (!((j)localObject).jat.isShowing()))
              {
                ((j)localObject).jat.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).jat.setFocusable(true);
                ((j)localObject).jat.setTouchable(true);
                ((j)localObject).jat.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).jat.setOutsideTouchable(true);
                if (!((j)localObject).ocd) {
                  break label741;
                }
                ((j)localObject).ogc.setOnClickListener(((j)localObject).jax);
                paramAnonymousView = ((j)localObject).ofY;
                if (((j)localObject).nYK == null) {
                  break label653;
                }
                ((j)localObject).ofY = com.tencent.mm.plugin.card.d.l.S(((j)localObject).nYK);
                label391:
                ((j)localObject).ogc.setImageBitmap(((j)localObject).ofY);
                ((j)localObject).ogf.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).jav.setVisibility(8);
                ((j)localObject).ogb.setVisibility(0);
                paramAnonymousView = ((j)localObject).nTp.bPj().code;
                if ((((j)localObject).nTp.bPi().EkU != null) && (((j)localObject).nTp.bPi().EkU.Ewc)) {
                  break label695;
                }
                if (bs.isNullOrNil(((j)localObject).nTp.bPj().Eis)) {
                  break label662;
                }
                paramAnonymousView = ((j)localObject).nTp.bPj().Eis;
                label520:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label715;
                }
                ((j)localObject).ogd.setText(com.tencent.mm.plugin.card.d.n.VF(paramAnonymousView));
                if (!((j)localObject).nTp.bOX()) {
                  break label702;
                }
                ((j)localObject).ogd.setVisibility(0);
                label570:
                if (bs.isNullOrNil(((j)localObject).nTp.bPi().iAx)) {
                  break label728;
                }
                ((j)localObject).oge.setText(((j)localObject).nTp.bPi().iAx);
                ((j)localObject).oge.setVisibility(0);
              }
            }
            for (;;)
            {
              ((j)localObject).jat.update();
              AppMethodBeat.o(113265);
              return;
              if (paramAnonymousView.getId() != 2131298384) {
                break;
              }
              e.this.ocd = true;
              break;
              label653:
              ((j)localObject).ofY = null;
              break label391;
              label662:
              if (!((j)localObject).nTp.bPc()) {
                break label520;
              }
              if (!bs.isNullOrNil(((j)localObject).ogg))
              {
                paramAnonymousView = ((j)localObject).ogg;
                break label520;
              }
              label695:
              paramAnonymousView = "";
              break label520;
              label702:
              ((j)localObject).ogd.setVisibility(8);
              break label570;
              label715:
              ((j)localObject).ogd.setVisibility(8);
              break label570;
              label728:
              ((j)localObject).oge.setVisibility(8);
            }
            label741:
            ((j)localObject).jau.setOnClickListener(((j)localObject).jax);
            ((j)localObject).jau.setImageBitmap(((j)localObject).jas);
            paramAnonymousView = ((j)localObject).nTp.bPj().code;
            if ((((j)localObject).nTp.bPi().EkU == null) || (!((j)localObject).nTp.bPi().EkU.Ewc)) {
              if (!bs.isNullOrNil(((j)localObject).nTp.bPj().Eis))
              {
                paramAnonymousView = ((j)localObject).nTp.bPj().Eis;
                label849:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label1023;
                }
                ((j)localObject).ofZ.setText(com.tencent.mm.plugin.card.d.n.VF(paramAnonymousView));
                if (!((j)localObject).nTp.bOX()) {
                  break label1010;
                }
                ((j)localObject).ofZ.setVisibility(0);
                label899:
                if (TextUtils.isEmpty(((j)localObject).nTp.bPi().iAx)) {
                  break label1036;
                }
                ((j)localObject).oga.setText(((j)localObject).nTp.bPi().iAx);
                ((j)localObject).oga.setVisibility(0);
              }
            }
            for (;;)
            {
              ((j)localObject).jav.setVisibility(0);
              ((j)localObject).ogb.setVisibility(8);
              break;
              if (!((j)localObject).nTp.bPc()) {
                break label849;
              }
              if (!bs.isNullOrNil(((j)localObject).ogg))
              {
                paramAnonymousView = ((j)localObject).ogg;
                break label849;
              }
              paramAnonymousView = "";
              break label849;
              label1010:
              ((j)localObject).ofZ.setVisibility(8);
              break label899;
              label1023:
              ((j)localObject).ofZ.setVisibility(8);
              break label899;
              label1036:
              ((j)localObject).oga.setVisibility(8);
            }
          }
          int j;
          String str1;
          int k;
          String str2;
          int i;
          if ((paramAnonymousView.getId() == 2131297769) || (paramAnonymousView.getId() == 2131297762) || (paramAnonymousView.getId() == 2131297761) || (paramAnonymousView.getId() == 2131298408) || (paramAnonymousView.getId() == 2131297760))
          {
            if (paramAnonymousView.getId() == 2131297769)
            {
              if (e.this.nTp.bOO())
              {
                paramAnonymousView = com.tencent.mm.plugin.report.service.h.wUl;
                j = e.this.nTp.bPi().lRv;
                localObject = e.this.nTp.bPn();
                str1 = e.this.nTp.bPm();
                k = e.this.ocl.nYW;
                str2 = e.this.ocl.obt;
                if (e.this.nTp.bPg()) {}
                for (i = 1;; i = 0)
                {
                  paramAnonymousView.f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                  if (e.this.ock == null) {
                    break;
                  }
                  e.this.ock.jl(true);
                  AppMethodBeat.o(113265);
                  return;
                }
              }
              paramAnonymousView = new j.b();
              e.this.a(true, paramAnonymousView, false);
              AppMethodBeat.o(113265);
              return;
            }
            if ((paramAnonymousView.getId() == 2131298408) && (e.this.nTp.bPi().EkX))
            {
              AppMethodBeat.o(113265);
              return;
            }
            if (e.this.nTp.bOO())
            {
              if (e.this.ock != null)
              {
                e.this.ock.jl(false);
                AppMethodBeat.o(113265);
              }
            }
            else
            {
              paramAnonymousView = new j.b();
              e.this.a(false, paramAnonymousView, false);
              AppMethodBeat.o(113265);
            }
          }
          else if (paramAnonymousView.getId() == 2131296510)
          {
            if (!TextUtils.isEmpty(e.this.nTp.bPi().EkB))
            {
              com.tencent.mm.plugin.card.d.b.a(e.this.nTt, e.this.nTp.bPi().EkB, 3);
              com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(13), e.this.nTp.bPm(), e.this.nTp.bPn(), "", e.this.nTp.bPi().EkA });
              AppMethodBeat.o(113265);
            }
          }
          else
          {
            if (paramAnonymousView.getId() == 2131297878)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.nTp.bPi().lRv), e.this.nTp.bPn(), e.this.nTp.bPm(), e.this.ocl.obt });
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("KLabel_range_index", e.this.nZx);
              paramAnonymousView.putExtra("Klabel_name_list", e.this.nZy);
              paramAnonymousView.putExtra("Kother_user_name_list", e.this.nZz);
              paramAnonymousView.putExtra("k_sns_label_ui_title", e.this.nTt.getString(2131756983));
              paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
              paramAnonymousView.putExtra("KLabel_is_filter_private", true);
              com.tencent.mm.br.d.b(e.this.nTt, "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
              e.this.nTt.mmSetOnActivityResultCallback(e.this);
              AppMethodBeat.o(113265);
              return;
            }
            if (paramAnonymousView.getId() == 2131297891)
            {
              if (e.this.nTp.bPj().Eig != null)
              {
                localObject = e.this.nTp.bPj().Eig;
                i = ((Integer)paramAnonymousView.getTag()).intValue();
                paramAnonymousView = (yg)((LinkedList)localObject).get(i);
                if (com.tencent.mm.plugin.card.d.b.a(e.this.nTp.bPm(), paramAnonymousView, e.this.ocl.nYW, e.this.ocl.ocr))
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(19), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.title });
                  AppMethodBeat.o(113265);
                  return;
                }
                if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nTt, paramAnonymousView.url, 1);
                  localObject = com.tencent.mm.plugin.report.service.h.wUl;
                  switch (i)
                  {
                  default: 
                    i = 10;
                  }
                }
                for (;;)
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).f(11941, new Object[] { Integer.valueOf(i), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.title });
                  if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.nTp.bPm()))
                  {
                    com.tencent.mm.plugin.card.d.l.VD(e.this.nTp.bPm());
                    com.tencent.mm.plugin.card.d.b.b(e.this.nTt, e.this.nTp.bPi().nVK);
                  }
                  AppMethodBeat.o(113265);
                  return;
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
            else if (paramAnonymousView.getId() == 2131297892)
            {
              if (e.this.nTp.bPj().Eig != null)
              {
                paramAnonymousView = (yg)e.this.nTp.bPj().Eig.get(0);
                if (com.tencent.mm.plugin.card.d.b.a(e.this.nTp.bPm(), paramAnonymousView, e.this.ocl.nYW, e.this.ocl.ocr))
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(19), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.title });
                  AppMethodBeat.o(113265);
                  return;
                }
                if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nTt, paramAnonymousView.url, 1);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(10), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.title });
                  if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.nTp.bPm()))
                  {
                    com.tencent.mm.plugin.card.d.l.VD(e.this.nTp.bPm());
                    com.tencent.mm.plugin.card.d.b.b(e.this.nTt, e.this.nTp.bPi().nVK);
                  }
                }
                AppMethodBeat.o(113265);
              }
            }
            else if ((paramAnonymousView.getId() == 2131297922) || (paramAnonymousView.getId() == 2131297869))
            {
              if (e.this.nTp.bPj().Ein != null) {
                if (e.this.nTp.bPa())
                {
                  if (e.this.nTp.bOO())
                  {
                    if (e.this.ock != null)
                    {
                      e.this.ock.jl(false);
                      AppMethodBeat.o(113265);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new j.b();
                    e.this.a(false, paramAnonymousView, false);
                    AppMethodBeat.o(113265);
                  }
                }
                else
                {
                  if (e.this.nTp.bPb())
                  {
                    paramAnonymousView = new j.b();
                    com.tencent.mm.plugin.card.d.b.a(e.this.nTt, paramAnonymousView.nUh, paramAnonymousView.nUi, false, e.this.nTp);
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = e.this.nTp.bPj().Ein;
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.nTp.bPm(), paramAnonymousView, e.this.ocl.nYW, e.this.ocl.ocr))
                  {
                    com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(20), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.title });
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    localObject = com.tencent.mm.plugin.card.d.l.S(paramAnonymousView.url, paramAnonymousView.Els);
                    com.tencent.mm.plugin.card.d.b.a(e.this.nTt, (String)localObject, 1);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(9), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.nTp.bPm()))
                    {
                      com.tencent.mm.plugin.card.d.l.VD(e.this.nTp.bPm());
                      com.tencent.mm.plugin.card.d.b.b(e.this.nTt, e.this.nTp.bPi().nVK);
                    }
                  }
                  AppMethodBeat.o(113265);
                }
              }
            }
            else
            {
              String str3;
              if ((paramAnonymousView.getId() == 2131297784) || (paramAnonymousView.getId() == 2131297727))
              {
                paramAnonymousView = e.this.nTp.bPi().EkH;
                localObject = com.tencent.mm.plugin.report.service.h.wUl;
                j = e.this.nTp.bPi().lRv;
                str1 = e.this.nTp.bPn();
                str2 = e.this.nTp.bPm();
                k = e.this.ocl.nYW;
                str3 = e.this.ocl.obt;
                if (e.this.nTp.bPg()) {}
                for (i = 1;; i = 0)
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).f(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                  if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                    break;
                  }
                  com.tencent.mm.plugin.card.d.b.a(e.this.nTt, paramAnonymousView.url, 1);
                  AppMethodBeat.o(113265);
                  return;
                }
                localObject = new Intent();
                if ((e.this.nTp instanceof CardInfo)) {
                  ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.this.nTp);
                }
                for (;;)
                {
                  ((Intent)localObject).setClass(e.this.nTt, CardDetailPreference.class);
                  paramAnonymousView = e.this.nTt;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(113265);
                  return;
                  if ((e.this.nTp instanceof ShareCardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.this.nTp);
                  }
                }
              }
              if (paramAnonymousView.getId() == 2131304762)
              {
                if (com.tencent.mm.plugin.card.sharecard.a.b.UN(e.this.nTp.bPn()) <= 1)
                {
                  AppMethodBeat.o(113265);
                  return;
                }
                paramAnonymousView = e.this;
                if (!e.this.obL) {}
                for (;;)
                {
                  paramAnonymousView.obL = bool;
                  e.this.bQT();
                  AppMethodBeat.o(113265);
                  return;
                  bool = false;
                }
              }
              if (paramAnonymousView.getId() == 2131297731)
              {
                if ((e.this.nTp.bPi().EkD != null) && (!TextUtils.isEmpty(e.this.nTp.bPi().EkD.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nTt, e.this.nTp.bPi().EkD.url, 3);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(3), e.this.nTp.bPm(), e.this.nTp.bPn(), "", e.this.nTp.bPi().EkD.text });
                  AppMethodBeat.o(113265);
                }
              }
              else if (paramAnonymousView.getId() == 2131297717)
              {
                if ((e.this.nTp.bPi().EkK != null) && (!bs.isNullOrNil(e.this.nTp.bPi().EkK.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nTt, e.this.nTp.bPi().EkK.url, 1);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(14), e.this.nTp.bPm(), e.this.nTp.bPn(), "", e.this.nTp.bPi().EkK.text });
                  AppMethodBeat.o(113265);
                }
              }
              else if ((paramAnonymousView.getId() == 2131304769) || (paramAnonymousView.getId() == 2131304770))
              {
                if (e.this.nTp.bPi().Eku > 0)
                {
                  if ((e.this.nTw == null) || (e.this.nTw.size() == 0))
                  {
                    ac.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = (rr)e.this.nTw.get(0);
                  com.tencent.mm.plugin.card.d.b.a(e.this.nTt, paramAnonymousView.dmL, paramAnonymousView.doB, paramAnonymousView.hEt);
                  localObject = com.tencent.mm.plugin.report.service.h.wUl;
                  j = e.this.nTp.bPi().lRv;
                  str1 = e.this.nTp.bPn();
                  str2 = e.this.nTp.bPm();
                  k = e.this.ocl.nYW;
                  str3 = e.this.ocl.obt;
                  if (e.this.nTp.bPg()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.h)localObject).f(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(5), e.this.nTp.bPm(), e.this.nTp.bPn(), "", paramAnonymousView.name });
                    AppMethodBeat.o(113265);
                    return;
                  }
                }
              }
              else
              {
                if (paramAnonymousView.getId() == 2131305807)
                {
                  if ((e.this.nTw == null) || (e.this.nTw.size() == 0))
                  {
                    ac.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  localObject = (rr)e.this.nTw.get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.this.nTt.getString(2131756806))))
                  {
                    e.a(e.this);
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (!TextUtils.isEmpty(((rr)localObject).nWj))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.nTt, ((rr)localObject).nWj, 1);
                    com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(4), e.this.nTp.bPm(), e.this.nTp.bPn(), "", ((rr)localObject).name });
                  }
                  AppMethodBeat.o(113265);
                  return;
                }
                if (paramAnonymousView.getId() == 2131305802) {
                  e.a(e.this);
                }
              }
            }
          }
        }
        AppMethodBeat.o(113265);
      }
    };
    this.ocn = new com.tencent.mm.sdk.b.c() {};
    this.nTt = paramMMActivity;
    this.ijA = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.obO != null) {
      this.obO.H(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void Vb(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.nTp instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.nTp);
    }
    for (;;)
    {
      localIntent.setClass(this.nTt, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.ocl.fwc);
      localIntent.putExtra("key_previous_scene", this.ocl.nYW);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.ocl.ocr);
      this.nTt.startActivityForResult(localIntent, 3);
      this.nTt.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.nTp instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.nTp);
      }
    }
  }
  
  private String bQV()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.nZy)) && (!TextUtils.isEmpty(this.nZz)))
    {
      str = this.nZy + "," + com.tencent.mm.plugin.card.d.l.VB(this.nZz);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.nZy))
    {
      str = this.nZy;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.nZz))
    {
      str = com.tencent.mm.plugin.card.d.l.VB(this.nZz);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private void bRQ()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.obJ == null)
    {
      i = 0;
      if (i != 0)
      {
        this.obJ.release();
        this.obJ = null;
        ac.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.nTp.bPi().lRv) });
      }
      if (this.obJ == null)
      {
        ac.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.nTp.bPi().lRv) });
        ac.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.nTp.bPi().lRv) });
        if (!this.nTp.bOO()) {
          break label423;
        }
        this.obJ = new com.tencent.mm.plugin.card.ui.a.h(this.nTt);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.nTp.bPi().lRv) });
      this.obJ.a(this.nTp, this.ocl);
      AppMethodBeat.o(113279);
      return;
      if (this.nTp.bOO())
      {
        if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nTp.bOP())
      {
        if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nTp.bOS())
      {
        if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nTp.bOQ())
      {
        if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nTp.bOR())
      {
        if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nTp.bOT())
      {
        if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.obJ instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.nTp.bPi().lRv)
      {
      default: 
        this.obJ = new com.tencent.mm.plugin.card.ui.a.a(this.nTt);
        break;
      case 0: 
        this.obJ = new com.tencent.mm.plugin.card.ui.a.c(this.nTt);
        break;
      case 10: 
        this.obJ = new com.tencent.mm.plugin.card.ui.a.e(this.nTt);
        break;
      case 11: 
        this.obJ = new com.tencent.mm.plugin.card.ui.a.b(this.nTt);
        break;
      case 20: 
        this.obJ = new com.tencent.mm.plugin.card.ui.a.f(this.nTt);
        break;
      case 30: 
        this.obJ = new com.tencent.mm.plugin.card.ui.a.d(this.nTt);
      }
    }
  }
  
  private void bRR()
  {
    AppMethodBeat.i(113285);
    if ((this.nTp.bPi().EkU != null) && (this.nTp.bPi().EkU.Ewc))
    {
      this.obQ = new com.tencent.mm.plugin.card.ui.view.m();
      am.bQy().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.nTp.bPi().lRv == 10)
    {
      this.obQ = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.obQ = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void bRS()
  {
    AppMethodBeat.i(113286);
    if (this.dhO)
    {
      ac.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label197:
    Object localObject3;
    int i;
    if ((this.nTp.bON()) && (this.nTp.bOP()))
    {
      this.ijA.findViewById(2131297787).setBackgroundColor(this.nTt.getResources().getColor(2131101179));
      this.nTt.setActionbarColor(this.nTt.getResources().getColor(2131101179));
      localObject2 = this.ijA.findViewById(2131299042);
      localObject1 = this.ijA.findViewById(2131300735);
      localView = this.ijA.findViewById(2131299039);
      if ((!this.nTp.bON()) || (!this.obJ.bSX())) {
        break label1267;
      }
      if (!this.nTp.bOQ()) {
        break label1133;
      }
      ((View)localObject2).setBackgroundResource(2131231515);
      this.ijA.findViewById(2131300307).setBackgroundResource(2131231456);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.nTp.bOT())
      {
        localObject3 = (TextView)this.ijA.findViewById(2131297477);
        localObject4 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.Yo(2131231510));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.nTp.bOO()) && (this.obJ.bSV()) && (this.obL))
      {
        localObject4 = this.ijA.findViewById(2131304758);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.nTp.bON()) && (this.obJ.bSX()))
      {
        localObject4 = this.ijA.findViewById(2131300307);
        ((Rect)localObject3).left = this.nTt.getResources().getDimensionPixelOffset(2131165480);
        ((Rect)localObject3).right = this.nTt.getResources().getDimensionPixelOffset(2131165480);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.nTp.bOR())
        {
          localObject3 = this.ijA.findViewById(2131300308);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.nTt.getResources().getDimensionPixelSize(2131165568);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.obJ.bSX()) && (!this.obJ.bSV())) {
        break label1491;
      }
      if ((this.obO != null) && (((this.nTp.bON()) && (this.nTp.bOQ())) || (this.nTp.bOO()))) {
        this.obO.Ah(0);
      }
      label650:
      if ((this.obO != null) && (this.nTp.bON()) && (this.nTp.bOP()))
      {
        i = this.nTt.getResources().getDimensionPixelOffset(2131165983);
        localObject3 = com.tencent.mm.plugin.card.d.l.eQ(com.tencent.mm.plugin.card.d.l.Vy(this.nTp.bPi().hiu), i);
        this.obO.a((ShapeDrawable)localObject3);
      }
      if ((this.nTp.bON()) && (this.nTp.bOP()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.nTp.bPi().EkA)) {
          break label1576;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label816:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.nTt.getResources().getDimensionPixelSize(2131165500);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.nTp.bOP()) {
          break label1591;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.nTt.getResources().getDimensionPixelSize(2131165489);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.nTt.getResources().getDimensionPixelSize(2131165490);
        i = this.nTt.getResources().getDimensionPixelSize(2131165483);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label932:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.nTp.bOP()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.nTt.getResources().getDimensionPixelSize(2131165483);
        }
        if (TextUtils.isEmpty(this.nTp.bPi().EkA)) {
          break label1620;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.nTp.bPi().EkA))
      {
        localView = findViewById(2131296509);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.ijA.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.d.l.Vy(this.nTp.bPi().hiu);
      this.ijA.findViewById(2131297787).setBackgroundColor(i);
      this.nTt.setActionbarColor(i);
      break;
      label1133:
      if (this.nTp.bOP())
      {
        this.ijA.findViewById(2131300307).setBackgroundResource(0);
        localView.setBackgroundColor(this.nTt.getResources().getColor(2131101179));
        break label197;
      }
      if (this.nTp.bOR())
      {
        ((View)localObject2).setBackgroundResource(2131231515);
        this.ijA.findViewById(2131300307).setBackgroundResource(2131231456);
        localView.setBackgroundResource(0);
        break label197;
      }
      if ((this.nTp.bOS()) || (!this.nTp.bOT())) {
        break label197;
      }
      localView.setBackgroundColor(this.nTt.getResources().getColor(2131101179));
      break label197;
      label1267:
      if (this.nTp.bOO())
      {
        if ((this.obJ.bSV()) && (this.obL))
        {
          ((View)localObject2).setBackgroundResource(2131231515);
          localView.setBackgroundResource(0);
          break label197;
        }
        if ((this.obJ.bSV()) && (!this.obL))
        {
          ((View)localObject2).setBackgroundResource(2131231511);
          localView.setBackgroundResource(0);
          break label197;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.obJ.bSe())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.nTp.bOQ())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.obJ.bSe())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.nTp.bOR())
      {
        ((View)localObject2).setBackgroundResource(2131231519);
        localView.setBackgroundResource(0);
        break label197;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.nTt.getResources().getColor(2131101179));
      break label197;
      label1491:
      if ((this.obO == null) || (((!this.nTp.bON()) || (!this.nTp.bOQ())) && (!this.nTp.bOO()))) {
        break label650;
      }
      if (this.obJ.bSe())
      {
        this.obO.Ah(2131231516);
        break label650;
      }
      this.obO.Ah(2131231514);
      break label650;
      label1576:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label816;
      label1591:
      i = this.nTt.getResources().getDimensionPixelSize(2131165198);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label932;
      label1620:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void bRT()
  {
    AppMethodBeat.i(113290);
    if (!this.obJ.bSZ())
    {
      ac.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.nTu.clear();
    this.nTu.addAll(this.oce.bPJ());
    this.obR.setData(this.nTu);
    this.obR.ogL = this.nTp.bOT();
    this.obR.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void bRU()
  {
    AppMethodBeat.i(113291);
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (bRV()) {
      bRX();
    }
    if (this.obO == null) {
      bRW();
    }
    if (this.obO != null)
    {
      if (this.nTp.bOR()) {
        ((com.tencent.mm.plugin.card.widget.f)this.obO).nTw = this.nTw;
      }
      this.obO.d(this.nTp);
    }
    AppMethodBeat.o(113291);
  }
  
  private boolean bRV()
  {
    AppMethodBeat.i(113292);
    if (this.obO == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.nTp.bOP())
    {
      if ((this.obO instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nTp.bOS())
    {
      if ((this.obO instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nTp.bOQ())
    {
      if ((this.obO instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nTp.bOR())
    {
      if ((this.obO instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nTp.bOT())
    {
      if ((this.obO instanceof com.tencent.mm.plugin.card.widget.d))
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
  
  private void bRW()
  {
    AppMethodBeat.i(113293);
    if (this.nTp.bOP()) {
      this.obO = new com.tencent.mm.plugin.card.widget.e(this.nTt);
    }
    for (;;)
    {
      this.obO.i(this.nTp);
      View localView = this.obO.ja();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.n.a(localView, this.obP);
      }
      this.obP.invalidate();
      this.obO.setOnClickListener(this.jax);
      H(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.nTp.bOS()) {
        this.obO = new com.tencent.mm.plugin.card.widget.c(this.nTt);
      } else if (this.nTp.bOQ()) {
        this.obO = new com.tencent.mm.plugin.card.widget.b(this.nTt);
      } else if (this.nTp.bOR()) {
        this.obO = new com.tencent.mm.plugin.card.widget.f(this.nTt);
      } else if (this.nTp.bOT()) {
        this.obO = new com.tencent.mm.plugin.card.widget.d(this.nTt);
      } else {
        this.obO = new com.tencent.mm.plugin.card.widget.b(this.nTt);
      }
    }
  }
  
  private void bRX()
  {
    AppMethodBeat.i(113294);
    View localView = this.obO.ja();
    if (localView != null) {
      this.obP.removeView(localView);
    }
    this.obP.removeAllViews();
    this.obP.invalidate();
    this.obO.release();
    this.obO = null;
    AppMethodBeat.o(113294);
  }
  
  private void bRY()
  {
    AppMethodBeat.i(113295);
    if ((this.obO != null) && ((this.obO instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.obO).bRY();
    }
    AppMethodBeat.o(113295);
  }
  
  private void bRZ()
  {
    AppMethodBeat.i(113296);
    qy localqy = this.nTp.bPj();
    this.nTp.a(localqy);
    com.tencent.mm.plugin.card.d.l.h(this.nTp);
    AppMethodBeat.o(113296);
  }
  
  private void bSa()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.och.clear();
    this.ocj.clear();
    if (this.nTp.bOW())
    {
      this.ocj.add(getString(2131757029));
      this.och.put(Integer.valueOf(0), "menu_func_share_friend");
      this.ocj.add(getString(2131757028));
      this.och.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.nTp.bPj().Eij))
    {
      this.ocj.add(getString(2131756938));
      this.och.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    zS(j);
    if (this.ocj.size() > 0) {
      this.nTt.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void bSb()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.och.clear();
    this.ocj.clear();
    int i = j;
    if (this.nTp.bON())
    {
      i = j;
      if (this.nTp.bOV())
      {
        if (bs.isNullOrNil(this.nTp.bPi().Elb)) {
          break label235;
        }
        this.ocj.add(this.nTp.bPi().Elb);
        this.och.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.nTp.bPj().Eij))
    {
      this.ocj.add(getString(2131756938));
      this.och.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.nTp.bON())
    {
      this.ocj.add(getString(2131755707));
      this.och.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      zS(i);
      if (this.ocj.size() > 0) {
        this.nTt.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.nTp.bOT())
      {
        this.ocj.add(getString(2131756937));
        break;
      }
      this.ocj.add(getString(2131756936));
      break;
      i = j;
      if (this.nTp.bOO())
      {
        String str1 = com.tencent.mm.model.u.axw();
        String str2 = this.nTp.bPo();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.ocj.add(getString(2131755707));
          this.och.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          ac.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void bSc()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.och.clear();
    this.ocj.clear();
    if (!TextUtils.isEmpty(this.nTp.bPj().Eij))
    {
      this.ocj.add(getString(2131756938));
      this.och.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    zS(i);
    if (this.ocj.size() > 0) {
      this.nTt.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(113289);
    if (!this.obJ.bSU())
    {
      this.nTt.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.nTt.setMMTitle(this.oce.getTitle());
    AppMethodBeat.o(113289);
  }
  
  private void zS(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.nTp.bPj().Eil;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.oci.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      bc localbc = (bc)localLinkedList.get(paramInt);
      j = i;
      if (!bs.isNullOrNil(localbc.text))
      {
        j = i;
        if (!bs.isNullOrNil(localbc.url))
        {
          this.ocj.add(localbc.text);
          this.och.put(Integer.valueOf(i), localbc.text);
          this.oci.put(localbc.text, localbc.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(113300);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, a parama, ArrayList<rr> paramArrayList)
  {
    this.nTp = paramb;
    this.ocl = parama;
    this.nTw = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.nTp.bPj().Ein;
      if (this.nTp.bPb())
      {
        com.tencent.mm.plugin.card.d.b.a(this.nTt, paramb.nUh, paramb.nUi, paramBoolean2, this.nTp);
        com.tencent.mm.plugin.report.service.h.wUl.f(11941, new Object[] { Integer.valueOf(17), this.nTp.bPm(), this.nTp.bPn(), "", this.nTp.bPj().Ein.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((yg)localObject1).Ekb)) && (!TextUtils.isEmpty(((yg)localObject1).Ekc)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.nTp.bPm(), (yg)localObject1, this.ocl.nYW, this.ocl.ocr);
        localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
        str1 = this.nTp.bPm();
        str2 = this.nTp.bPn();
        if (((yg)localObject1).title != null) {}
        for (paramb = ((yg)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((yg)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.S(((yg)localObject1).url, ((yg)localObject1).Els);
        com.tencent.mm.plugin.card.d.b.a(this.nTt, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
        str1 = this.nTp.bPm();
        str2 = this.nTp.bPn();
        if (((yg)localObject1).title != null) {}
        for (paramb = ((yg)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
      j = this.nTp.bPi().lRv;
      localObject2 = this.nTp.bPn();
      str1 = this.nTp.bPm();
      k = this.ocl.nYW;
      str2 = this.ocl.obt;
      if (this.nTp.bPg()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        Vb(paramb.nUe);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
    int k = this.nTp.bPi().lRv;
    Object localObject2 = this.nTp.bPn();
    String str1 = this.nTp.bPm();
    int m = this.ocl.nYW;
    String str2 = this.ocl.obt;
    if (this.nTp.bPg()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      Vb(paramb.nUe);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    ac.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.ocx = b.ocv;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(2131756842);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.ocm.sendMessage(localMessage);
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
      this.nTp = paramb;
      if (this.ock != null) {
        this.ock.b(paramb);
      }
      bQT();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113284);
    ac.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.ocx = b.ocu;
    localc.ocy = paramc;
    localMessage.obj = localc;
    this.ocm.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void bPN()
  {
    AppMethodBeat.i(113283);
    ac.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.ocx = b.oct;
    localMessage.obj = localc;
    this.ocm.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final void bQT()
  {
    AppMethodBeat.i(113280);
    if (this.nTp == null)
    {
      ac.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.ock != null) {
        this.ock.bRD();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.nTp.bPi() == null)
    {
      ac.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.ock != null) {
        this.ock.bRD();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.nTp.bPj() == null)
    {
      ac.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.ock != null) {
        this.ock.bRD();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.nTp.bOU())
    {
      ac.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.nTp.bPi().lRv) });
      if (!TextUtils.isEmpty(this.nTp.bPi().Ekv))
      {
        com.tencent.mm.plugin.card.d.b.a(this.nTt, this.nTp.bPi().Ekv, 0);
        if (this.ock != null)
        {
          this.ock.bRD();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.nTt, getString(2131756947), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.this.ock != null) {
              e.this.ock.bRD();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    ac.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    ac.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.nTp.bPi().EkQ);
    this.oce.a(this.nTp, this.nTw, this.ocl.fwc);
    bRQ();
    this.obJ.bTm();
    ac.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    bRU();
    if (this.obJ.bSV())
    {
      ac.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.obK.update();
      if (!this.obJ.bSM()) {
        break label1156;
      }
      if (this.ocb == null)
      {
        this.ocb = new com.tencent.mm.plugin.card.ui.view.b();
        this.ocb.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.ocb.update();
      label436:
      this.nTt.showOptionMenu(this.obJ.bSQ());
      if (this.obJ.bSR()) {
        bSa();
      }
      if (this.obJ.bSS()) {
        bSb();
      }
      if (this.obJ.bST()) {
        bSc();
      }
      bRY();
      H(this.obJ.bSO(), this.obJ.bSP());
      if ((this.nTp.bOP()) || (!this.obJ.bSX())) {
        break label1181;
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.obM.update();
      label565:
      if (this.obO != null) {
        this.obO.jr(this.obJ.bSe());
      }
      bRS();
      if (!this.obJ.bTc()) {
        break label1278;
      }
      if (this.obT == null)
      {
        this.obT = new com.tencent.mm.plugin.card.ui.view.y();
        this.obT.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.obT.update();
      label647:
      if (!this.obJ.bTl()) {
        break label1303;
      }
      if (this.obS == null)
      {
        this.obS = new com.tencent.mm.plugin.card.ui.view.c();
        this.obS.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.obS.update();
      label700:
      if (!this.obJ.bTd()) {
        break label1328;
      }
      if (this.obU == null)
      {
        this.obU = new k();
        this.obU.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.obU.update();
      label753:
      if (!this.obJ.bTe()) {
        break label1353;
      }
      if (this.obV == null)
      {
        this.obV = new w();
        this.obV.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.obV.update();
      label806:
      if (!this.obJ.bTf()) {
        break label1378;
      }
      if (this.obW == null)
      {
        this.obW = new com.tencent.mm.plugin.card.ui.view.l();
        this.obW.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.obW.update();
      label859:
      if (!this.obJ.bTg()) {
        break label1403;
      }
      if (this.obX == null)
      {
        this.obX = new z();
        this.obX.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.obX.update();
      label912:
      if (!this.obJ.bTi()) {
        break label1428;
      }
      if (this.obY == null)
      {
        this.obY = new com.tencent.mm.plugin.card.ui.view.e();
        this.obY.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.obY.update();
      label965:
      if (!this.obJ.bTh()) {
        break label1453;
      }
      if (this.obZ == null)
      {
        this.obZ = new com.tencent.mm.plugin.card.ui.view.u();
        this.obZ.a(this);
      }
      ac.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.obZ.update();
      label1018:
      bRT();
      if (!this.obJ.bTa()) {
        break label1530;
      }
      bRZ();
      if (!this.obJ.bTb()) {
        break label1513;
      }
      if (this.obQ != null) {
        break label1478;
      }
      bRR();
      this.obQ.a(this);
      this.obQ.update();
      label1076:
      if (this.obO != null) {
        this.obO.jq(true);
      }
      label1093:
      if (!this.obJ.bTj()) {
        break label1572;
      }
      ac.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.oca.update();
    }
    for (;;)
    {
      this.occ.nTp = this.nTp;
      AppMethodBeat.o(113280);
      return;
      ac.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.obK.bTM();
      break;
      label1156:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.ocb == null) {
        break label436;
      }
      this.ocb.bTM();
      break label436;
      label1181:
      if ((this.nTp.bOP()) && (this.obJ.bSX()))
      {
        ac.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.obN.update();
        break label565;
      }
      if (this.obJ.bSY())
      {
        ac.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.obN.update();
        break label565;
      }
      ac.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.obN.bTM();
      this.obM.bTM();
      break label565;
      label1278:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.obT == null) {
        break label647;
      }
      this.obT.bTM();
      break label647;
      label1303:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.obS == null) {
        break label700;
      }
      this.obS.bTM();
      break label700;
      label1328:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.obU == null) {
        break label753;
      }
      this.obU.bTM();
      break label753;
      label1353:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.obV == null) {
        break label806;
      }
      this.obV.bTM();
      break label806;
      label1378:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.obW == null) {
        break label859;
      }
      this.obW.bTM();
      break label859;
      label1403:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.obX == null) {
        break label912;
      }
      this.obX.bTM();
      break label912;
      label1428:
      ac.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.obY == null) {
        break label965;
      }
      this.obY.bTM();
      break label965;
      label1453:
      ac.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.obZ == null) {
        break label1018;
      }
      this.obZ.bTM();
      break label1018;
      label1478:
      if (!this.obQ.f(this.nTp)) {
        break label1076;
      }
      this.obQ.b(this.nTp);
      this.obQ.update();
      break label1076;
      label1513:
      if (this.obQ == null) {
        break label1076;
      }
      this.obQ.bTR();
      break label1076;
      label1530:
      ac.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.obQ != null) {
        this.obQ.bTR();
      }
      if (this.obO == null) {
        break label1093;
      }
      this.obO.jq(false);
      break label1093;
      label1572:
      ac.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.oca.bTM();
    }
  }
  
  public final com.tencent.mm.plugin.card.base.b bRG()
  {
    return this.nTp;
  }
  
  public final boolean bRH()
  {
    return this.obL;
  }
  
  public final void bRI()
  {
    this.obL = false;
  }
  
  public final MMActivity bRJ()
  {
    return this.nTt;
  }
  
  public final View.OnClickListener bRK()
  {
    return this.jax;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g bRL()
  {
    return this.obJ;
  }
  
  public final d bRM()
  {
    return this.ock;
  }
  
  public final a bRN()
  {
    return this.ocl;
  }
  
  public final com.tencent.mm.plugin.card.b.f bRO()
  {
    return this.oce;
  }
  
  public final j bRP()
  {
    return this.occ;
  }
  
  public final int bSd()
  {
    AppMethodBeat.i(113304);
    if (this.oce == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.oce.bPL())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean bSe()
  {
    AppMethodBeat.i(113305);
    if (this.obJ == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.obJ.bSe();
    AppMethodBeat.o(113305);
    return bool;
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
        this.ocf = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.ocf;
        if ((this.nTp == null) || (this.nTp.bPi() == null))
        {
          ac.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.nTp.bPk().FHx)) && (!this.nTp.bOT())) {
            localStringBuilder.append(this.nTp.bPk().FHx);
          }
        }
        for (;;)
        {
          String str = this.nTp.bPi().title + "\n" + this.nTp.bPi().nVK;
          ab.a.DrY.a(this.nTt.getController(), localStringBuilder.toString(), this.nTp.bPi().hhs, str, true, this.nTt.getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(113270);
              if (paramAnonymousBoolean)
              {
                e.this.ocg = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.this.ock != null) {
                    e.this.ock.Va(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.nTp.bPi().lRv), e.this.nTp.bPn(), e.this.nTp.bPm(), e.this.ocf });
                  com.tencent.mm.ui.base.h.cg(e.this.nTt, e.this.nTt.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 1)
                {
                  paramAnonymousString = e.this;
                  paramAnonymousString.nTp.bPk().FHx = (paramAnonymousString.getString(2131756994) + paramAnonymousString.oce.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.nTp, paramAnonymousString.ocf, paramAnonymousString.ocl.obv, 2);
                  com.tencent.mm.plugin.card.d.l.eW(paramAnonymousString.ocg, paramAnonymousString.ocf);
                  com.tencent.mm.ui.base.h.cg(e.this.nTt, e.this.nTt.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 4)
                {
                  paramAnonymousString = e.this;
                  if (TextUtils.isEmpty(paramAnonymousString.nTp.bPo())) {
                    paramAnonymousString.nTp.Ut(com.tencent.mm.model.u.axw());
                  }
                  paramAnonymousString.nTp.bPk().FHx = (paramAnonymousString.getString(2131756955) + paramAnonymousString.oce.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.nTp, paramAnonymousString.ocf, paramAnonymousString.ocl.obv, 23);
                  com.tencent.mm.plugin.card.d.l.eW(paramAnonymousString.ocg, paramAnonymousString.ocf);
                  com.tencent.mm.plugin.report.service.h.wUl.f(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.this.ocl.fwc), Integer.valueOf(e.this.nTp.bPi().lRv), e.this.nTp.bPn(), e.this.nTp.bPm(), e.this.ocf });
                  com.tencent.mm.ui.base.h.cg(e.this.nTt, e.this.nTt.getResources().getString(2131756873));
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
            localStringBuilder.append(getString(2131756994) + this.oce.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(2131756955) + this.oce.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.nZx = paramIntent.getIntExtra("Ktag_range_index", 0);
        ac.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.nZx) });
        if (this.nZx >= 2)
        {
          this.nZy = paramIntent.getStringExtra("Klabel_name_list");
          this.nZz = paramIntent.getStringExtra("Kother_user_name_list");
          ac.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.nZx), this.nZy });
          if ((TextUtils.isEmpty(this.nZy)) && (TextUtils.isEmpty(this.nZz)))
          {
            ac.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.nZy.split(","));
          this.nZB = com.tencent.mm.plugin.card.d.l.cG(paramIntent);
          this.nZA = com.tencent.mm.plugin.card.d.l.cF(paramIntent);
          if ((this.nZz != null) && (this.nZz.length() > 0))
          {
            paramIntent = Arrays.asList(this.nZz.split(","));
            this.nZA.addAll(paramIntent);
          }
          if (this.nZB != null) {
            ac.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.nZB.size());
          }
          if (this.nZA != null)
          {
            ac.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.nZA.size());
            paramIntent = this.nZA.iterator();
            while (paramIntent.hasNext()) {
              ac.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.nZx == 2)
          {
            this.oca.Vo(this.nTt.getString(2131756982, new Object[] { bQV() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.nZx == 3)
          {
            this.oca.Vo(this.nTt.getString(2131756981, new Object[] { bQV() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.oca.Vo(this.nTt.getString(2131756980));
          AppMethodBeat.o(113301);
          return;
        }
        this.oca.Vo(this.nTt.getString(2131756980));
        AppMethodBeat.o(113301);
        return;
        if (this.ock != null) {
          this.ock.bRF();
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113281);
    ac.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.ocx = b.ocs;
    localc.ocy = paramc;
    localMessage.obj = localc;
    this.ocm.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.ijA.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.nTt.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public static final class a
  {
    public int fwc = 3;
    public String nTb = "";
    public boolean nUB = false;
    public int nYW = -1;
    public String oaZ = "";
    public String oba = "";
    public String obt = "";
    public String obu = "";
    public String obv = "";
    public int ocr = 0;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(113274);
      ocs = new b("onGetCodeSuccess", 0);
      oct = new b("onShowTimeExpired", 1);
      ocu = new b("onReceiveCodeUnavailable", 2);
      ocv = new b("onGetCodeFail", 3);
      ocw = new b[] { ocs, oct, ocu, ocv };
      AppMethodBeat.o(113274);
    }
    
    private b() {}
  }
  
  static final class c
  {
    int errCode;
    String errMsg;
    e.b ocx;
    com.tencent.mm.plugin.card.d.c ocy;
  }
  
  public static abstract interface d
  {
    public abstract void Va(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void bRA();
    
    public abstract void bRB();
    
    public abstract void bRC();
    
    public abstract void bRD();
    
    public abstract void bRE();
    
    public abstract void bRF();
    
    public abstract void bRz();
    
    public abstract void jl(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */