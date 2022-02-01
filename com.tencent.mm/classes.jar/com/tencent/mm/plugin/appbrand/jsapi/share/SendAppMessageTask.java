package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.a;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.g.b.a.jq.a;
import com.tencent.mm.g.b.a.jq.b;
import com.tencent.mm.g.b.a.jq.c;
import com.tencent.mm.g.b.a.jq.d;
import com.tencent.mm.g.b.a.jq.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.ehq;
import com.tencent.mm.protocal.protobuf.ehr;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
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
  public int aDD;
  public String appId;
  public int cRx;
  public String cacheKey;
  public String dJw;
  public String dLl;
  public String description;
  public String dlj;
  public int duK;
  public int eRn;
  public String hAW;
  public String hBj;
  public boolean hBk;
  public String hDH;
  public String iconUrl;
  public boolean kNt;
  public int kaX;
  public String kdI;
  public int kuE;
  public Runnable kuv;
  public boolean llA;
  public boolean llB;
  public boolean llC;
  public boolean llH;
  public String llO;
  public String lmh;
  public String lmi;
  public String lmj;
  public String lmk;
  public int lml;
  public int lmm;
  public String lmn;
  public String lmo;
  public String lmp;
  public boolean lmq;
  public String lmr;
  public String lms;
  public String lmt;
  public String lmu;
  public String lmv;
  public String lmw;
  public ArrayList<ShareInfo> lmx;
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
    this.lml = 1;
    this.eRn = k.a.hCx.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.hBk = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.lml = 1;
    this.eRn = k.a.hCx.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.hBk = false;
    e(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.azs().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!bu.isNullOrNil(this.lmh))
    {
      paramb = new sy();
      paramb.dID.cUB = paramString;
      paramb.dID.content = this.lmh;
      paramb.dID.type = com.tencent.mm.model.x.Bb(paramString);
      paramb.dID.flags = 0;
      com.tencent.mm.sdk.b.a.IvT.l(paramb);
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((c)g.ab(c.class)).azP().BB(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!com.tencent.mm.model.x.wb(paramString)) {
        break label222;
      }
    }
    label222:
    for (int j = 2;; j = 1)
    {
      r.a(this.appId, paramInt, this.dlj, this.lmn, paramString, this.title, this.path, this.lmo, this.lmp, i, paramStringBuilder.toString(), this.lmr, this.cRx, this.lmi, this.aDD, j, this.dLl);
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
  
  public final void aOX()
  {
    int i = 3;
    AppMethodBeat.i(46799);
    ae.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.lmi });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!bu.isNullOrNil(this.lmi)) && ((this.lmi.startsWith("http://")) || (this.lmi.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.aEl().a(this.lmi, null);
    }
    for (;;)
    {
      Object localObject3;
      label208:
      final int j;
      label653:
      boolean bool1;
      Object localObject5;
      ehq localehq;
      final LinkedList localLinkedList;
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        ae.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
        localObject2 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(-1);
        ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        localObject1 = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ae.i("MicroMsg.SendAppMessageTask", "bitmap recycle %s", new Object[] { localObject2 });
        ((Bitmap)localObject2).recycle();
        ae.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.lmi });
        localObject2 = z.Br("wxapp_" + this.appId + this.path);
        z.aBG().F((String)localObject2, true).k("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).hFc = this.userName;
        ((k.b)localObject2).hFb = this.path;
        ((k.b)localObject2).hFd = this.appId;
        ((k.b)localObject2).hFr = this.duK;
        ((k.b)localObject2).hFs = this.version;
        ((k.b)localObject2).hFf = this.kdI;
        ((k.b)localObject2).hFe = this.type;
        ((k.b)localObject2).hFl = this.kuE;
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).hFt = this.iconUrl;
        ((k.b)localObject2).dIz = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).dIt = this.userName;
        ((k.b)localObject2).dIu = this.nickname;
        localObject4 = new com.tencent.mm.ah.a();
        ((com.tencent.mm.ah.a)localObject4).hAJ = this.llA;
        ((com.tencent.mm.ah.a)localObject4).hAK = this.cacheKey;
        ((com.tencent.mm.ah.a)localObject4).hAL = this.cRx;
        ((com.tencent.mm.ah.a)localObject4).hAM = this.llB;
        ((com.tencent.mm.ah.a)localObject4).hAX = this.dLl;
        ((com.tencent.mm.ah.a)localObject4).hBa = this.lmi;
        ((com.tencent.mm.ah.a)localObject4).hBb = bu.isNullOrNil(this.lmi);
        ((com.tencent.mm.ah.a)localObject4).hAV = this.kaX;
        ((com.tencent.mm.ah.a)localObject4).hBk = this.hBk;
        ((com.tencent.mm.ah.a)localObject4).hAY = this.subType;
        ((k.b)localObject2).a((f)localObject4);
        localObject3 = r.bI(this.appId, this.lmm);
        ((k.b)localObject2).hFh = ((StringBuilder)localObject3).toString();
        if (1 != this.lml) {
          break label1039;
        }
        ((k.b)localObject2).type = 33;
        ae.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b isPrivateMsg:%b", new Object[] { Boolean.valueOf(this.llB), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.llH), Boolean.valueOf(this.llC) });
        if (((!this.llB) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.llH) && (!this.llC)) {
          break label1295;
        }
        j = this.scene;
        bool1 = this.llB;
        boolean bool2 = this.llC;
        localObject4 = this.hDH;
        localObject5 = new b.a();
        ((b.a)localObject5).funcId = 1118;
        ((b.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        localehq = new ehq();
        localehq.dwb = this.appId;
        localLinkedList = new LinkedList(bu.U(this.toUser.split(",")));
        localehq.Ilf = localLinkedList;
        localehq.Ilh = ((String)localObject4);
        localehq.Ilg = bool1;
        localehq.Ili = this.llH;
        localehq.HVl = this.hAW;
        localehq.Ilj = bool2;
        if (!bool2) {
          break label1290;
        }
      }
      for (;;)
      {
        localehq.Hew = i;
        ((b.a)localObject5).hQF = localehq;
        ((b.a)localObject5).hQG = new ehr();
        com.tencent.mm.ak.x.a(((b.a)localObject5).aDS(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(46796);
            ae.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramAnonymousString = (ehr)paramAnonymousb.hQE.hQJ;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null) && (!bu.ht(paramAnonymousString.Ilk)))
            {
              paramAnonymousn = paramAnonymousString.Ilk;
              SendAppMessageTask.this.lmx = new ArrayList();
              paramAnonymousInt1 = 0;
              if (paramAnonymousInt1 < localLinkedList.size())
              {
                label120:
                com.tencent.mm.ah.a locala;
                jq localjq;
                if (paramAnonymousInt1 < paramAnonymousn.size())
                {
                  paramAnonymousString = (ehz)paramAnonymousn.get(paramAnonymousInt1);
                  this.lmz.hFi = paramAnonymousString.HLO;
                  SendAppMessageTask.this.lmx.add(new ShareInfo(paramAnonymousString.HLO, paramAnonymousString.Ily));
                  locala = (com.tencent.mm.ah.a)this.lmz.ao(com.tencent.mm.ah.a.class);
                  locala.hAM = paramAnonymousString.Ilg;
                  locala.hAZ = paramAnonymousString.Ilj;
                  if ((paramAnonymousString.Ilg) && (paramAnonymousString.Ilz != null))
                  {
                    locala.hAN = paramAnonymousString.Ilz.content;
                    locala.hAO = paramAnonymousString.Ilz.HLI;
                    locala.hAP = paramAnonymousString.Ilz.HLJ;
                    locala.hAQ = paramAnonymousString.Ilz.HLK;
                    locala.hAR = paramAnonymousString.Ilz.HLL;
                    locala.hAS = paramAnonymousString.Ilz.HLN;
                    locala.hAU = paramAnonymousString.Ilz.state;
                    locala.hAT = paramAnonymousString.Ilz.HLM;
                    localjq = new jq().sy(SendAppMessageTask.this.appId).sz(SendAppMessageTask.this.path).sA(paramAnonymousString.HLO).sB((String)localLinkedList.get(paramAnonymousInt1));
                    if (!((String)localLinkedList.get(paramAnonymousInt1)).toLowerCase().endsWith("@chatroom")) {
                      break label551;
                    }
                  }
                }
                label551:
                for (paramAnonymousb = jq.c.eDu;; paramAnonymousb = jq.c.eDv)
                {
                  localjq.eDa = paramAnonymousb;
                  localjq.eDb = jq.b.eDo;
                  localjq.dWt = j;
                  paramAnonymousb = localjq.sC(SendAppMessageTask.this.dlj);
                  paramAnonymousb.eDf = jq.a.jV(SendAppMessageTask.this.cRx + 1000);
                  paramAnonymousb = paramAnonymousb.VA();
                  paramAnonymousb.eDd = jq.d.eDy;
                  paramAnonymousb.eDe = jq.e.eDC;
                  paramAnonymousb.aLH();
                  if ((paramAnonymousString.Ili) && (paramAnonymousString.IlA != null) && (paramAnonymousString.IlA.HVk)) {
                    locala.hAW = paramAnonymousString.IlA.HVl;
                  }
                  SendAppMessageTask.a(SendAppMessageTask.this, this.lmz, this.hyW, (String)localLinkedList.get(paramAnonymousInt1), this.lmA, j);
                  paramAnonymousInt1 += 1;
                  break;
                  paramAnonymousString = new ehz();
                  break label120;
                }
              }
            }
            else
            {
              if (this.lmz.hFe == 3) {
                this.lmz.hFe = 2;
              }
              paramAnonymousString = localLinkedList.iterator();
              while (paramAnonymousString.hasNext())
              {
                paramAnonymousb = (String)paramAnonymousString.next();
                SendAppMessageTask.a(SendAppMessageTask.this, this.lmz, this.hyW, paramAnonymousb, this.lmA, j);
              }
            }
            SendAppMessageTask.a(SendAppMessageTask.this);
            AppMethodBeat.o(46796);
            return 0;
          }
        });
        AppMethodBeat.o(46799);
        return;
        if (bu.isNullOrNil(this.lmj)) {
          break label1364;
        }
        localObject1 = h.aRC(this.lmj);
        if (this.kNt)
        {
          bool1 = o.deleteFile(this.lmj);
          ae.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.lmj, Boolean.valueOf(bool1) });
          break;
        }
        ae.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.lmj });
        break;
        ae.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label208;
        label1039:
        if (2 == this.lml)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).hFj = this.eRn;
          ((k.b)localObject2).hFk = this.lmk;
          break label653;
        }
        if (this.lml == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.lms;
          ((k.b)localObject2).appName = this.lmt;
          ((k.b)localObject2).dIt = this.lmu;
          ((k.b)localObject2).dIu = null;
          ((com.tencent.mm.ah.a)localObject4).appThumbUrl = this.lmv;
          break label653;
        }
        if (this.lml == 4)
        {
          ((k.b)localObject2).type = 48;
          com.tencent.mm.sdk.platformtools.n.aMy(com.tencent.mm.loader.j.b.asO());
          localObject5 = com.tencent.mm.loader.j.b.asO() + this.dJw;
          if (!((String)localObject5).equals(this.videoPath)) {
            ae.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(o.mF(this.videoPath, (String)localObject5)) });
          }
          ((com.tencent.mm.ah.a)localObject4).hBf = ((String)localObject5);
          ((com.tencent.mm.ah.a)localObject4).dJw = this.dJw;
          ((com.tencent.mm.ah.a)localObject4).hBh = this.llO;
          ((com.tencent.mm.ah.a)localObject4).hBj = this.hBj;
          break label653;
        }
        if (this.lml != 5) {
          break label653;
        }
        ((k.b)localObject2).type = 5;
        ((k.b)localObject2).thumburl = this.lmi;
        break label653;
        label1290:
        i = 0;
      }
      label1295:
      Object localObject4 = new LinkedList(bu.U(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1364:
      localObject1 = null;
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(46800);
    if (this.kuv != null) {
      this.kuv.run();
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
    this.lmh = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.lmi = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.lmj = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.kNt = bool1;
      this.duK = paramParcel.readInt();
      this.kdI = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.lmm = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.dlj = paramParcel.readString();
      this.lmn = paramParcel.readString();
      this.lmo = paramParcel.readString();
      this.lmp = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label505;
      }
      bool1 = true;
      label209:
      this.withShareTicket = bool1;
      if (paramParcel.readInt() != 1) {
        break label510;
      }
      bool1 = true;
      label224:
      this.llA = bool1;
      if (paramParcel.readInt() != 1) {
        break label515;
      }
      bool1 = true;
      label239:
      this.llB = bool1;
      this.hDH = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label520;
      }
      bool1 = true;
      label262:
      this.llC = bool1;
      this.cacheKey = paramParcel.readString();
      this.cRx = paramParcel.readInt();
      this.lmr = paramParcel.readString();
      this.lmx = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.dLl = paramParcel.readString();
      this.aDD = paramParcel.readInt();
      this.eRn = paramParcel.readInt();
      this.lmk = paramParcel.readString();
      this.kuE = paramParcel.readInt();
      this.lml = paramParcel.readInt();
      this.lms = paramParcel.readString();
      this.lmt = paramParcel.readString();
      this.lmu = paramParcel.readString();
      this.lmv = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label525;
      }
      bool1 = true;
      label394:
      this.lmq = bool1;
      this.videoPath = paramParcel.readString();
      this.dJw = paramParcel.readString();
      this.lmw = paramParcel.readString();
      this.llO = paramParcel.readString();
      this.hBj = paramParcel.readString();
      this.kaX = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label530;
      }
      bool1 = true;
      label457:
      this.llH = bool1;
      this.hAW = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label535;
      }
    }
    label515:
    label520:
    label525:
    label530:
    label535:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hBk = bool1;
      this.subType = paramParcel.readInt();
      AppMethodBeat.o(46804);
      return;
      bool1 = false;
      break;
      label505:
      bool1 = false;
      break label209;
      label510:
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
    paramParcel.writeString(this.lmh);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.lmi);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.lmj);
    if (this.kNt)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.duK);
      paramParcel.writeString(this.kdI);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.lmm);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.dlj);
      paramParcel.writeString(this.lmn);
      paramParcel.writeString(this.lmo);
      paramParcel.writeString(this.lmp);
      if (!this.withShareTicket) {
        break label499;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.llA) {
        break label504;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.llB) {
        break label509;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hDH);
      if (!this.llC) {
        break label514;
      }
      paramInt = 1;
      label264:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.cRx);
      paramParcel.writeString(this.lmr);
      paramParcel.writeList(this.lmx);
      paramParcel.writeString(this.dLl);
      paramParcel.writeInt(this.aDD);
      paramParcel.writeInt(this.eRn);
      paramParcel.writeString(this.lmk);
      paramParcel.writeInt(this.kuE);
      paramParcel.writeInt(this.lml);
      paramParcel.writeString(this.lms);
      paramParcel.writeString(this.lmt);
      paramParcel.writeString(this.lmu);
      paramParcel.writeString(this.lmv);
      if (!this.lmq) {
        break label519;
      }
      paramInt = 1;
      label390:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.dJw);
      paramParcel.writeString(this.lmw);
      paramParcel.writeString(this.llO);
      paramParcel.writeString(this.hBj);
      paramParcel.writeInt(this.kaX);
      if (!this.llH) {
        break label524;
      }
      paramInt = 1;
      label452:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hAW);
      if (!this.hBk) {
        break label529;
      }
    }
    label514:
    label519:
    label524:
    label529:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.subType);
      AppMethodBeat.o(46805);
      return;
      paramInt = 0;
      break;
      label499:
      paramInt = 0;
      break label213;
      label504:
      paramInt = 0;
      break label228;
      label509:
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