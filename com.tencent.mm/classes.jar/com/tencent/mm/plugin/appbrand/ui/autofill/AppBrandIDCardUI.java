package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayService;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a.d;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dvu;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import d.z;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI
  extends MMActivity
{
  public static final int mMl = 2131296738;
  private String appId;
  private int hJc;
  private e iGI;
  private a mLX;
  public MMFragment mMm;
  private dey mMn;
  private hi mMo;
  private LinkedList<Integer> mMp;
  private String mMq;
  private String mMr;
  private String mMs;
  private int mMt;
  private com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a mMu;
  private p mMv;
  private PhoneItem mMw;
  
  public AppBrandIDCardUI()
  {
    AppMethodBeat.i(48952);
    this.mLX = new a()
    {
      public final void Vx(String paramAnonymousString)
      {
        AppMethodBeat.i(48932);
        ae.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48932);
      }
      
      public final void Vy(String paramAnonymousString)
      {
        AppMethodBeat.i(48933);
        ae.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48933);
      }
      
      public final void Vz(String paramAnonymousString)
      {
        AppMethodBeat.i(48934);
        ae.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymousString);
        AppMethodBeat.o(48934);
      }
      
      public final void a(hh paramAnonymoushh)
      {
        AppMethodBeat.i(48937);
        com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(7), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
        ae.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        Object localObject = new b.a();
        ((b.a)localObject).hQF = new dba();
        ((b.a)localObject).hQG = new dbb();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        ((b.a)localObject).funcId = 1762;
        ((b.a)localObject).hQH = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aDS();
        dba localdba = (dba)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
        localdba.dwb = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdba.HKc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdba.HKd = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localdba.FSa = paramAnonymoushh.FSa;
        localdba.dlT = paramAnonymoushh.dlT;
        localdba.dqk = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).moM)) {
          localdba.HKe = bu.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dAs);
        }
        IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
          {
            AppMethodBeat.i(48926);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hQE.hQJ == null))
            {
              ae.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hQE.hQJ });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48926);
              return;
            }
            paramAnonymous2String = (dbb)paramAnonymous2b.hQE.hQJ;
            if (paramAnonymous2String.HKf != null)
            {
              ae.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[] { Integer.valueOf(paramAnonymous2String.HKf.dxd) });
              if (paramAnonymous2String.HKf.dxd == 0)
              {
                AppBrandIDCardUI.c(AppBrandIDCardUI.this, paramAnonymous2String.HKg);
                ae.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[] { paramAnonymous2String.HKg });
                AppMethodBeat.o(48926);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755464));
              AppMethodBeat.o(48926);
              return;
            }
            ae.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755464));
            AppMethodBeat.o(48926);
          }
        });
        AppMethodBeat.o(48937);
      }
      
      public final void a(String paramAnonymousString, hh paramAnonymoushh)
      {
        AppMethodBeat.i(48938);
        if (bu.isNullOrNil(paramAnonymousString))
        {
          ae.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
          AppMethodBeat.o(48938);
          return;
        }
        ae.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        Object localObject = new b.a();
        ((b.a)localObject).hQF = new dvu();
        ((b.a)localObject).hQG = new dvv();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        ((b.a)localObject).funcId = 1721;
        ((b.a)localObject).hQH = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aDS();
        dvu localdvu = (dvu)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
        localdvu.dwb = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdvu.HKc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdvu.HKd = AppBrandIDCardUI.l(AppBrandIDCardUI.this);
        localdvu.FSa = paramAnonymoushh.FSa;
        localdvu.dqk = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk;
        localdvu.DrK = paramAnonymousString;
        localdvu.HKg = AppBrandIDCardUI.m(AppBrandIDCardUI.this);
        localdvu.dlT = paramAnonymoushh.dlT;
        if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).moM)) {
          localdvu.HKe = bu.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dAs);
        }
        IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
          {
            AppMethodBeat.i(48927);
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hQE.hQJ == null))
            {
              ae.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hQE.hQJ });
              Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
              AppMethodBeat.o(48927);
              return;
            }
            paramAnonymous2String = (dvv)paramAnonymous2b.hQE.hQJ;
            if (paramAnonymous2String.HKf != null)
            {
              ae.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.HKf.dxd), bu.nullAsNil(paramAnonymous2String.HKf.dxe) });
              com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(8), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
              if (paramAnonymous2String.HKf.dxd == 0)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
                ae.i("MicroMsg.AppBrandIDCardUI", "verify success");
                ae.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous2String.Gua });
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                {
                  paramAnonymous2b = r.moQ;
                  r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                }
                paramAnonymous2b = new Intent();
                paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.HKf.dxd);
                paramAnonymous2b.putExtra("intent_auth_token", paramAnonymous2String.Gua);
                AppBrandIDCardUI.this.setResult(-1, paramAnonymous2b);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(48927);
                return;
              }
              if (paramAnonymous2String.HKf.dxd == 40013)
              {
                AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755463));
                AppMethodBeat.o(48927);
                return;
              }
              AppBrandIDCardUI.1.a(AppBrandIDCardUI.1.this, AppBrandIDCardUI.this.getString(2131755462));
              AppMethodBeat.o(48927);
              return;
            }
            ae.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
            AppMethodBeat.o(48927);
          }
        });
        AppMethodBeat.o(48938);
      }
      
      public final void bAM()
      {
        AppMethodBeat.i(48929);
        Object localObject = new b.a();
        ((b.a)localObject).hQF = new dex();
        ((b.a)localObject).hQG = new dey();
        ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        ((b.a)localObject).funcId = 1774;
        ((b.a)localObject).hQH = 0;
        ((b.a)localObject).respCmdId = 0;
        localObject = ((b.a)localObject).aDS();
        dex localdex = (dex)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
        localdex.dwb = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
        localdex.HKc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
        localdex.HLX = AppBrandIDCardUI.c(AppBrandIDCardUI.this);
        IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
        {
          public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.ak.b paramAnonymous2b)
          {
            AppMethodBeat.i(48922);
            if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
              AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
            }
            if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0) || (paramAnonymous2b.hQE.hQJ == null))
            {
              ae.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String, paramAnonymous2b.hQE.hQJ });
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            paramAnonymous2String = (dey)paramAnonymous2b.hQE.hQJ;
            if (paramAnonymous2String.HKf == null)
            {
              ae.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
              paramAnonymous2String = new Intent();
              paramAnonymous2String.putExtra("intent_err_code", 40000);
              paramAnonymous2String.putExtra("intent_err_msg", "network err");
              AppBrandIDCardUI.this.setResult(1, paramAnonymous2String);
              AppBrandIDCardUI.this.finish();
              AppMethodBeat.o(48922);
              return;
            }
            ae.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[] { Integer.valueOf(paramAnonymous2String.HKf.dxd) });
            ae.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[] { Integer.valueOf(paramAnonymous2String.HLY) });
            switch (paramAnonymous2String.HLY)
            {
            default: 
              ae.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
            case 0: 
              do
              {
                AppMethodBeat.o(48922);
                return;
                if (paramAnonymous2String.HKf.dxd != 0)
                {
                  ae.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                  paramAnonymous2b = new Intent();
                  paramAnonymous2b.putExtra("intent_err_code", paramAnonymous2String.HKf.dxd);
                  paramAnonymous2b.putExtra("intent_err_msg", paramAnonymous2String.HKf.dxe);
                  AppBrandIDCardUI.this.setResult(1, paramAnonymous2b);
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
              } while (AppBrandIDCardUI.e(AppBrandIDCardUI.this) != 1);
              AppBrandIDCardUI.g(AppBrandIDCardUI.this);
              AppMethodBeat.o(48922);
              return;
            }
            ae.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2String.HKf.dxd), paramAnonymous2String.HKf.dxe });
            paramAnonymous2b = AppBrandIDCardUI.1.this;
            paramAnonymous2Int1 = paramAnonymous2String.HKf.dxd;
            String str = paramAnonymous2String.HKf.dxe;
            h.a(paramAnonymous2b.mMx, false, paramAnonymous2String.HLZ.desc, paramAnonymous2String.HLZ.title, paramAnonymous2b.mMx.getString(2131755459), "", new AppBrandIDCardUI.1.2(paramAnonymous2b, paramAnonymous2Int1, str), new AppBrandIDCardUI.1.3(paramAnonymous2b));
            AppMethodBeat.o(48922);
          }
        });
        AppMethodBeat.o(48929);
      }
      
      public final void bAN()
      {
        AppMethodBeat.i(48935);
        ae.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(2), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
        if (AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg == null)
        {
          ae.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
          AppMethodBeat.o(48935);
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("appId", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg.dwb);
          localJSONObject.put("timeStamp", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg.cVJ);
          localJSONObject.put("nonceStr", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg.Hel);
          localJSONObject.put("package", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg.Ibz);
          localJSONObject.put("signType", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg.oOW);
          localJSONObject.put("paySign", AppBrandIDCardUI.i(AppBrandIDCardUI.this).HMg.HdK);
          com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(3), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
          AppBrandJsApiPayService.lgh.verifyPassword(AppBrandIDCardUI.this, null, localJSONObject, new a.d()
          {
            public final void p(boolean paramAnonymous2Boolean, final String paramAnonymous2String)
            {
              AppMethodBeat.i(48925);
              if (paramAnonymous2Boolean)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(4), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
                Object localObject = new b.a();
                ((b.a)localObject).hQF = new dlf();
                ((b.a)localObject).hQG = new dlg();
                ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                ((b.a)localObject).funcId = 1721;
                ((b.a)localObject).hQH = 0;
                ((b.a)localObject).respCmdId = 0;
                localObject = ((b.a)localObject).aDS();
                dlf localdlf = (dlf)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
                localdlf.dwb = AppBrandIDCardUI.a(AppBrandIDCardUI.this);
                localdlf.HKc = AppBrandIDCardUI.b(AppBrandIDCardUI.this);
                localdlf.HKd = paramAnonymous2String;
                localdlf.dqk = AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk;
                if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.j(AppBrandIDCardUI.this).moM)) {
                  localdlf.HKe = bu.nullAsNil(AppBrandIDCardUI.j(AppBrandIDCardUI.this).dAs);
                }
                if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (!AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                  AppBrandIDCardUI.d(AppBrandIDCardUI.this).show();
                }
                IPCRunCgi.a((com.tencent.mm.ak.b)localObject, new IPCRunCgi.a()
                {
                  public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, com.tencent.mm.ak.b paramAnonymous3b)
                  {
                    AppMethodBeat.i(48924);
                    if ((AppBrandIDCardUI.d(AppBrandIDCardUI.this) != null) && (AppBrandIDCardUI.d(AppBrandIDCardUI.this).isShowing())) {
                      AppBrandIDCardUI.d(AppBrandIDCardUI.this).dismiss();
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0) || (paramAnonymous3b.hQE.hQJ == null))
                    {
                      ae.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, paramAnonymous3b.hQE.hQJ });
                      AppMethodBeat.o(48924);
                      return;
                    }
                    paramAnonymous3String = (dlg)paramAnonymous3b.hQE.hQJ;
                    if (paramAnonymous3String.HKf == null)
                    {
                      ae.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                      Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(2131755458), 0).show();
                      AppMethodBeat.o(48924);
                      return;
                    }
                    ae.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[] { Integer.valueOf(paramAnonymous3String.FRO) });
                    switch (paramAnonymous3String.FRO)
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(48924);
                      return;
                      ae.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[] { paramAnonymous3String.Gua });
                      com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(9), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
                      if ((AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1) && (AppBrandIDCardUI.j(AppBrandIDCardUI.this) != null))
                      {
                        paramAnonymous3b = r.moQ;
                        r.b(AppBrandIDCardUI.j(AppBrandIDCardUI.this));
                      }
                      paramAnonymous3b = new Intent();
                      paramAnonymous3b.putExtra("intent_err_code", paramAnonymous3String.HKf.dxd);
                      paramAnonymous3b.putExtra("intent_auth_token", paramAnonymous3String.Gua);
                      AppBrandIDCardUI.this.setResult(-1, paramAnonymous3b);
                      AppBrandIDCardUI.this.finish();
                      AppMethodBeat.o(48924);
                      return;
                      com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(5), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
                      AppBrandIDCardUI.b(AppBrandIDCardUI.this, paramAnonymous2String);
                      AppBrandIDCardUI.a(AppBrandIDCardUI.this, paramAnonymous3String.HSM);
                      AppBrandIDCardUI.k(AppBrandIDCardUI.this);
                    }
                  }
                });
              }
              for (;;)
              {
                ae.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramAnonymous2Boolean) });
                AppMethodBeat.o(48925);
                return;
                if (AppBrandIDCardUI.e(AppBrandIDCardUI.this) == 1)
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
          ae.printErrStackTrace("MicroMsg.AppBrandIDCardUI", localJSONException, "", new Object[0]);
          AppMethodBeat.o(48935);
        }
      }
      
      public final void bAO()
      {
        AppMethodBeat.i(48936);
        com.tencent.mm.plugin.report.service.g.yxI.f(14943, new Object[] { AppBrandIDCardUI.a(AppBrandIDCardUI.this), Integer.valueOf(6), AppBrandIDCardUI.i(AppBrandIDCardUI.this).dqk });
        AppMethodBeat.o(48936);
      }
      
      public final dey bAP()
      {
        AppMethodBeat.i(48939);
        dey localdey = AppBrandIDCardUI.i(AppBrandIDCardUI.this);
        AppMethodBeat.o(48939);
        return localdey;
      }
      
      public final hi bAQ()
      {
        AppMethodBeat.i(48940);
        hi localhi = AppBrandIDCardUI.n(AppBrandIDCardUI.this);
        AppMethodBeat.o(48940);
        return localhi;
      }
      
      public final void back()
      {
        AppMethodBeat.i(48931);
        AppBrandIDCardUI.h(AppBrandIDCardUI.this);
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
  
  private static LinkedList<Integer> N(Bundle paramBundle)
  {
    AppMethodBeat.i(48960);
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramBundle = paramBundle.getString("intent_category_id");
      ae.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", new Object[] { paramBundle });
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
      ae.printErrStackTrace("MicroMsg.AppBrandIDCardUI", paramBundle, "", new Object[0]);
      AppMethodBeat.o(48960);
    }
    return null;
  }
  
  private void bAL()
  {
    AppMethodBeat.i(48961);
    ae.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
    this.mMm = new AppBrandIDCardShowFrag();
    ((AppBrandIDCardShowFrag)this.mMm).mLX = this.mLX;
    getSupportFragmentManager().beginTransaction().b(mMl, this.mMm).commitAllowingStateLoss();
    AppMethodBeat.o(48961);
  }
  
  private void back()
  {
    AppMethodBeat.i(48956);
    if (((this.mMm instanceof AppBrandIDCardVerifyPwdFrag)) && (this.mMt == 0))
    {
      bAL();
      AppMethodBeat.o(48956);
      return;
    }
    if ((this.mMt != 1) || (this.iGI == null) || (!this.iGI.onBackPressed())) {
      finish();
    }
    AppMethodBeat.o(48956);
  }
  
  public void finish()
  {
    AppMethodBeat.i(48958);
    if ((this.mMv != null) && (this.mMv.isShowing())) {
      this.mMv.dismiss();
    }
    if ((this.iGI != null) && (this.mMu != null)) {
      this.iGI.c(this.mMu);
    }
    super.finish();
    if (this.mMt == 1) {
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
    ae.i("MicroMsg.AppBrandIDCardUI", "onActivityResult, requestcode: %d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48959);
      return;
      if (this.mMu != null)
      {
        paramIntent = this.mMu;
        r localr = r.moQ;
        paramIntent.setPhoneItems((ArrayList)r.bxo());
        AppMethodBeat.o(48959);
        return;
      }
      ae.e("MicroMsg.AppBrandIDCardUI", "onActivityResult, AuthDialog is null");
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
      this.mMt = ((Bundle)localObject).getInt("id_ui_theme", 0);
    }
    super.onCreate(paramBundle);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.appId = ((Bundle)localObject).getString("intent_appid", "");
    if (bu.isNullOrNil(this.appId))
    {
      ae.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.mMp = N((Bundle)localObject);
    if ((bu.ht(this.mMp)) || (this.mMp.size() <= 0))
    {
      ae.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
      paramBundle = new Intent();
      paramBundle.putExtra("intent_err_code", 40003);
      paramBundle.putExtra("intent_err_msg", "category_id is null");
      setResult(1, paramBundle);
      finish();
      AppMethodBeat.o(48954);
      return;
    }
    this.hJc = ((Bundle)localObject).getInt("intent_auth_type", 1);
    getContentView().setBackgroundColor(getResources().getColor(2131100705));
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    localObject = new FrameLayout(this);
    ((View)localObject).setId(mMl);
    ((ViewGroup)getContentView()).addView((View)localObject, paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48944);
        AppBrandIDCardUI.h(AppBrandIDCardUI.this);
        AppMethodBeat.o(48944);
        return true;
      }
    });
    getString(2131755906);
    this.mMv = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(48945);
        AppBrandIDCardUI.this.setResult(0);
        AppBrandIDCardUI.this.finish();
        AppMethodBeat.o(48945);
      }
    });
    this.mMv.show();
    if (this.mMt == 1)
    {
      al.b(getWindow());
      getContentView().setBackgroundColor(0);
      getContentView().findViewById(mMl).setBackgroundColor(0);
      this.iGI = new e(getContext());
      paramBundle = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      if (!(((ViewGroup)getWindow().getDecorView()).getChildAt(0) instanceof ViewGroup)) {
        break label480;
      }
      ae.i("MicroMsg.AppBrandIDCardUI", "find sub viewgroup in decorview");
      paramBundle.setFitsSystemWindows(false);
    }
    for (;;)
    {
      try
      {
        ((ViewGroup)paramBundle).addView(this.iGI);
        this.mLX.bAM();
        if (isSupportNavigationSwipeBack()) {
          getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(48954);
        return;
      }
      catch (Exception paramBundle)
      {
        ae.w("MicroMsg.AppBrandIDCardUI", "add view to decorSubView error", new Object[] { paramBundle });
        ((ViewGroup)getContentView()).addView(this.iGI);
        continue;
      }
      label480:
      ae.i("MicroMsg.AppBrandIDCardUI", "can't find sub viewgroup in decorview");
      ((ViewGroup)getContentView()).addView(this.iGI);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48953);
    super.onCreateBeforeSetContentView();
    if (this.mMt == 1) {
      setTheme(2131821149);
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
  
  public static abstract interface a
  {
    public abstract void Vx(String paramString);
    
    public abstract void Vy(String paramString);
    
    public abstract void Vz(String paramString);
    
    public abstract void a(hh paramhh);
    
    public abstract void a(String paramString, hh paramhh);
    
    public abstract void bAM();
    
    public abstract void bAN();
    
    public abstract void bAO();
    
    public abstract dey bAP();
    
    public abstract hi bAQ();
    
    public abstract void back();
    
    public abstract void onSwipeBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI
 * JD-Core Version:    0.7.0.1
 */