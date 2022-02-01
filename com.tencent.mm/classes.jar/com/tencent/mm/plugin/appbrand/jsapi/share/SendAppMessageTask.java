package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.a;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public int aBM;
  public String appId;
  public int cFI;
  public String cYP;
  public String cacheKey;
  public int ccR;
  public String description;
  public int dib;
  public String dwi;
  public String dxK;
  public int eyd;
  public String hga;
  public String hgm;
  public boolean hgn;
  public String hiK;
  public String iconUrl;
  public String jGi;
  public Runnable jWP;
  public int jWX;
  public String kLA;
  public String kLS;
  public String kLT;
  public String kLU;
  public String kLV;
  public int kLW;
  public int kLX;
  public String kLY;
  public String kLZ;
  public boolean kLn;
  public boolean kLo;
  public boolean kLt;
  public String kMa;
  public boolean kMb;
  public String kMc;
  public String kMd;
  public String kMe;
  public String kMf;
  public String kMg;
  public String kMh;
  public ArrayList<ShareInfo> kMi;
  public boolean kpe;
  public String nickname;
  public String path;
  public int scene;
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
    this.kLW = 1;
    this.eyd = k.a.hhA.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.hgn = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.kLW = 1;
    this.eyd = k.a.hhA.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.hgn = false;
    e(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.awq().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!bs.isNullOrNil(this.kLS))
    {
      paramb = new sk();
      paramb.dvv.dvw = paramString;
      paramb.dvv.content = this.kLS;
      paramb.dvv.type = com.tencent.mm.model.w.xt(paramString);
      paramb.dvv.flags = 0;
      com.tencent.mm.sdk.b.a.GpY.l(paramb);
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((c)g.ab(c.class)).awK().xR(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!com.tencent.mm.model.w.sQ(paramString)) {
        break label218;
      }
    }
    label218:
    for (int j = 2;; j = 1)
    {
      r.a(this.appId, paramInt, this.cYP, this.kLY, paramString, this.title, this.path, this.kLZ, this.kMa, i, paramStringBuilder.toString(), this.kMc, this.cFI, this.kLT, this.aBM, j);
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
  
  public final void aLq()
  {
    AppMethodBeat.i(46799);
    ac.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.kLT });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!bs.isNullOrNil(this.kLT)) && ((this.kLT.startsWith("http://")) || (this.kLT.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.aAS().a(this.kLT, null);
    }
    for (;;)
    {
      Object localObject3;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ac.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(-1);
        ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ac.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", new Object[] { localObject2 });
        ((Bitmap)localObject2).recycle();
        label196:
        ac.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.kLT });
        localObject2 = y.xJ("wxapp_" + this.appId + this.path);
        y.ayq().F((String)localObject2, true).l("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).hke = this.userName;
        ((k.b)localObject2).hkd = this.path;
        ((k.b)localObject2).hkf = this.appId;
        ((k.b)localObject2).hkq = this.dib;
        ((k.b)localObject2).hkr = this.version;
        ((k.b)localObject2).hkh = this.jGi;
        ((k.b)localObject2).hkg = this.type;
        ((k.b)localObject2).hkn = this.jWX;
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).hks = this.iconUrl;
        ((k.b)localObject2).dvr = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).dvl = this.userName;
        ((k.b)localObject2).dvm = this.nickname;
        localObject4 = new com.tencent.mm.ah.a();
        ((com.tencent.mm.ah.a)localObject4).hfN = this.kLn;
        ((com.tencent.mm.ah.a)localObject4).hfO = this.cacheKey;
        ((com.tencent.mm.ah.a)localObject4).hfP = this.cFI;
        ((com.tencent.mm.ah.a)localObject4).hfQ = this.kLo;
        ((com.tencent.mm.ah.a)localObject4).hgb = this.dxK;
        ((com.tencent.mm.ah.a)localObject4).hgd = this.kLT;
        ((com.tencent.mm.ah.a)localObject4).hge = bs.isNullOrNil(this.kLT);
        ((com.tencent.mm.ah.a)localObject4).hfZ = this.ccR;
        ((com.tencent.mm.ah.a)localObject4).hgn = this.hgn;
        ((com.tencent.mm.ah.a)localObject4).hgc = this.subType;
        ((k.b)localObject2).a((com.tencent.mm.ah.f)localObject4);
        localObject3 = r.bC(this.appId, this.kLX);
        ((k.b)localObject2).hkj = ((StringBuilder)localObject3).toString();
        if (1 != this.kLW) {
          break label983;
        }
        ((k.b)localObject2).type = 33;
      }
      for (;;)
      {
        ac.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b", new Object[] { Boolean.valueOf(this.kLo), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.kLt) });
        if (((!this.kLo) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.kLt)) {
          break label1234;
        }
        int i = this.scene;
        boolean bool = this.kLo;
        localObject4 = this.hiK;
        Object localObject5 = new b.a();
        ((b.a)localObject5).funcId = 1118;
        ((b.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        dzv localdzv = new dzv();
        localdzv.djj = this.appId;
        LinkedList localLinkedList = new LinkedList(bs.S(this.toUser.split(",")));
        localdzv.GfP = localLinkedList;
        localdzv.GfR = ((String)localObject4);
        localdzv.GfQ = bool;
        localdzv.GfS = this.kLt;
        localdzv.FQS = this.hga;
        ((b.a)localObject5).hvt = localdzv;
        ((b.a)localObject5).hvu = new dzw();
        x.a(((b.a)localObject5).aAz(), new SendAppMessageTask.1(this, localLinkedList, (k.b)localObject2, i, (byte[])localObject1, (StringBuilder)localObject3));
        AppMethodBeat.o(46799);
        return;
        if (bs.isNullOrNil(this.kLU)) {
          break label1302;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.aKz(this.kLU);
        if (this.kpe)
        {
          bool = i.deleteFile(this.kLU);
          ac.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.kLU, Boolean.valueOf(bool) });
          break;
        }
        ac.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.kLU });
        break;
        ac.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label196;
        label983:
        if (2 == this.kLW)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).hkl = this.eyd;
          ((k.b)localObject2).hkm = this.kLV;
        }
        else if (this.kLW == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.kMd;
          ((k.b)localObject2).appName = this.kMe;
          ((k.b)localObject2).dvl = this.kMf;
          ((k.b)localObject2).dvm = null;
          ((com.tencent.mm.ah.a)localObject4).appThumbUrl = this.kMg;
        }
        else if (this.kLW == 4)
        {
          ((k.b)localObject2).type = 48;
          l.aFC(com.tencent.mm.loader.j.b.apL());
          localObject5 = com.tencent.mm.loader.j.b.apL() + this.dwi;
          if (!((String)localObject5).equals(this.videoPath)) {
            ac.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(i.lZ(this.videoPath, (String)localObject5)) });
          }
          ((com.tencent.mm.ah.a)localObject4).hgi = ((String)localObject5);
          ((com.tencent.mm.ah.a)localObject4).dwi = this.dwi;
          ((com.tencent.mm.ah.a)localObject4).hgk = this.kLA;
          ((com.tencent.mm.ah.a)localObject4).hgm = this.hgm;
        }
        else if (this.kLW == 5)
        {
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).thumburl = this.kLT;
        }
      }
      label1234:
      Object localObject4 = new LinkedList(bs.S(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1302:
      localObject1 = null;
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(46800);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(46800);
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
    this.kLS = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.kLT = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.kLU = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.kpe = bool1;
      this.dib = paramParcel.readInt();
      this.jGi = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.kLX = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.cYP = paramParcel.readString();
      this.kLY = paramParcel.readString();
      this.kLZ = paramParcel.readString();
      this.kMa = paramParcel.readString();
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
      this.kLn = bool1;
      if (paramParcel.readInt() != 1) {
        break label500;
      }
      bool1 = true;
      label239:
      this.kLo = bool1;
      this.hiK = paramParcel.readString();
      this.cacheKey = paramParcel.readString();
      this.cFI = paramParcel.readInt();
      this.kMc = paramParcel.readString();
      this.kMi = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.dxK = paramParcel.readString();
      this.aBM = paramParcel.readInt();
      this.eyd = paramParcel.readInt();
      this.kLV = paramParcel.readString();
      this.jWX = paramParcel.readInt();
      this.kLW = paramParcel.readInt();
      this.kMd = paramParcel.readString();
      this.kMe = paramParcel.readString();
      this.kMf = paramParcel.readString();
      this.kMg = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label505;
      }
      bool1 = true;
      label379:
      this.kMb = bool1;
      this.videoPath = paramParcel.readString();
      this.dwi = paramParcel.readString();
      this.kMh = paramParcel.readString();
      this.kLA = paramParcel.readString();
      this.hgm = paramParcel.readString();
      this.ccR = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label510;
      }
      bool1 = true;
      label442:
      this.kLt = bool1;
      this.hga = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label515;
      }
    }
    label515:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hgn = bool1;
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
    paramParcel.writeString(this.kLS);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.kLT);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.kLU);
    if (this.kpe)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.dib);
      paramParcel.writeString(this.jGi);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.kLX);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.cYP);
      paramParcel.writeString(this.kLY);
      paramParcel.writeString(this.kLZ);
      paramParcel.writeString(this.kMa);
      if (!this.withShareTicket) {
        break label485;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.kLn) {
        break label490;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.kLo) {
        break label495;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hiK);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.cFI);
      paramParcel.writeString(this.kMc);
      paramParcel.writeList(this.kMi);
      paramParcel.writeString(this.dxK);
      paramParcel.writeInt(this.aBM);
      paramParcel.writeInt(this.eyd);
      paramParcel.writeString(this.kLV);
      paramParcel.writeInt(this.jWX);
      paramParcel.writeInt(this.kLW);
      paramParcel.writeString(this.kMd);
      paramParcel.writeString(this.kMe);
      paramParcel.writeString(this.kMf);
      paramParcel.writeString(this.kMg);
      if (!this.kMb) {
        break label500;
      }
      paramInt = 1;
      label376:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.dwi);
      paramParcel.writeString(this.kMh);
      paramParcel.writeString(this.kLA);
      paramParcel.writeString(this.hgm);
      paramParcel.writeInt(this.ccR);
      if (!this.kLt) {
        break label505;
      }
      paramInt = 1;
      label438:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hga);
      if (!this.hgn) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */