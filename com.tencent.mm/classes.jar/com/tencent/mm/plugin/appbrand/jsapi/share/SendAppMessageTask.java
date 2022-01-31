package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j.a;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
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
  public static final Parcelable.Creator<SendAppMessageTask> CREATOR;
  public String appId;
  public int bDc;
  public String cHH;
  public String cJg;
  public String cacheKey;
  public String cmF;
  public int cvs;
  public String description;
  public int dqS;
  public String fhC;
  public int fmF;
  public boolean hKA;
  public String hZN;
  public String hZO;
  public String hZP;
  public String hZQ;
  public int hZR;
  public int hZS;
  public int hZT;
  public String hZU;
  public String hZV;
  public String hZW;
  public boolean hZX;
  public boolean hZY;
  public boolean hZZ;
  public String hko;
  public Runnable hxp;
  public String iaa;
  public String iab;
  public String iac;
  public String iad;
  public String iae;
  public String iaf;
  public String iag;
  public ArrayList<ShareInfo> iah;
  public String iconUrl;
  public String nickname;
  public String path;
  public int scene;
  public String title;
  public String toUser;
  public int type;
  public String url;
  public String userName;
  public int version;
  public String videoPath;
  public boolean withShareTicket;
  
  static
  {
    AppMethodBeat.i(131473);
    CREATOR = new SendAppMessageTask.2();
    AppMethodBeat.o(131473);
  }
  
  public SendAppMessageTask()
  {
    AppMethodBeat.i(131462);
    this.hZR = 1;
    this.dqS = j.a.fgr.ordinal();
    this.scene = 1000;
    AppMethodBeat.o(131462);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(131470);
    this.hZR = 1;
    this.dqS = j.a.fgr.ordinal();
    this.scene = 1000;
    f(paramParcel);
    AppMethodBeat.o(131470);
  }
  
  private void a(j.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(143434);
    ((com.tencent.mm.plugin.appbrand.compat.a.a)g.E(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(paramb, this.appId, this.title, paramString, paramArrayOfByte);
    if (!bo.isNullOrNil(this.hZN))
    {
      paramb = new qj();
      paramb.cGX.cGY = paramString;
      paramb.cGX.content = this.hZN;
      paramb.cGX.type = t.oF(paramString);
      paramb.cGX.flags = 0;
      com.tencent.mm.sdk.b.a.ymk.l(paramb);
    }
    i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((c)g.E(c.class)).YJ().oY(paramString);
      if (paramb == null) {
        break label234;
      }
    }
    label234:
    for (i = paramb.size();; i = 0)
    {
      str4 = this.appId;
      str5 = this.cmF;
      str6 = this.hZU;
      localObject = this.title;
      str7 = this.path;
      str8 = this.hZV;
      str9 = this.hZW;
      str10 = paramStringBuilder.toString();
      str3 = this.iaa;
      k = this.fmF;
      str1 = this.hZO;
      j = this.bDc;
      if (!bo.isNullOrNil(str4)) {
        break;
      }
      ab.e("MicroMsg.SendAppMessageTask", "appId is Null!");
      AppMethodBeat.o(143434);
      return;
    }
    paramb = "";
    try
    {
      paramArrayOfByte = q.encode(bo.nullAsNil(str7), "UTF-8");
      paramb = paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramStringBuilder)
    {
      try
      {
        paramStringBuilder = q.encode(bo.nullAsNil(str8), "UTF-8");
        paramArrayOfByte = paramStringBuilder;
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        try
        {
          paramStringBuilder = q.encode(bo.nullAsNil(str3), "UTF-8");
        }
        catch (UnsupportedEncodingException paramStringBuilder)
        {
          try
          {
            for (;;)
            {
              str1 = q.encode(bo.nullAsNil(str1), "UTF-8");
              try
              {
                str3 = q.encode(bo.nullAsNil((String)localObject), "UTF-8");
                localObject = str3;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException2)
              {
                for (;;)
                {
                  String str2;
                  ab.e("MicroMsg.SendAppMessageTask", "encode shareTitle error!");
                }
              }
              k += 1000;
              ab.d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s, appVersion %d", new Object[] { Integer.valueOf(14077), str4, Integer.valueOf(paramInt), str5, str6, str8, str9, localObject, str7, str10, Integer.valueOf(i), paramString, Integer.valueOf(k), str1, Integer.valueOf(j) });
              h.qsU.e(14077, new Object[] { str4, Integer.valueOf(paramInt), str5, str6, paramArrayOfByte, str9, localObject, paramb, str10, "", Integer.valueOf(i), paramString, paramStringBuilder, Integer.valueOf(k), str1, Integer.valueOf(j) });
              AppMethodBeat.o(143434);
              return;
              paramArrayOfByte = paramArrayOfByte;
              ab.e("MicroMsg.SendAppMessageTask", "encode share page path error!");
              continue;
              paramStringBuilder = paramStringBuilder;
              ab.e("MicroMsg.SendAppMessageTask", "encode current page path error!");
              continue;
              paramStringBuilder = paramStringBuilder;
              ab.e("MicroMsg.SendAppMessageTask", "encode current html url error!");
              paramStringBuilder = "";
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            for (;;)
            {
              ab.e("MicroMsg.SendAppMessageTask", "encode thumb Icon url error!");
              str2 = "";
            }
          }
        }
      }
    }
    paramArrayOfByte = "";
  }
  
  private void a(j.b paramb, byte[] paramArrayOfByte, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(131466);
    b.a locala = new b.a();
    locala.funcId = 1118;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
    czo localczo = new czo();
    localczo.cwc = this.appId;
    LinkedList localLinkedList = new LinkedList(bo.P(this.toUser.split(",")));
    localczo.ygn = localLinkedList;
    localczo.ygp = paramString;
    localczo.ygo = paramBoolean;
    locala.fsX = localczo;
    locala.fsY = new czp();
    w.a(locala.ado(), new SendAppMessageTask.1(this, localLinkedList, paramb, paramInt, paramArrayOfByte, paramStringBuilder));
    AppMethodBeat.o(131466);
  }
  
  private void b(j.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(131467);
    a(paramb, paramArrayOfByte, paramString, paramStringBuilder, paramInt);
    AppMethodBeat.o(131467);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(131463);
    ab.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.hZO });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!bo.isNullOrNil(this.hZO)) && ((this.hZO.startsWith("http://")) || (this.hZO.startsWith("https://")))) {
      localObject1 = b.acD().a(this.hZO, null);
    }
    for (;;)
    {
      Object localObject3;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ab.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(-1);
        ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ab.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", new Object[] { localObject2 });
        ((Bitmap)localObject2).recycle();
        label187:
        ab.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.hZO });
        localObject2 = v.oQ("wxapp_" + this.appId + this.path);
        v.aae().z((String)localObject2, true).i("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new j.b();
        ((j.b)localObject2).title = this.title;
        ((j.b)localObject2).description = this.description;
        ((j.b)localObject2).fiX = this.userName;
        ((j.b)localObject2).fiW = this.path;
        ((j.b)localObject2).fiY = this.appId;
        ((j.b)localObject2).fjh = this.cvs;
        ((j.b)localObject2).fji = this.version;
        ((j.b)localObject2).fja = this.hko;
        ((j.b)localObject2).fiZ = this.type;
        ((j.b)localObject2).fjg = this.hZS;
        ((j.b)localObject2).url = this.url;
        ((j.b)localObject2).fjj = this.iconUrl;
        ((j.b)localObject2).cGT = ("wxapp_" + this.appId + this.path);
        ((j.b)localObject2).cGN = this.userName;
        ((j.b)localObject2).cGO = this.nickname;
        localObject4 = new com.tencent.mm.af.a();
        ((com.tencent.mm.af.a)localObject4).ffc = this.hZX;
        ((com.tencent.mm.af.a)localObject4).ffd = this.cacheKey;
        ((com.tencent.mm.af.a)localObject4).ffe = this.fmF;
        ((com.tencent.mm.af.a)localObject4).fff = this.hZY;
        ((com.tencent.mm.af.a)localObject4).ffo = this.cJg;
        ((com.tencent.mm.af.a)localObject4).ffp = this.hZO;
        ((com.tencent.mm.af.a)localObject4).ffq = bo.isNullOrNil(this.hZO);
        ((j.b)localObject2).a((f)localObject4);
        localObject3 = new StringBuilder("1_");
        ((StringBuilder)localObject3).append(this.appId);
        ((StringBuilder)localObject3).append("_");
        g.RJ();
        ((StringBuilder)localObject3).append(p.getString(com.tencent.mm.kernel.a.getUin()));
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(bo.aox());
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(this.hZT);
        ((j.b)localObject2).fjc = ((StringBuilder)localObject3).toString();
        if (1 != this.hZR) {
          break label824;
        }
        ((j.b)localObject2).type = 33;
      }
      for (;;)
      {
        ab.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b", new Object[] { Boolean.valueOf(this.hZY), Boolean.valueOf(this.withShareTicket) });
        if ((!this.hZY) || (!this.withShareTicket)) {
          break label1030;
        }
        a((j.b)localObject2, (byte[])localObject1, (StringBuilder)localObject3, this.scene, this.hZY, this.fhC);
        AppMethodBeat.o(131463);
        return;
        if (bo.isNullOrNil(this.hZP)) {
          break label1131;
        }
        localObject1 = d.aoV(this.hZP);
        if (this.hKA)
        {
          boolean bool = com.tencent.mm.vfs.e.deleteFile(this.hZP);
          ab.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.hZP, Boolean.valueOf(bool) });
          break;
        }
        ab.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.hZP });
        break;
        ab.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label187;
        label824:
        if (2 == this.hZR)
        {
          ((j.b)localObject2).type = 44;
          ((j.b)localObject2).fje = this.dqS;
          ((j.b)localObject2).fjf = this.hZQ;
        }
        else if (this.hZR == 3)
        {
          ((j.b)localObject2).type = 46;
          ((j.b)localObject2).appId = this.iab;
          ((j.b)localObject2).appName = this.iac;
          ((j.b)localObject2).cGN = this.iad;
          ((j.b)localObject2).cGO = null;
          ((com.tencent.mm.af.a)localObject4).appThumbUrl = this.iae;
        }
        else if (this.hZR == 4)
        {
          ((j.b)localObject2).type = 48;
          j.akQ(com.tencent.mm.compatible.util.e.esT);
          String str = com.tencent.mm.compatible.util.e.esT + this.cHH;
          if (!str.equals(this.videoPath)) {
            ab.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { str, Long.valueOf(com.tencent.mm.a.e.C(this.videoPath, str)) });
          }
          ((com.tencent.mm.af.a)localObject4).ffu = str;
          ((com.tencent.mm.af.a)localObject4).cHH = this.cHH;
          ((com.tencent.mm.af.a)localObject4).ffw = this.iag;
        }
      }
      label1030:
      if (this.withShareTicket)
      {
        a((j.b)localObject2, (byte[])localObject1, (StringBuilder)localObject3, this.scene, this.hZY, this.fhC);
        AppMethodBeat.o(131463);
        return;
      }
      Object localObject4 = new LinkedList(bo.P(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((j.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(131463);
      return;
      label1131:
      localObject1 = null;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(131464);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(131464);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(131468);
    this.appId = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.hZN = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.hZO = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.hZP = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.hKA = bool1;
      this.cvs = paramParcel.readInt();
      this.hko = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.hZT = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.cmF = paramParcel.readString();
      this.hZU = paramParcel.readString();
      this.hZV = paramParcel.readString();
      this.hZW = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label428;
      }
      bool1 = true;
      label209:
      this.withShareTicket = bool1;
      if (paramParcel.readInt() != 1) {
        break label433;
      }
      bool1 = true;
      label224:
      this.hZX = bool1;
      if (paramParcel.readInt() != 1) {
        break label438;
      }
      bool1 = true;
      label239:
      this.hZY = bool1;
      this.fhC = paramParcel.readString();
      this.cacheKey = paramParcel.readString();
      this.fmF = paramParcel.readInt();
      this.iaa = paramParcel.readString();
      this.iah = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.cJg = paramParcel.readString();
      this.bDc = paramParcel.readInt();
      this.dqS = paramParcel.readInt();
      this.hZQ = paramParcel.readString();
      this.hZS = paramParcel.readInt();
      this.hZR = paramParcel.readInt();
      this.iab = paramParcel.readString();
      this.iac = paramParcel.readString();
      this.iad = paramParcel.readString();
      this.iae = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label443;
      }
    }
    label428:
    label433:
    label438:
    label443:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hZZ = bool1;
      this.videoPath = paramParcel.readString();
      this.cHH = paramParcel.readString();
      this.iaf = paramParcel.readString();
      this.iag = paramParcel.readString();
      AppMethodBeat.o(131468);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label209;
      bool1 = false;
      break label224;
      bool1 = false;
      break label239;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(131469);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.hZN);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.hZO);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.hZP);
    if (this.hKA)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.cvs);
      paramParcel.writeString(this.hko);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.hZT);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.cmF);
      paramParcel.writeString(this.hZU);
      paramParcel.writeString(this.hZV);
      paramParcel.writeString(this.hZW);
      if (!this.withShareTicket) {
        break label425;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.hZX) {
        break label430;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.hZY) {
        break label435;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.fhC);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.fmF);
      paramParcel.writeString(this.iaa);
      paramParcel.writeList(this.iah);
      paramParcel.writeString(this.cJg);
      paramParcel.writeInt(this.bDc);
      paramParcel.writeInt(this.dqS);
      paramParcel.writeString(this.hZQ);
      paramParcel.writeInt(this.hZS);
      paramParcel.writeInt(this.hZR);
      paramParcel.writeString(this.iab);
      paramParcel.writeString(this.iac);
      paramParcel.writeString(this.iad);
      paramParcel.writeString(this.iae);
      if (!this.hZZ) {
        break label440;
      }
    }
    label425:
    label430:
    label435:
    label440:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.cHH);
      paramParcel.writeString(this.iaf);
      paramParcel.writeString(this.iag);
      AppMethodBeat.o(131469);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label213;
      paramInt = 0;
      break label228;
      paramInt = 0;
      break label242;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */