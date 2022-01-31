package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.h.a.pe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.clx;
import com.tencent.mm.protocal.c.cly;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SendAppMessageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SendAppMessageTask> CREATOR = new SendAppMessageTask.2();
  public String appId;
  public String bFv;
  public int bOa;
  public String caG;
  public String dRD;
  public int dWx;
  public String description;
  public String fRx;
  public String fWw;
  public String gBE;
  public String gBF;
  public String gBG;
  public int gBH;
  public String gBI;
  public String gBJ;
  public String gBK;
  public boolean gBL;
  public boolean gBM;
  public String gBN;
  public ArrayList<ShareInfo> gBO;
  public Runnable gfD;
  public boolean gpR;
  public String iconUrl;
  public String nickname;
  public String path;
  public int scene = 1000;
  public String title;
  public String toUser;
  public int type;
  public String url;
  public String userName;
  public int version;
  public boolean withShareTicket;
  
  public SendAppMessageTask() {}
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  private void a(g.a parama, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    ((com.tencent.mm.plugin.appbrand.compat.a.a)g.r(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(parama, this.appId, this.title, paramString, paramArrayOfByte);
    if (!bk.bl(this.gBE))
    {
      parama = new pe();
      parama.bYQ.bYR = paramString;
      parama.bYQ.content = this.gBE;
      parama.bYQ.type = s.hW(paramString);
      parama.bYQ.flags = 0;
      com.tencent.mm.sdk.b.a.udP.m(parama);
    }
    i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      parama = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().ir(paramString);
      if (parama == null) {
        break label218;
      }
    }
    label218:
    for (i = parama.size();; i = 0)
    {
      str4 = this.appId;
      str5 = this.bFv;
      str6 = this.gBI;
      localObject = this.title;
      str7 = this.path;
      str8 = this.gBJ;
      str9 = this.gBK;
      str10 = paramStringBuilder.toString();
      str3 = this.gBN;
      j = this.dWx;
      str1 = this.gBF;
      if (!bk.bl(str4)) {
        break;
      }
      y.e("MicroMsg.SendAppMessageTask", "appId is Null!");
      return;
    }
    parama = "";
    try
    {
      paramArrayOfByte = q.encode(bk.pm(str7), "UTF-8");
      parama = paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramStringBuilder)
    {
      try
      {
        paramStringBuilder = q.encode(bk.pm(str8), "UTF-8");
        paramArrayOfByte = paramStringBuilder;
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        try
        {
          paramStringBuilder = q.encode(bk.pm(str3), "UTF-8");
        }
        catch (UnsupportedEncodingException paramStringBuilder)
        {
          try
          {
            for (;;)
            {
              str1 = q.encode(bk.pm(str1), "UTF-8");
              try
              {
                str3 = q.encode(bk.pm((String)localObject), "UTF-8");
                localObject = str3;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException2)
              {
                for (;;)
                {
                  String str2;
                  y.e("MicroMsg.SendAppMessageTask", "encode shareTitle error!");
                }
              }
              j += 1000;
              y.d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s", new Object[] { Integer.valueOf(14077), str4, Integer.valueOf(paramInt), str5, str6, str8, str9, localObject, str7, str10, Integer.valueOf(i), paramString, Integer.valueOf(j), str1 });
              h.nFQ.f(14077, new Object[] { str4, Integer.valueOf(paramInt), str5, str6, paramArrayOfByte, str9, localObject, parama, str10, "", Integer.valueOf(i), paramString, paramStringBuilder, Integer.valueOf(j), str1 });
              return;
              paramArrayOfByte = paramArrayOfByte;
              y.e("MicroMsg.SendAppMessageTask", "encode share page path error!");
              continue;
              paramStringBuilder = paramStringBuilder;
              y.e("MicroMsg.SendAppMessageTask", "encode current page path error!");
              continue;
              paramStringBuilder = paramStringBuilder;
              y.e("MicroMsg.SendAppMessageTask", "encode current html url error!");
              paramStringBuilder = "";
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            for (;;)
            {
              y.e("MicroMsg.SendAppMessageTask", "encode thumb Icon url error!");
              str2 = "";
            }
          }
        }
      }
    }
    paramArrayOfByte = "";
  }
  
  private void a(g.a parama, byte[] paramArrayOfByte, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean, String paramString)
  {
    b.a locala = new b.a();
    locala.ecG = 1118;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
    clx localclx = new clx();
    localclx.bOL = this.appId;
    LinkedList localLinkedList = new LinkedList(bk.G(this.toUser.split(",")));
    localclx.tYR = localLinkedList;
    localclx.tYT = paramString;
    localclx.tYS = paramBoolean;
    locala.ecH = localclx;
    locala.ecI = new cly();
    w.a(locala.Kt(), new SendAppMessageTask.1(this, localLinkedList, parama, paramInt, paramArrayOfByte, paramStringBuilder));
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.gBF });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!bk.bl(this.gBF)) && ((this.gBF.startsWith("http://")) || (this.gBF.startsWith("https://")))) {
      localObject1 = b.JD().a(this.gBF, null);
    }
    for (;;)
    {
      Object localObject3;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        y.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(-1);
        ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((Bitmap)localObject2).recycle();
        label165:
        y.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.gBF });
        localObject2 = u.ij("wxapp_" + this.appId + this.path);
        u.Hc().v((String)localObject2, true).h("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new g.a();
        ((g.a)localObject2).title = this.title;
        ((g.a)localObject2).description = this.description;
        ((g.a)localObject2).type = 33;
        ((g.a)localObject2).dSY = this.userName;
        ((g.a)localObject2).dSX = this.path;
        ((g.a)localObject2).dSZ = this.appId;
        ((g.a)localObject2).dTf = this.bOa;
        ((g.a)localObject2).dTg = this.version;
        ((g.a)localObject2).dTb = this.fRx;
        ((g.a)localObject2).dTa = this.type;
        ((g.a)localObject2).url = this.url;
        ((g.a)localObject2).dTh = this.iconUrl;
        ((g.a)localObject2).bYM = ("wxapp_" + this.appId + this.path);
        ((g.a)localObject2).bYG = this.userName;
        ((g.a)localObject2).bYH = this.nickname;
        localObject3 = new com.tencent.mm.ae.a();
        ((com.tencent.mm.ae.a)localObject3).dPD = this.gBL;
        ((com.tencent.mm.ae.a)localObject3).dPE = this.fWw;
        ((com.tencent.mm.ae.a)localObject3).dPF = this.dWx;
        ((com.tencent.mm.ae.a)localObject3).dPG = this.gBM;
        ((com.tencent.mm.ae.a)localObject3).dPP = this.caG;
        ((g.a)localObject2).a((d)localObject3);
        localObject3 = new StringBuilder("1_");
        ((StringBuilder)localObject3).append(this.appId);
        ((StringBuilder)localObject3).append("_");
        g.DN();
        ((StringBuilder)localObject3).append(o.getString(com.tencent.mm.kernel.a.CK()));
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(bk.UX());
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(this.gBH);
        ((g.a)localObject2).dTd = ((StringBuilder)localObject3).toString();
        y.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b", new Object[] { Boolean.valueOf(this.gBM), Boolean.valueOf(this.withShareTicket) });
        if ((!this.gBM) || (!this.withShareTicket)) {
          break label759;
        }
        a((g.a)localObject2, (byte[])localObject1, (StringBuilder)localObject3, this.scene, this.gBM, this.dRD);
      }
      for (;;)
      {
        return;
        if (bk.bl(this.gBG)) {
          break label847;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.c.YW(this.gBG);
        if (this.gpR)
        {
          boolean bool = e.deleteFile(this.gBG);
          y.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.gBG, Boolean.valueOf(bool) });
          break;
        }
        y.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.gBG });
        break;
        y.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label165;
        label759:
        if (this.withShareTicket)
        {
          a((g.a)localObject2, (byte[])localObject1, (StringBuilder)localObject3, this.scene, this.gBM, this.dRD);
          return;
        }
        Iterator localIterator = new LinkedList(bk.G(this.toUser.split(","))).iterator();
        while (localIterator.hasNext()) {
          a((g.a)localObject2, (byte[])localObject1, (String)localIterator.next(), (StringBuilder)localObject3, this.scene);
        }
      }
      label847:
      localObject1 = null;
    }
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.appId = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.gBE = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.gBF = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.gBG = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.gpR = bool1;
      this.bOa = paramParcel.readInt();
      this.fRx = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.gBH = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.bFv = paramParcel.readString();
      this.gBI = paramParcel.readString();
      this.gBJ = paramParcel.readString();
      this.gBK = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label297;
      }
      bool1 = true;
      label203:
      this.withShareTicket = bool1;
      if (paramParcel.readInt() != 1) {
        break label302;
      }
      bool1 = true;
      label218:
      this.gBL = bool1;
      if (paramParcel.readInt() != 1) {
        break label307;
      }
    }
    label297:
    label302:
    label307:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gBM = bool1;
      this.dRD = paramParcel.readString();
      this.fWw = paramParcel.readString();
      this.dWx = paramParcel.readInt();
      this.gBN = paramParcel.readString();
      this.gBO = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.caG = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label203;
      bool1 = false;
      break label218;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.gBE);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.gBF);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.gBG);
    if (this.gpR)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.bOa);
      paramParcel.writeString(this.fRx);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.gBH);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.bFv);
      paramParcel.writeString(this.gBI);
      paramParcel.writeString(this.gBJ);
      paramParcel.writeString(this.gBK);
      if (!this.withShareTicket) {
        break label295;
      }
      paramInt = 1;
      label207:
      paramParcel.writeByte((byte)paramInt);
      if (!this.gBL) {
        break label300;
      }
      paramInt = 1;
      label222:
      paramParcel.writeInt(paramInt);
      if (!this.gBM) {
        break label305;
      }
    }
    label295:
    label300:
    label305:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.dRD);
      paramParcel.writeString(this.fWw);
      paramParcel.writeInt(this.dWx);
      paramParcel.writeString(this.gBN);
      paramParcel.writeList(this.gBO);
      paramParcel.writeString(this.caG);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label207;
      paramInt = 0;
      break label222;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */