package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.d;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.ees;
import com.tencent.mm.protocal.protobuf.eet;
import com.tencent.mm.protocal.protobuf.epy;
import com.tencent.mm.protocal.protobuf.epz;
import com.tencent.mm.protocal.protobuf.eqk;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int nZt = 2131296819;
  private String appId;
  private int iDM;
  private e jCK;
  private dyd nZA;
  private hv nZB;
  private LinkedList<Integer> nZC;
  private String nZD;
  private String nZE;
  private String nZF;
  private int nZG;
  private com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a nZH;
  private q nZI;
  private PhoneItem nZJ;
  private AppBrandIDCardUI.a nZf;
  public MMFragment nZu;
  private String nZv;
  private String nZw;
  private int nZx;
  private String nZy;
  private String nZz;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.nZf = new AppBrandIDCardUI.a()
    {
      public final void a(hu paramAnonymoushu)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
        Log.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new d.a();
        ((d.a)localObject).iLN = new due();
        ((d.a)localObject).iLO = new duf();
        ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((d.a)localObject).funcId = 1762;
        ((d.a)localObject).iLP = 0;
        ((d.a)localObject).respCmdId = 0;
        localObject = ((d.a)localObject).aXF();
        due localdue = (due)((d)localObject).iLK.iLR;
        localdue.dNI = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdue.MNJ = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdue.MVO = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localdue.KLH = paramAnonymoushu.KLH;
        localdue.dDj = paramAnonymoushu.dDj;
        localdue.dHx = AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx;
        if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).nzy)) {
          localdue.MVP = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).dSf);
        }
        IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, d paramAnonymous2d)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2d.iLL.iLR == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2d.iLL.iLR });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755496), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (duf)paramAnonymous2d.iLL.iLR;
            if (paramAnonymous2String.MVQ != null)
            {
              Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.MVQ.dOK) });
              if (paramAnonymous2String.MVQ.dOK == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.MVR);
                Log.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.MVR });
                AppMethodBeat.o(48926);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755502));
              AppMethodBeat.o(48926);
              return;
            }
            Log.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755502));
            AppMethodBeat.o(48926);
          }
        });
        AppMethodBeat.o(48937);
      }
      
      public final void a(String paramAnonymousString, hu paramAnonymoushu)
      {
        AppMethodBeat.i(48938);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          Log.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
          AppMethodBeat.o(48938);
          return;
        }
        Log.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        Object localObject = new d.a();
        ((d.a)localObject).iLN = new epy();
        ((d.a)localObject).iLO = new epz();
        ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((d.a)localObject).funcId = 1721;
        ((d.a)localObject).iLP = 0;
        ((d.a)localObject).respCmdId = 0;
        localObject = ((d.a)localObject).aXF();
        epy localepy = (epy)((d)localObject).iLK.iLR;
        localepy.dNI = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localepy.MNJ = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localepy.MVO = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localepy.KLH = paramAnonymoushu.KLH;
        localepy.dHx = AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx;
        localepy.IaW = paramAnonymousString;
        localepy.MVR = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        localepy.dDj = paramAnonymoushu.dDj;
        if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).nzy)) {
          localepy.MVP = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).dSf);
        }
        IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, d paramAnonymous2d)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2d.iLL.iLR == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2d.iLL.iLR });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755496), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (epz)paramAnonymous2d.iLL.iLR;
            if (paramAnonymous2String.MVQ != null)
            {
              Log.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.MVQ.dOK), Util.nullAsNil(paramAnonymous2String.MVQ.dOL) });
              com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
              if (paramAnonymous2String.MVQ.dOK == 0)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
                Log.i("MicroMsg.AppBrandIDCardUI", "verify success");
                Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.LpC });
                if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2d = r.nzC;
                  r.b(AppBrandIDCardUI.k(AppBrandIDCardUI.this));
                }
                paramAnonymous2d = new Intent();
                paramAnonymous2d.putExtra("intent_err_code", paramAnonymous2String.MVQ.dOK);
                paramAnonymous2d.putExtra("intent_auth_token", paramAnonymous2String.LpC);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2d);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.MVQ.dOK == 40013)
              {
                AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755501));
                AppMethodBeat.o(48927);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755500));
              AppMethodBeat.o(48927);
              return;
            }
            Log.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            AppMethodBeat.o(48927);
          }
        });
        AppMethodBeat.o(48938);
      }
      
      public final void aft(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        Log.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void afu(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        Log.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void afv(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        Log.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void bXR()
      {
        AppMethodBeat.i(48929);
        Object localObject = new d.a();
        ((d.a)localObject).iLN = new dyc();
        ((d.a)localObject).iLO = new dyd();
        ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((d.a)localObject).funcId = 1774;
        ((d.a)localObject).iLP = 0;
        ((d.a)localObject).respCmdId = 0;
        localObject = ((d.a)localObject).aXF();
        dyc localdyc = (dyc)((d)localObject).iLK.iLR;
        localdyc.dNI = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdyc.MNJ = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdyc.MNK = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, d paramAnonymous2d)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2d.iLL.iLR == null))
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2d.iLL.iLR });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (dyd)paramAnonymous2d.iLL.iLR;
            if (paramAnonymous2String.MVQ == null)
            {
              Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.MVQ.dOK) });
            Log.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.MXG) });
            switch (paramAnonymous2String.MXG)
            {
            default: 
              Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.MVQ.dOK != 0)
                {
                  Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2d = new Intent();
                  paramAnonymous2d.putExtra("intent_err_code", paramAnonymous2String.MVQ.dOK);
                  paramAnonymous2d.putExtra("intent_err_msg", paramAnonymous2String.MVQ.dOL);
                  AppBrandIDCardUI.this.setResult(1, paramAnonymous2d);
                  AppBrandIDCardUI.this.finish();
                  AppMethodBeat.o(48922);
                  return;
                }
                AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous2String);
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 0)
                {
                  AppBrandIDCardUI.f(AppBrandIDCardUI.this);
                  AppMethodBeat.o(48922);
                  return;
                }
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1)
                {
                  AppBrandIDCardUI.g(AppBrandIDCardUI.this);
                  AppMethodBeat.o(48922);
                  return;
                }
              } while (AppBrandIDCardUI.e(AppBrandIDCardUI.this) != 2);
              AppBrandIDCardUI.h(AppBrandIDCardUI.this);
              AppMethodBeat.o(48922);
              return;
            }
            Log.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.MVQ.dOK), paramAnonymous2String.MVQ.dOL });
            paramAnonymous2d = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.MVQ.dOK;
            String str = paramAnonymous2String.MVQ.dOL;
            com.tencent.mm.ui.base.h.a(paramAnonymous2d.nZK, false, paramAnonymous2String.MXH.desc, paramAnonymous2String.MXH.title, paramAnonymous2d.nZK.getString(2131755497), "", new AppBrandIDCardUI.1.2(paramAnonymous2d, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2d));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void bXS()
      {
        AppMethodBeat.i(48935);
        Log.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
        if (AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN == null)
        {
          Log.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN.dNI);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN.dmc);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN.Mju);
          localJSONObject.put("package", AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN.NnP);
          localJSONObject.put("signType", AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN.qcK);
          localJSONObject.put("paySign", AppBrandIDCardUI.j(AppBrandIDCardUI.this).MXN.MiN);
          com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
          AppBrandJsApiPayService.mlD.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.d()
          {
            public final void p(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
                Object localObject = new d.a();
                ((d.a)localObject).iLN = new ees();
                ((d.a)localObject).iLO = new eet();
                ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((d.a)localObject).funcId = 1721;
                ((d.a)localObject).iLP = 0;
                ((d.a)localObject).respCmdId = 0;
                localObject = ((d.a)localObject).aXF();
                ees localees = (ees)((d)localObject).iLK.iLR;
                localees.dNI = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localees.MNJ = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localees.MVO = paramAnonymous2String;
                localees.dHx = AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx;
                if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.k(AppBrandIDCardUI.this).nzy)) {
                  localees.MVP = Util.nullAsNil(AppBrandIDCardUI.k(AppBrandIDCardUI.this).dSf);
                }
                if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                  AppBrandIDCardUI.d(AppBrandIDCardUI.this).show();
                }
                IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
                {
                  public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, d paramAnonymous3d)
                  {
                    AppMethodBeat.i(48924);
                    if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                      AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (paramAnonymous3d.iLL.iLR == null))
                    {
                      Log.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, paramAnonymous3d.iLL.iLR });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (eet)paramAnonymous3d.iLL.iLR;
                    if (paramAnonymous3String.MVQ == null)
                    {
                      Log.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755496), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    Log.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.KLv) });
                    switch (paramAnonymous3String.KLv)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      Log.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.LpC });
                      com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
                      if (((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2)) && (AppBrandIDCardUI.k(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3d = r.nzC;
                        r.b(AppBrandIDCardUI.k(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3d = new Intent();
                      paramAnonymous3d.putExtra("intent_err_code", paramAnonymous3String.MVQ.dOK);
                      paramAnonymous3d.putExtra("intent_auth_token", paramAnonymous3String.LpC);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3d);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.NeP);
                      AppBrandIDCardUI.l(AppBrandIDCardUI.this);
                    }
                  }
                });
              }
              for (;;)
              {
                Log.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                AppMethodBeat.o(48925);
                return;
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) || (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 2))
                {
                  AppBrandIDCardUI.this.setResult(0);
                  AppBrandIDCardUI.this.finish();
                }
              }
            }
          });
          AppMethodBeat.o(48935);
          return;
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
          AppMethodBeat.o(48935);
        }
      }
      
      public final void bXT()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.h.CyF.a(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.j(AppBrandIDCardUI.this).dHx });
        AppMethodBeat.o(48936);
      }
      
      public final dyd bXU()
      {
        AppMethodBeat.i(48939);
        dyd localdyd = AppBrandIDCardUI.j(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localdyd;
      }
      
      public final hv bXV()
      {
        AppMethodBeat.i(48940);
        hv localhv = AppBrandIDCardUI.o(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localhv;
      }
      
      public final void back()
      {
        AppMethodBeat.i(48931);
        AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48931);
      }
      
      public final void onSwipeBack()
      {
        AppMethodBeat.i(48930);
        AppBrandIDCardUI.this.onSwipeBack();
        AppMethodBeat.o(48930);
      }
    };
    AppMethodBeat.o(48952);
  }
  
  private static LinkedList<Integer> T(Bundle paramBundle)
  {
    AppMethodBeat.i(48960);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      Log.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
      paramBundle = new JSONArray(paramBundle);
      int i = 0;
      while (i < paramBundle.length())
      {
        localLinkedList.add(Integer.valueOf(paramBundle.optInt(i)));
        i += 1;
      }
      AppMethodBeat.o(48960);
      return localLinkedList;
    }
    catch (JSONException paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(48960);
    }
    return null;
  }
  
  private void bXQ()
  {
    AppMethodBeat.i(48961);
    Log.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.nZu = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.nZu).nZf = this.nZf;
    getSupportFragmentManager().beginTransaction().b(nZt, this.nZu).commitAllowingStateLoss();
    AppMethodBeat.o(48961);
  }
  
  private void back()
  {
    AppMethodBeat.i(48956);
    if (((this.nZu instanceof AppBrandIDCardVerifyPwdFrag)) && (this.nZG == 0))
    {
      bXQ();
      AppMethodBeat.o(48956);
      return;
    }
    if (((this.nZG != 1) && (this.nZG != 2)) || (this.jCK == null) || (!this.jCK.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  private void zs(int paramInt)
  {
    AppMethodBeat.i(227715);
    com.tencent.mm.plugin.report.service.h.CyF.a(21655, new Object[] { Integer.valueOf(this.nZx), this.nZy, Integer.valueOf(paramInt), this.nZz });
    AppMethodBeat.o(227715);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.nZI != null) && (this.nZI.isShowing())) {
      this.nZI.dismiss();
    }
    if ((this.jCK != null) && (this.nZH != null)) {
      this.jCK.c(this.nZH);
    }
    super.finish();
    if ((this.nZG == 1) || (this.nZG == 2)) {
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(48958);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48959);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.AppBrandIDCardUI", "onActivityResult, requestcode: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48959);
      return;
      if (this.nZH != null)
      {
        paramIntent = this.nZH;
        r localr = r.nzC;
        paramIntent.setPhoneItems((ArrayList)r.bTy());
        AppMethodBeat.o(48959);
        return;
      }
      Log.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(48955);
    back();
    AppMethodBeat.o(48955);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48954);
    Object localObject = getIntent().getExtras();
    if (localObject != null) {
      this.nZG = ((Bundle)localObject).getInt("id_ui_theme", 0);
    }
    super.onCreate(paramBundle);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.appId = ((Bundle)localObject).getString("intent_appid", "");
    this.nZv = ((Bundle)localObject).getString("wecoin_protocol_url", "");
    this.nZw = ((Bundle)localObject).getString("wecoin_apply_info", "");
    this.nZx = ((Bundle)localObject).getInt("wecoin_kv_scene_id", 1);
    this.nZy = ((Bundle)localObject).getString("wecoin_kv_session_id", "");
    this.nZz = ((Bundle)localObject).getString("wecoin_kv_cgi_session_id", "");
    if (Util.isNullOrNil(this.appId))
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.nZC = T((Bundle)localObject);
    if ((Util.isNullOrNil(this.nZC)) || (this.nZC.size() <= 0))
    {
      Log.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
      paramBundle = new Intent();
      paramBundle.putExtra("intent_err_code", 40003);
      paramBundle.putExtra("intent_err_msg", "category_id is null");
      setResult(1, paramBundle);
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.iDM = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(2131100898));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(nZt);
    ((ViewGroup)getContentView()).addView((View)localObject, paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48944);
        AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48944);
        return true;
      }
    });
    getString(2131755998);
    this.nZI = com.tencent.mm.ui.base.h.a(this, getString(2131762446), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.nZI.show();
    if ((this.nZG == 1) || (this.nZG == 2))
    {
      ao.e(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(nZt).setBackgroundColor(0);
      this.jCK = new e(getContext());
      paramBundle = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      if (!(((ViewGroup)getWindow().getDecorView()).getChildAt(0) instanceof ViewGroup)) {
        break label552;
      }
      Log.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
      paramBundle.setFitsSystemWindows(false);
    }
    for (;;)
    {
      try
      {
        ((ViewGroup)paramBundle).addView(this.jCK);
        this.nZf.bXR();
        if (isSupportNavigationSwipeBack()) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
        return;
      }
      catch (Exception paramBundle)
      {
        Log.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
        ((ViewGroup)getContentView()).addView(this.jCK);
        continue;
      }
      label552:
      Log.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
      ((ViewGroup)getContentView()).addView(this.jCK);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if ((this.nZG == 1) || (this.nZG == 2)) {
      setTheme(2131821178);
    }
    getWindow().requestFeature(10);
    getWindow().getDecorView().setFitsSystemWindows(true);
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
    AppMethodBeat.o(48953);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48957);
    back();
    AppMethodBeat.o(48957);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */