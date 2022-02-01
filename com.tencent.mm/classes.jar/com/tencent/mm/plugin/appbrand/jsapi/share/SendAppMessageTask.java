package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.autogen.mmdata.rpt.uj;
import com.tencent.mm.autogen.mmdata.rpt.uj.a;
import com.tencent.mm.autogen.mmdata.rpt.uj.b;
import com.tencent.mm.autogen.mmdata.rpt.uj.c;
import com.tencent.mm.autogen.mmdata.rpt.uj.d;
import com.tencent.mm.autogen.mmdata.rpt.uj.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.a;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.fbt;
import com.tencent.mm.protocal.protobuf.fnp;
import com.tencent.mm.protocal.protobuf.gkc;
import com.tencent.mm.protocal.protobuf.gkd;
import com.tencent.mm.protocal.protobuf.gkr;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
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
  public String description;
  public int hJK;
  public int hyY;
  public String hzx;
  public String ibd;
  public String iconUrl;
  public String idf;
  public String mgR;
  public int nOX;
  public String nOY;
  public String nPk;
  public boolean nPl;
  public String nSg;
  public String nickname;
  public int opX;
  public String path;
  public boolean rSD;
  public String rcM;
  public Runnable rxj;
  public int rxs;
  public int scene;
  public int serviceType;
  public String suA;
  public String suE;
  public String suF;
  public String suZ;
  public int subType;
  public boolean suj;
  public boolean suk;
  public boolean sul;
  public boolean sur;
  public int sut;
  public String suu;
  public String sva;
  public String svb;
  public String svc;
  public int svd;
  public int sve;
  public String svf;
  public String svg;
  public String svh;
  public boolean svi;
  public String svj;
  public String svk;
  public String svl;
  public String svm;
  public String svn;
  public ArrayList<ShareInfo> svo;
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
    this.svd = 1;
    this.hyY = k.a.nQY.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.nPl = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.svd = 1;
    this.hyY = k.a.nQY.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.nPl = false;
    h(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.bwq().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!Util.isNullOrNil(this.suZ))
    {
      paramb = new wp();
      paramb.iak.hgl = paramString;
      paramb.iak.content = this.suZ;
      paramb.iak.type = ab.IX(paramString);
      paramb.iak.flags = 0;
      paramb.publish();
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!au.bwE(paramString)) {
        break label219;
      }
    }
    label219:
    for (int j = 2;; j = 1)
    {
      x.a(this.appId, paramInt, this.hzx, this.svf, paramString, this.title, this.path, this.svg, this.svh, i, paramStringBuilder.toString(), this.suu, this.serviceType, this.sva, this.appVersion, j, this.idf);
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
  
  public final void asn()
  {
    int i = 3;
    AppMethodBeat.i(46799);
    Log.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.sva });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!Util.isNullOrNil(this.sva)) && ((this.sva.startsWith("http://")) || (this.sva.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.bEY().a(this.sva, null);
    }
    for (;;)
    {
      Object localObject3;
      label208:
      Object localObject5;
      label736:
      final int j;
      boolean bool1;
      gkc localgkc;
      final LinkedList localLinkedList;
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
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.sva });
        localObject2 = ad.Jo("wxapp_" + this.appId + this.path);
        ad.bCb().M((String)localObject2, true).q("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).nTD = this.userName;
        ((k.b)localObject2).nTC = this.path;
        ((k.b)localObject2).nTE = this.appId;
        ((k.b)localObject2).nTW = this.hJK;
        ((k.b)localObject2).nTX = this.version;
        ((k.b)localObject2).nTG = this.rcM;
        ((k.b)localObject2).nTF = this.type;
        ((k.b)localObject2).nTM = this.rxs;
        ((k.b)localObject2).nTP = this.opX;
        if (this.opX != 0) {
          ((k.b)localObject2).nTM = 1;
        }
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).nTY = this.iconUrl;
        ((k.b)localObject2).iag = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).iaa = this.userName;
        ((k.b)localObject2).iab = this.nickname;
        localObject4 = new a();
        ((a)localObject4).nOK = this.suj;
        ((a)localObject4).nOL = this.mgR;
        ((a)localObject4).nOM = this.serviceType;
        ((a)localObject4).nON = this.suk;
        ((a)localObject4).nOZ = this.idf;
        ((a)localObject4).imageUrl = this.sva;
        ((a)localObject4).nPc = Util.isNullOrNil(this.sva);
        ((a)localObject4).nOX = this.nOX;
        ((a)localObject4).nPl = this.nPl;
        ((a)localObject4).nPa = this.subType;
        ((k.b)localObject2).a((f)localObject4);
        localObject3 = x.cJ(this.appId, this.sve);
        ((k.b)localObject2).nTI = ((StringBuilder)localObject3).toString();
        localObject5 = new y();
        ((y)localObject5).svF = 1;
        ((y)localObject5).svG = this.title;
        ((y)localObject5).svH = this.path;
        ((y)localObject5).svI = this.sva;
        ((y)localObject5).svJ = this.sut;
        z.a(((k.b)localObject2).nTI, (y)localObject5);
        if (1 != this.svd) {
          break label1122;
        }
        ((k.b)localObject2).type = 33;
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b isPrivateMsg:%b", new Object[] { Boolean.valueOf(this.suk), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.sur), Boolean.valueOf(this.sul) });
        if (((!this.suk) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.sur) && (!this.sul)) {
          break label1397;
        }
        j = this.scene;
        bool1 = this.suk;
        boolean bool2 = this.sul;
        localObject4 = this.nSg;
        localObject5 = new c.a();
        ((c.a)localObject5).funcId = 1118;
        ((c.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        localgkc = new gkc();
        localgkc.appid = this.appId;
        localLinkedList = new LinkedList(Util.stringsToList(this.toUser.split(",")));
        localgkc.acfY = localLinkedList;
        localgkc.acga = ((String)localObject4);
        localgkc.acfZ = bool1;
        localgkc.acgb = this.sur;
        localgkc.abNC = this.nOY;
        localgkc.acgc = bool2;
        if (!bool2) {
          break label1392;
        }
      }
      for (;;)
      {
        localgkc.ZFJ = i;
        ((c.a)localObject5).otE = localgkc;
        ((c.a)localObject5).otF = new gkd();
        com.tencent.mm.am.z.a(((c.a)localObject5).bEF(), new z.a()
        {
          public final int callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc, p paramAnonymousp)
          {
            AppMethodBeat.i(46796);
            Log.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramAnonymousString = (gkd)c.c.b(paramAnonymousc.otC);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null) && (!Util.isNullOrNil(paramAnonymousString.acgd)))
            {
              paramAnonymousp = paramAnonymousString.acgd;
              SendAppMessageTask.this.svo = new ArrayList();
              paramAnonymousInt1 = 0;
              if (paramAnonymousInt1 < localLinkedList.size())
              {
                label120:
                a locala;
                uj localuj;
                if (paramAnonymousInt1 < paramAnonymousp.size())
                {
                  paramAnonymousString = (gkr)paramAnonymousp.get(paramAnonymousInt1);
                  this.svq.nTJ = paramAnonymousString.abBw;
                  SendAppMessageTask.this.svo.add(new ShareInfo(paramAnonymousString.abBw, paramAnonymousString.acgx));
                  locala = (a)this.svq.aK(a.class);
                  locala.nON = paramAnonymousString.acfZ;
                  locala.nPb = paramAnonymousString.acgc;
                  if ((paramAnonymousString.acfZ) && (paramAnonymousString.acgy != null))
                  {
                    locala.nOO = paramAnonymousString.acgy.content;
                    locala.nOP = paramAnonymousString.acgy.abBq;
                    locala.nOQ = paramAnonymousString.acgy.abBr;
                    locala.nOR = paramAnonymousString.acgy.abBs;
                    locala.nOS = paramAnonymousString.acgy.abBt;
                    locala.nOT = paramAnonymousString.acgy.abBv;
                    locala.nOV = paramAnonymousString.acgy.state;
                    locala.nOU = paramAnonymousString.acgy.abBu;
                    localuj = new uj().Ad(SendAppMessageTask.this.appId).Ae(SendAppMessageTask.this.path).Af(paramAnonymousString.abBw).Ag((String)localLinkedList.get(paramAnonymousInt1));
                    if (!((String)localLinkedList.get(paramAnonymousInt1)).toLowerCase().endsWith("@chatroom")) {
                      break label551;
                    }
                  }
                }
                label551:
                for (paramAnonymousc = uj.c.jHe;; paramAnonymousc = uj.c.jHf)
                {
                  localuj.jGL = paramAnonymousc;
                  localuj.jGM = uj.b.jGY;
                  localuj.iqr = j;
                  paramAnonymousc = localuj.Ah(SendAppMessageTask.this.hzx);
                  paramAnonymousc.jGP = uj.a.pk(SendAppMessageTask.this.serviceType + 1000);
                  paramAnonymousc = paramAnonymousc.aJl();
                  paramAnonymousc.jGN = uj.d.jHi;
                  paramAnonymousc.jGO = uj.e.jHm;
                  paramAnonymousc.bMH();
                  if ((paramAnonymousString.acgb) && (paramAnonymousString.acgz != null) && (paramAnonymousString.acgz.abNB)) {
                    locala.nOY = paramAnonymousString.acgz.abNC;
                  }
                  SendAppMessageTask.a(SendAppMessageTask.this, this.svq, this.nMM, (String)localLinkedList.get(paramAnonymousInt1), this.svr, j);
                  paramAnonymousInt1 += 1;
                  break;
                  paramAnonymousString = new gkr();
                  break label120;
                }
              }
            }
            else
            {
              if (this.svq.nTF == 3) {
                this.svq.nTF = 2;
              }
              paramAnonymousString = localLinkedList.iterator();
              while (paramAnonymousString.hasNext())
              {
                paramAnonymousc = (String)paramAnonymousString.next();
                SendAppMessageTask.a(SendAppMessageTask.this, this.svq, this.nMM, paramAnonymousc, this.svr, j);
              }
            }
            SendAppMessageTask.a(SendAppMessageTask.this);
            AppMethodBeat.o(46796);
            return 0;
          }
        });
        AppMethodBeat.o(46799);
        return;
        if (Util.isNullOrNil(this.svb)) {
          break label1466;
        }
        localObject1 = BitmapUtil.getBitmapNative(this.svb);
        if (this.rSD)
        {
          bool1 = com.tencent.mm.vfs.y.deleteFile(this.svb);
          Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.svb, Boolean.valueOf(bool1) });
          break;
        }
        Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.svb });
        break;
        Log.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label208;
        label1122:
        if (2 == this.svd)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).nTK = this.hyY;
          ((k.b)localObject2).nTL = this.svc;
          ((k.b)localObject2).nTN = this.suE;
          ((k.b)localObject2).nTO = this.suF;
          break label736;
        }
        if (this.svd == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.svj;
          ((k.b)localObject2).appName = this.svk;
          ((k.b)localObject2).iaa = this.svl;
          ((k.b)localObject2).iab = null;
          ((a)localObject4).appThumbUrl = this.svm;
          break label736;
        }
        if (this.svd == 4)
        {
          ((k.b)localObject2).type = 48;
          FilePathGenerator.checkMkdir(com.tencent.mm.loader.i.b.bne());
          localObject5 = com.tencent.mm.loader.i.b.bne() + this.ibd;
          if (!((String)localObject5).equals(this.videoPath)) {
            Log.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(com.tencent.mm.vfs.y.O(this.videoPath, (String)localObject5, false)) });
          }
          ((a)localObject4).nPg = ((String)localObject5);
          ((a)localObject4).ibd = this.ibd;
          ((a)localObject4).nPi = this.suA;
          ((a)localObject4).nPk = this.nPk;
          break label736;
        }
        if (this.svd != 5) {
          break label736;
        }
        ((k.b)localObject2).type = 5;
        ((k.b)localObject2).thumburl = this.sva;
        break label736;
        label1392:
        i = 0;
      }
      label1397:
      Object localObject4 = new LinkedList(Util.stringsToList(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1466:
      localObject1 = null;
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(46800);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(46800);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void h(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(46804);
    this.appId = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.title = paramParcel.readString();
    this.description = paramParcel.readString();
    this.suZ = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.sva = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.svb = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.rSD = bool1;
      this.hJK = paramParcel.readInt();
      this.rcM = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.sve = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.hzx = paramParcel.readString();
      this.svf = paramParcel.readString();
      this.svg = paramParcel.readString();
      this.svh = paramParcel.readString();
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
      this.suj = bool1;
      if (paramParcel.readInt() != 1) {
        break label547;
      }
      bool1 = true;
      label239:
      this.suk = bool1;
      this.nSg = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label552;
      }
      bool1 = true;
      label262:
      this.sul = bool1;
      this.mgR = paramParcel.readString();
      this.serviceType = paramParcel.readInt();
      this.suu = paramParcel.readString();
      this.svo = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.idf = paramParcel.readString();
      this.appVersion = paramParcel.readInt();
      this.hyY = paramParcel.readInt();
      this.svc = paramParcel.readString();
      this.rxs = paramParcel.readInt();
      this.svd = paramParcel.readInt();
      this.svj = paramParcel.readString();
      this.svk = paramParcel.readString();
      this.svl = paramParcel.readString();
      this.svm = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label557;
      }
      bool1 = true;
      label394:
      this.svi = bool1;
      this.videoPath = paramParcel.readString();
      this.ibd = paramParcel.readString();
      this.svn = paramParcel.readString();
      this.suA = paramParcel.readString();
      this.nPk = paramParcel.readString();
      this.nOX = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label562;
      }
      bool1 = true;
      label457:
      this.sur = bool1;
      this.nOY = paramParcel.readString();
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
      this.nPl = bool1;
      this.subType = paramParcel.readInt();
      this.suE = paramParcel.readString();
      this.suF = paramParcel.readString();
      this.sut = paramParcel.readInt();
      this.opX = paramParcel.readInt();
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
    paramParcel.writeString(this.suZ);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.sva);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.svb);
    if (this.rSD)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hJK);
      paramParcel.writeString(this.rcM);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.sve);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.hzx);
      paramParcel.writeString(this.svf);
      paramParcel.writeString(this.svg);
      paramParcel.writeString(this.svh);
      if (!this.withShareTicket) {
        break label531;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.suj) {
        break label536;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.suk) {
        break label541;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.nSg);
      if (!this.sul) {
        break label546;
      }
      paramInt = 1;
      label264:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mgR);
      paramParcel.writeInt(this.serviceType);
      paramParcel.writeString(this.suu);
      paramParcel.writeList(this.svo);
      paramParcel.writeString(this.idf);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.hyY);
      paramParcel.writeString(this.svc);
      paramParcel.writeInt(this.rxs);
      paramParcel.writeInt(this.svd);
      paramParcel.writeString(this.svj);
      paramParcel.writeString(this.svk);
      paramParcel.writeString(this.svl);
      paramParcel.writeString(this.svm);
      if (!this.svi) {
        break label551;
      }
      paramInt = 1;
      label390:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.ibd);
      paramParcel.writeString(this.svn);
      paramParcel.writeString(this.suA);
      paramParcel.writeString(this.nPk);
      paramParcel.writeInt(this.nOX);
      if (!this.sur) {
        break label556;
      }
      paramInt = 1;
      label452:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.nOY);
      if (!this.nPl) {
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
      paramParcel.writeString(this.suE);
      paramParcel.writeString(this.suF);
      paramParcel.writeInt(this.sut);
      paramParcel.writeInt(this.opX);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */