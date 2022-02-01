package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.a;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SendAppMessageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SendAppMessageTask> CREATOR;
  public int aAS;
  public String appId;
  public int cIB;
  public String cacheKey;
  public int cfU;
  public String dbt;
  public String description;
  public int dkC;
  public String dyw;
  public String dzY;
  public int evH;
  public String gFL;
  public boolean gFM;
  public String gFz;
  public String gIj;
  public String iconUrl;
  public boolean jOD;
  public String jfT;
  public int jwB;
  public Runnable jwt;
  public boolean kjW;
  public boolean kjX;
  public String kkB;
  public String kkC;
  public String kkD;
  public String kkE;
  public int kkF;
  public String kkG;
  public String kkH;
  public String kkI;
  public boolean kkJ;
  public String kkK;
  public String kkL;
  public String kkM;
  public String kkN;
  public String kkO;
  public String kkP;
  public ArrayList<ShareInfo> kkQ;
  public boolean kkc;
  public String kkj;
  public String nickname;
  public String path;
  public int scene;
  public int shareCount;
  public int subType;
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
    AppMethodBeat.i(46809);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46809);
  }
  
  public SendAppMessageTask()
  {
    AppMethodBeat.i(46798);
    this.kkF = 1;
    this.evH = k.a.gGZ.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.gFM = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.kkF = 1;
    this.evH = k.a.gGZ.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.gFM = false;
    e(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.apB().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!bt.isNullOrNil(this.kkB))
    {
      paramb = new sb();
      paramb.dxJ.dxK = paramString;
      paramb.dxJ.content = this.kkB;
      paramb.dxJ.type = com.tencent.mm.model.w.tq(paramString);
      paramb.dxJ.flags = 0;
      com.tencent.mm.sdk.b.a.ESL.l(paramb);
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((c)g.ab(c.class)).apV().tL(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!com.tencent.mm.model.w.pF(paramString)) {
        break label218;
      }
    }
    label218:
    for (int j = 2;; j = 1)
    {
      r.a(this.appId, paramInt, this.dbt, this.kkG, paramString, this.title, this.path, this.kkH, this.kkI, i, paramStringBuilder.toString(), this.kkK, this.cIB, this.kkC, this.aAS, j);
      AppMethodBeat.o(46802);
      return;
      i = 0;
      break;
    }
  }
  
  private void b(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46803);
    a(paramb, paramArrayOfByte, paramString, paramStringBuilder, paramInt);
    AppMethodBeat.o(46803);
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(46800);
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(46800);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(46799);
    ad.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.kkC });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!bt.isNullOrNil(this.kkC)) && ((this.kkC.startsWith("http://")) || (this.kkC.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.aub().a(this.kkC, null);
    }
    for (;;)
    {
      Object localObject3;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ad.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(-1);
        ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ad.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", new Object[] { localObject2 });
        ((Bitmap)localObject2).recycle();
        label196:
        ad.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.kkC });
        localObject2 = y.tD("wxapp_" + this.appId + this.path);
        y.arz().E((String)localObject2, true).m("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).gJE = this.userName;
        ((k.b)localObject2).gJD = this.path;
        ((k.b)localObject2).gJF = this.appId;
        ((k.b)localObject2).gJQ = this.dkC;
        ((k.b)localObject2).gJR = this.version;
        ((k.b)localObject2).gJH = this.jfT;
        ((k.b)localObject2).gJG = this.type;
        ((k.b)localObject2).gJN = this.jwB;
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).gJS = this.iconUrl;
        ((k.b)localObject2).dxF = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).dxz = this.userName;
        ((k.b)localObject2).dxA = this.nickname;
        localObject4 = new com.tencent.mm.ai.a();
        ((com.tencent.mm.ai.a)localObject4).gFm = this.kjW;
        ((com.tencent.mm.ai.a)localObject4).gFn = this.cacheKey;
        ((com.tencent.mm.ai.a)localObject4).gFo = this.cIB;
        ((com.tencent.mm.ai.a)localObject4).gFp = this.kjX;
        ((com.tencent.mm.ai.a)localObject4).gFA = this.dzY;
        ((com.tencent.mm.ai.a)localObject4).gFC = this.kkC;
        ((com.tencent.mm.ai.a)localObject4).gFD = bt.isNullOrNil(this.kkC);
        ((com.tencent.mm.ai.a)localObject4).gFy = this.cfU;
        ((com.tencent.mm.ai.a)localObject4).gFM = this.gFM;
        ((com.tencent.mm.ai.a)localObject4).gFB = this.subType;
        ((k.b)localObject2).a((com.tencent.mm.ai.f)localObject4);
        localObject3 = r.by(this.appId, this.shareCount);
        ((k.b)localObject2).gJJ = ((StringBuilder)localObject3).toString();
        if (1 != this.kkF) {
          break label983;
        }
        ((k.b)localObject2).type = 33;
      }
      for (;;)
      {
        ad.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b", new Object[] { Boolean.valueOf(this.kjX), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.kkc) });
        if (((!this.kjX) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.kkc)) {
          break label1234;
        }
        int i = this.scene;
        boolean bool = this.kjX;
        localObject4 = this.gIj;
        Object localObject5 = new b.a();
        ((b.a)localObject5).funcId = 1118;
        ((b.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        due localdue = new due();
        localdue.dlB = this.appId;
        LinkedList localLinkedList = new LinkedList(bt.S(this.toUser.split(",")));
        localdue.EID = localLinkedList;
        localdue.EIF = ((String)localObject4);
        localdue.EIE = bool;
        localdue.EIG = this.kkc;
        localdue.EtQ = this.gFz;
        ((b.a)localObject5).gUU = localdue;
        ((b.a)localObject5).gUV = new duf();
        x.a(((b.a)localObject5).atI(), new SendAppMessageTask.1(this, localLinkedList, (k.b)localObject2, i, (byte[])localObject1, (StringBuilder)localObject3));
        AppMethodBeat.o(46799);
        return;
        if (bt.isNullOrNil(this.kkD)) {
          break label1302;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.aFi(this.kkD);
        if (this.jOD)
        {
          bool = i.deleteFile(this.kkD);
          ad.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.kkD, Boolean.valueOf(bool) });
          break;
        }
        ad.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.kkD });
        break;
        ad.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label196;
        label983:
        if (2 == this.kkF)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).gJL = this.evH;
          ((k.b)localObject2).gJM = this.kkE;
        }
        else if (this.kkF == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.kkL;
          ((k.b)localObject2).appName = this.kkM;
          ((k.b)localObject2).dxz = this.kkN;
          ((k.b)localObject2).dxA = null;
          ((com.tencent.mm.ai.a)localObject4).appThumbUrl = this.kkO;
        }
        else if (this.kkF == 4)
        {
          ((k.b)localObject2).type = 48;
          l.aAk(com.tencent.mm.loader.j.b.aiL());
          localObject5 = com.tencent.mm.loader.j.b.aiL() + this.dyw;
          if (!((String)localObject5).equals(this.videoPath)) {
            ad.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(i.lC(this.videoPath, (String)localObject5)) });
          }
          ((com.tencent.mm.ai.a)localObject4).gFH = ((String)localObject5);
          ((com.tencent.mm.ai.a)localObject4).dyw = this.dyw;
          ((com.tencent.mm.ai.a)localObject4).gFJ = this.kkj;
          ((com.tencent.mm.ai.a)localObject4).gFL = this.gFL;
        }
        else if (this.kkF == 5)
        {
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).thumburl = this.kkC;
        }
      }
      label1234:
      Object localObject4 = new LinkedList(bt.S(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1302:
      localObject1 = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(46804);
    this.appId = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.kkB = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.kkC = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.kkD = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.jOD = bool1;
      this.dkC = paramParcel.readInt();
      this.jfT = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.shareCount = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.dbt = paramParcel.readString();
      this.kkG = paramParcel.readString();
      this.kkH = paramParcel.readString();
      this.kkI = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label490;
      }
      bool1 = true;
      label209:
      this.withShareTicket = bool1;
      if (paramParcel.readInt() != 1) {
        break label495;
      }
      bool1 = true;
      label224:
      this.kjW = bool1;
      if (paramParcel.readInt() != 1) {
        break label500;
      }
      bool1 = true;
      label239:
      this.kjX = bool1;
      this.gIj = paramParcel.readString();
      this.cacheKey = paramParcel.readString();
      this.cIB = paramParcel.readInt();
      this.kkK = paramParcel.readString();
      this.kkQ = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.dzY = paramParcel.readString();
      this.aAS = paramParcel.readInt();
      this.evH = paramParcel.readInt();
      this.kkE = paramParcel.readString();
      this.jwB = paramParcel.readInt();
      this.kkF = paramParcel.readInt();
      this.kkL = paramParcel.readString();
      this.kkM = paramParcel.readString();
      this.kkN = paramParcel.readString();
      this.kkO = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label505;
      }
      bool1 = true;
      label379:
      this.kkJ = bool1;
      this.videoPath = paramParcel.readString();
      this.dyw = paramParcel.readString();
      this.kkP = paramParcel.readString();
      this.kkj = paramParcel.readString();
      this.gFL = paramParcel.readString();
      this.cfU = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label510;
      }
      bool1 = true;
      label442:
      this.kkc = bool1;
      this.gFz = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label515;
      }
    }
    label515:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gFM = bool1;
      this.subType = paramParcel.readInt();
      AppMethodBeat.o(46804);
      return;
      bool1 = false;
      break;
      label490:
      bool1 = false;
      break label209;
      label495:
      bool1 = false;
      break label224;
      label500:
      bool1 = false;
      break label239;
      label505:
      bool1 = false;
      break label379;
      label510:
      bool1 = false;
      break label442;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(46805);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.kkB);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.kkC);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.kkD);
    if (this.jOD)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.dkC);
      paramParcel.writeString(this.jfT);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.shareCount);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.dbt);
      paramParcel.writeString(this.kkG);
      paramParcel.writeString(this.kkH);
      paramParcel.writeString(this.kkI);
      if (!this.withShareTicket) {
        break label485;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.kjW) {
        break label490;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.kjX) {
        break label495;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.gIj);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.cIB);
      paramParcel.writeString(this.kkK);
      paramParcel.writeList(this.kkQ);
      paramParcel.writeString(this.dzY);
      paramParcel.writeInt(this.aAS);
      paramParcel.writeInt(this.evH);
      paramParcel.writeString(this.kkE);
      paramParcel.writeInt(this.jwB);
      paramParcel.writeInt(this.kkF);
      paramParcel.writeString(this.kkL);
      paramParcel.writeString(this.kkM);
      paramParcel.writeString(this.kkN);
      paramParcel.writeString(this.kkO);
      if (!this.kkJ) {
        break label500;
      }
      paramInt = 1;
      label376:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.dyw);
      paramParcel.writeString(this.kkP);
      paramParcel.writeString(this.kkj);
      paramParcel.writeString(this.gFL);
      paramParcel.writeInt(this.cfU);
      if (!this.kkc) {
        break label505;
      }
      paramInt = 1;
      label438:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.gFz);
      if (!this.gFM) {
        break label510;
      }
    }
    label485:
    label490:
    label495:
    label500:
    label505:
    label510:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.subType);
      AppMethodBeat.o(46805);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label213;
      paramInt = 0;
      break label228;
      paramInt = 0;
      break label242;
      paramInt = 0;
      break label376;
      paramInt = 0;
      break label438;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */