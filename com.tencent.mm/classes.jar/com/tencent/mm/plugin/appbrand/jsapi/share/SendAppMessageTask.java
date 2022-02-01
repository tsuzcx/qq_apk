package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.a;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.fnj;
import com.tencent.mm.protocal.protobuf.fnk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  public String appId;
  public int appVersion;
  public String cacheKey;
  public String description;
  public int fES;
  public String fVg;
  public String fXg;
  public String fvd;
  public int hDp;
  public String iconUrl;
  public String lkm;
  public String lky;
  public boolean lkz;
  public String lnb;
  public int lyw;
  public int nYp;
  public String nickname;
  public boolean oOP;
  public String obW;
  public int otE;
  public Runnable otv;
  public String path;
  public boolean ppC;
  public int ppE;
  public String ppF;
  public String ppL;
  public String ppQ;
  public String ppR;
  public boolean ppv;
  public boolean ppw;
  public boolean ppx;
  public String pqA;
  public ArrayList<ShareInfo> pqB;
  public String pqm;
  public String pqn;
  public String pqo;
  public String pqp;
  public int pqq;
  public int pqr;
  public String pqs;
  public String pqt;
  public String pqu;
  public boolean pqv;
  public String pqw;
  public String pqx;
  public String pqy;
  public String pqz;
  public int scene;
  public int serviceType;
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
    this.pqq = 1;
    this.hDp = k.a.llS.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.lkz = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.pqq = 1;
    this.hDp = k.a.llS.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.lkz = false;
    f(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.bbx().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!Util.isNullOrNil(this.pqm))
    {
      paramb = new uz();
      paramb.fUn.fcD = paramString;
      paramb.fUn.content = this.pqm;
      paramb.fUn.type = com.tencent.mm.model.ab.QZ(paramString);
      paramb.fUn.flags = 0;
      EventCenter.instance.publish(paramb);
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!com.tencent.mm.model.ab.Lj(paramString)) {
        break label222;
      }
    }
    label222:
    for (int j = 2;; j = 1)
    {
      z.a(this.appId, paramInt, this.fvd, this.pqs, paramString, this.title, this.path, this.pqt, this.pqu, i, paramStringBuilder.toString(), this.ppF, this.serviceType, this.pqn, this.appVersion, j, this.fXg);
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
  
  public final void RW()
  {
    int i = 3;
    AppMethodBeat.i(46799);
    Log.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.pqn });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!Util.isNullOrNil(this.pqn)) && ((this.pqn.startsWith("http://")) || (this.pqn.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.bhh().a(this.pqn, null);
    }
    for (;;)
    {
      Object localObject3;
      label208:
      Object localObject5;
      label736:
      int j;
      boolean bool1;
      fnj localfnj;
      LinkedList localLinkedList;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        Log.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(-1);
        ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        Log.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", new Object[] { localObject2 });
        ((Bitmap)localObject2).recycle();
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.pqn });
        localObject2 = ad.Rp("wxapp_" + this.appId + this.path);
        ad.beh().I((String)localObject2, true).k("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).loA = this.userName;
        ((k.b)localObject2).loz = this.path;
        ((k.b)localObject2).loB = this.appId;
        ((k.b)localObject2).loT = this.fES;
        ((k.b)localObject2).loU = this.version;
        ((k.b)localObject2).loD = this.obW;
        ((k.b)localObject2).loC = this.type;
        ((k.b)localObject2).loJ = this.otE;
        ((k.b)localObject2).loM = this.lyw;
        if (this.lyw != 0) {
          ((k.b)localObject2).loJ = 1;
        }
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).loV = this.iconUrl;
        ((k.b)localObject2).fUj = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).fUd = this.userName;
        ((k.b)localObject2).fUe = this.nickname;
        localObject4 = new a();
        ((a)localObject4).ljZ = this.ppv;
        ((a)localObject4).lka = this.cacheKey;
        ((a)localObject4).lkb = this.serviceType;
        ((a)localObject4).lkc = this.ppw;
        ((a)localObject4).lkn = this.fXg;
        ((a)localObject4).imageUrl = this.pqn;
        ((a)localObject4).lkq = Util.isNullOrNil(this.pqn);
        ((a)localObject4).lkl = this.nYp;
        ((a)localObject4).lkz = this.lkz;
        ((a)localObject4).lko = this.subType;
        ((k.b)localObject2).a((f)localObject4);
        localObject3 = z.ck(this.appId, this.pqr);
        ((k.b)localObject2).loF = ((StringBuilder)localObject3).toString();
        localObject5 = new aa();
        ((aa)localObject5).pqV = 1;
        ((aa)localObject5).pqW = this.title;
        ((aa)localObject5).pqX = this.path;
        ((aa)localObject5).pqY = this.pqn;
        ((aa)localObject5).pqZ = this.ppE;
        ab.a(((k.b)localObject2).loF, (aa)localObject5);
        if (1 != this.pqq) {
          break label1122;
        }
        ((k.b)localObject2).type = 33;
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b isPrivateMsg:%b", new Object[] { Boolean.valueOf(this.ppw), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.ppC), Boolean.valueOf(this.ppx) });
        if (((!this.ppw) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.ppC) && (!this.ppx)) {
          break label1396;
        }
        j = this.scene;
        bool1 = this.ppw;
        boolean bool2 = this.ppx;
        localObject4 = this.lnb;
        localObject5 = new d.a();
        ((d.a)localObject5).funcId = 1118;
        ((d.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        localfnj = new fnj();
        localfnj.appid = this.appId;
        localLinkedList = new LinkedList(Util.stringsToList(this.toUser.split(",")));
        localfnj.ULK = localLinkedList;
        localfnj.ULM = ((String)localObject4);
        localfnj.ULL = bool1;
        localfnj.ULN = this.ppC;
        localfnj.Uub = this.lkm;
        localfnj.ULO = bool2;
        if (!bool2) {
          break label1391;
        }
      }
      for (;;)
      {
        localfnj.SEl = i;
        ((d.a)localObject5).lBU = localfnj;
        ((d.a)localObject5).lBV = new fnk();
        com.tencent.mm.an.aa.a(((d.a)localObject5).bgN(), new SendAppMessageTask.1(this, localLinkedList, (k.b)localObject2, j, (byte[])localObject1, (StringBuilder)localObject3));
        AppMethodBeat.o(46799);
        return;
        if (Util.isNullOrNil(this.pqo)) {
          break label1465;
        }
        localObject1 = BitmapUtil.getBitmapNative(this.pqo);
        if (this.oOP)
        {
          bool1 = u.deleteFile(this.pqo);
          Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.pqo, Boolean.valueOf(bool1) });
          break;
        }
        Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.pqo });
        break;
        Log.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label208;
        label1122:
        if (2 == this.pqq)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).loH = this.hDp;
          ((k.b)localObject2).loI = this.pqp;
          ((k.b)localObject2).loK = this.ppQ;
          ((k.b)localObject2).loL = this.ppR;
          break label736;
        }
        if (this.pqq == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.pqw;
          ((k.b)localObject2).appName = this.pqx;
          ((k.b)localObject2).fUd = this.pqy;
          ((k.b)localObject2).fUe = null;
          ((a)localObject4).appThumbUrl = this.pqz;
          break label736;
        }
        if (this.pqq == 4)
        {
          ((k.b)localObject2).type = 48;
          FilePathGenerator.checkMkdir(com.tencent.mm.loader.j.b.aTq());
          localObject5 = com.tencent.mm.loader.j.b.aTq() + this.fVg;
          if (!((String)localObject5).equals(this.videoPath)) {
            Log.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(u.on(this.videoPath, (String)localObject5)) });
          }
          ((a)localObject4).lku = ((String)localObject5);
          ((a)localObject4).fVg = this.fVg;
          ((a)localObject4).lkw = this.ppL;
          ((a)localObject4).lky = this.lky;
          break label736;
        }
        if (this.pqq != 5) {
          break label736;
        }
        ((k.b)localObject2).type = 5;
        ((k.b)localObject2).thumburl = this.pqn;
        break label736;
        label1391:
        i = 0;
      }
      label1396:
      Object localObject4 = new LinkedList(Util.stringsToList(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1465:
      localObject1 = null;
    }
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(46800);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(46800);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(46804);
    this.appId = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.pqm = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.pqn = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.pqo = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.oOP = bool1;
      this.fES = paramParcel.readInt();
      this.obW = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.pqr = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.fvd = paramParcel.readString();
      this.pqs = paramParcel.readString();
      this.pqt = paramParcel.readString();
      this.pqu = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label537;
      }
      bool1 = true;
      label209:
      this.withShareTicket = bool1;
      if (paramParcel.readInt() != 1) {
        break label542;
      }
      bool1 = true;
      label224:
      this.ppv = bool1;
      if (paramParcel.readInt() != 1) {
        break label547;
      }
      bool1 = true;
      label239:
      this.ppw = bool1;
      this.lnb = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label552;
      }
      bool1 = true;
      label262:
      this.ppx = bool1;
      this.cacheKey = paramParcel.readString();
      this.serviceType = paramParcel.readInt();
      this.ppF = paramParcel.readString();
      this.pqB = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.fXg = paramParcel.readString();
      this.appVersion = paramParcel.readInt();
      this.hDp = paramParcel.readInt();
      this.pqp = paramParcel.readString();
      this.otE = paramParcel.readInt();
      this.pqq = paramParcel.readInt();
      this.pqw = paramParcel.readString();
      this.pqx = paramParcel.readString();
      this.pqy = paramParcel.readString();
      this.pqz = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label557;
      }
      bool1 = true;
      label394:
      this.pqv = bool1;
      this.videoPath = paramParcel.readString();
      this.fVg = paramParcel.readString();
      this.pqA = paramParcel.readString();
      this.ppL = paramParcel.readString();
      this.lky = paramParcel.readString();
      this.nYp = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label562;
      }
      bool1 = true;
      label457:
      this.ppC = bool1;
      this.lkm = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label567;
      }
    }
    label537:
    label542:
    label547:
    label552:
    label557:
    label562:
    label567:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lkz = bool1;
      this.subType = paramParcel.readInt();
      this.ppQ = paramParcel.readString();
      this.ppR = paramParcel.readString();
      this.ppE = paramParcel.readInt();
      this.lyw = paramParcel.readInt();
      AppMethodBeat.o(46804);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label209;
      bool1 = false;
      break label224;
      bool1 = false;
      break label239;
      bool1 = false;
      break label262;
      bool1 = false;
      break label394;
      bool1 = false;
      break label457;
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
    paramParcel.writeString(this.pqm);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.pqn);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.pqo);
    if (this.oOP)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.fES);
      paramParcel.writeString(this.obW);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.pqr);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.fvd);
      paramParcel.writeString(this.pqs);
      paramParcel.writeString(this.pqt);
      paramParcel.writeString(this.pqu);
      if (!this.withShareTicket) {
        break label531;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.ppv) {
        break label536;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.ppw) {
        break label541;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.lnb);
      if (!this.ppx) {
        break label546;
      }
      paramInt = 1;
      label264:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.serviceType);
      paramParcel.writeString(this.ppF);
      paramParcel.writeList(this.pqB);
      paramParcel.writeString(this.fXg);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.hDp);
      paramParcel.writeString(this.pqp);
      paramParcel.writeInt(this.otE);
      paramParcel.writeInt(this.pqq);
      paramParcel.writeString(this.pqw);
      paramParcel.writeString(this.pqx);
      paramParcel.writeString(this.pqy);
      paramParcel.writeString(this.pqz);
      if (!this.pqv) {
        break label551;
      }
      paramInt = 1;
      label390:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.fVg);
      paramParcel.writeString(this.pqA);
      paramParcel.writeString(this.ppL);
      paramParcel.writeString(this.lky);
      paramParcel.writeInt(this.nYp);
      if (!this.ppC) {
        break label556;
      }
      paramInt = 1;
      label452:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.lkm);
      if (!this.lkz) {
        break label561;
      }
    }
    label531:
    label536:
    label541:
    label546:
    label551:
    label556:
    label561:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.subType);
      paramParcel.writeString(this.ppQ);
      paramParcel.writeString(this.ppR);
      paramParcel.writeInt(this.ppE);
      paramParcel.writeInt(this.lyw);
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
      break label264;
      paramInt = 0;
      break label390;
      paramInt = 0;
      break label452;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */