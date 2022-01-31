package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.e;

@a(3)
public class FavOpenApiEntry
  extends MMActivity
{
  private String aWf;
  private String appId;
  private Intent bRh;
  private am byQ = new am(new FavOpenApiEntry.1(this), true);
  private Bundle kke;
  private SendMessageToWX.Req kkf;
  private String kkg;
  private int kkh = 0;
  
  private void H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    yp localyp = new yp();
    localyp.Yw(this.appId);
    localyp.EQ(4);
    localyp.Yq(q.Gj());
    localyp.Yr(q.Gj());
    paramg.field_fromUser = localyp.bRO;
    paramg.field_toUser = localyp.toUser;
    paramg.field_favProto.a(localyp);
  }
  
  private q.a a(WXMediaMessage paramWXMediaMessage)
  {
    return new FavOpenApiEntry.2(this, paramWXMediaMessage);
  }
  
  private static xv a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    xv localxv = new xv();
    localxv.Xu(paramWXMediaMessage.title);
    localxv.Xv(paramWXMediaMessage.description);
    localxv.EH(paramInt);
    if (paramString != null)
    {
      localxv.XI(paramString);
      localxv.XE(e.bM(paramString));
      a(paramWXMediaMessage, localxv, paramInt);
      return localxv;
    }
    paramString = com.tencent.mm.a.g.o(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localxv.XG(paramString);
    }
    for (;;)
    {
      localxv.XF(paramString);
      localxv.hf(paramArrayOfByte.length);
      localxv.XH(b.bB(localxv.toString(), paramInt));
      e.a(b.b(localxv), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localxv.XG(com.tencent.mm.a.g.o(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramg.field_sourceType = 4;
    paramg.field_favProto.Yo(paramWXMediaMessage.title);
    paramg.field_favProto.Yp(paramWXMediaMessage.description);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, xv paramxv, int paramInt)
  {
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.a.g.o(paramWXMediaMessage.thumbData);
      paramxv.XK((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramxv.XL((String)localObject);
      }
      for (;;)
      {
        if (bk.bl(paramxv.kgC)) {
          paramxv.XH(b.bB(paramxv.toString(), paramInt));
        }
        paramxv.hg(paramWXMediaMessage.thumbData.length);
        paramxv = b.c(paramxv);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        e.a(paramxv, paramWXMediaMessage, paramWXMediaMessage.length);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramxv.XL(com.tencent.mm.a.g.o((byte[])localObject));
      }
    }
    paramxv.mk(true);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.bRh == null) {
      this.bRh = getIntent();
    }
    this.kke = this.bRh.getExtras();
    this.appId = this.kke.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.kke.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.kkf = new SendMessageToWX.Req(this.kke);
    if (this.kkf.scene != 2)
    {
      y.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      return;
    }
    this.kkg = getString(R.l.favorite);
    paramBundle = b.getAppName(this, this.appId);
    this.aWf = getString(R.l.confirm_dialog_source, new Object[] { paramBundle });
    this.byQ.S(100L, 100L);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.bRh = paramIntent;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry
 * JD-Core Version:    0.7.0.1
 */