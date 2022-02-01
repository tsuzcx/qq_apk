package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.a;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.jo.a;
import com.tencent.mm.g.b.a.jo.b;
import com.tencent.mm.g.b.a.jo.c;
import com.tencent.mm.g.b.a.jo.d;
import com.tencent.mm.g.b.a.jo.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
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
  public int aDD;
  public String appId;
  public int cQN;
  public String cacheKey;
  public String dIs;
  public String dJW;
  public String description;
  public String dkh;
  public int dtF;
  public int ePC;
  public String hAT;
  public String hyi;
  public String hyv;
  public boolean hyw;
  public String iconUrl;
  public int jXI;
  public boolean kKe;
  public String kar;
  public Runnable krg;
  public int kro;
  public boolean lhO;
  public boolean lhP;
  public boolean lhQ;
  public boolean lhV;
  public int liA;
  public String liB;
  public String liC;
  public String liD;
  public boolean liE;
  public String liF;
  public String liG;
  public String liH;
  public String liI;
  public String liJ;
  public String liK;
  public ArrayList<ShareInfo> liL;
  public String lic;
  public String liv;
  public String liw;
  public String lix;
  public String liy;
  public int liz;
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
    this.liz = 1;
    this.ePC = k.a.hzJ.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.hyw = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.liz = 1;
    this.ePC = k.a.hzJ.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.hyw = false;
    e(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.azd().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!bt.isNullOrNil(this.liv))
    {
      paramb = new sx();
      paramb.dHy.dHz = paramString;
      paramb.dHy.content = this.liv;
      paramb.dHy.type = com.tencent.mm.model.w.Ar(paramString);
      paramb.dHy.flags = 0;
      com.tencent.mm.sdk.b.a.IbL.l(paramb);
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz().AR(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!com.tencent.mm.model.w.vF(paramString)) {
        break label219;
      }
    }
    label219:
    for (int j = 2;; j = 1)
    {
      r.a(this.appId, paramInt, this.dkh, this.liB, paramString, this.title, this.path, this.liC, this.liD, i, paramStringBuilder.toString(), this.liF, this.cQN, this.liw, this.aDD, j, null);
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
  
  public final void aOA()
  {
    int i = 3;
    AppMethodBeat.i(46799);
    ad.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.liw });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!bt.isNullOrNil(this.liw)) && ((this.liw.startsWith("http://")) || (this.liw.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.aDV().a(this.liw, null);
    }
    for (;;)
    {
      Object localObject3;
      label208:
      final int j;
      label653:
      boolean bool1;
      Object localObject5;
      efz localefz;
      final LinkedList localLinkedList;
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
        ad.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.liw });
        localObject2 = y.AH("wxapp_" + this.appId + this.path);
        y.aBq().F((String)localObject2, true).k("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).hCn = this.userName;
        ((k.b)localObject2).hCm = this.path;
        ((k.b)localObject2).hCo = this.appId;
        ((k.b)localObject2).hCz = this.dtF;
        ((k.b)localObject2).hCA = this.version;
        ((k.b)localObject2).hCq = this.kar;
        ((k.b)localObject2).hCp = this.type;
        ((k.b)localObject2).hCw = this.kro;
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).hCB = this.iconUrl;
        ((k.b)localObject2).dHu = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).dHo = this.userName;
        ((k.b)localObject2).dHp = this.nickname;
        localObject4 = new com.tencent.mm.ai.a();
        ((com.tencent.mm.ai.a)localObject4).hxV = this.lhO;
        ((com.tencent.mm.ai.a)localObject4).hxW = this.cacheKey;
        ((com.tencent.mm.ai.a)localObject4).hxX = this.cQN;
        ((com.tencent.mm.ai.a)localObject4).hxY = this.lhP;
        ((com.tencent.mm.ai.a)localObject4).hyj = this.dJW;
        ((com.tencent.mm.ai.a)localObject4).hym = this.liw;
        ((com.tencent.mm.ai.a)localObject4).hyn = bt.isNullOrNil(this.liw);
        ((com.tencent.mm.ai.a)localObject4).hyh = this.jXI;
        ((com.tencent.mm.ai.a)localObject4).hyw = this.hyw;
        ((com.tencent.mm.ai.a)localObject4).hyk = this.subType;
        ((k.b)localObject2).a((f)localObject4);
        localObject3 = r.bF(this.appId, this.liA);
        ((k.b)localObject2).hCs = ((StringBuilder)localObject3).toString();
        if (1 != this.liz) {
          break label1039;
        }
        ((k.b)localObject2).type = 33;
        ad.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b isPrivateMsg:%b", new Object[] { Boolean.valueOf(this.lhP), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.lhV), Boolean.valueOf(this.lhQ) });
        if (((!this.lhP) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.lhV) && (!this.lhQ)) {
          break label1295;
        }
        j = this.scene;
        bool1 = this.lhP;
        boolean bool2 = this.lhQ;
        localObject4 = this.hAT;
        localObject5 = new b.a();
        ((b.a)localObject5).funcId = 1118;
        ((b.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        localefz = new efz();
        localefz.duW = this.appId;
        localLinkedList = new LinkedList(bt.U(this.toUser.split(",")));
        localefz.HQY = localLinkedList;
        localefz.HRa = ((String)localObject4);
        localefz.HQZ = bool1;
        localefz.HRb = this.lhV;
        localefz.HBy = this.hyi;
        localefz.HRc = bool2;
        if (!bool2) {
          break label1290;
        }
      }
      for (;;)
      {
        localefz.GKV = i;
        ((b.a)localObject5).hNM = localefz;
        ((b.a)localObject5).hNN = new ega();
        x.a(((b.a)localObject5).aDC(), new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(46796);
            ad.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramAnonymousString = (ega)paramAnonymousb.hNL.hNQ;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null) && (!bt.hj(paramAnonymousString.HRd)))
            {
              paramAnonymousn = paramAnonymousString.HRd;
              SendAppMessageTask.this.liL = new ArrayList();
              paramAnonymousInt1 = 0;
              if (paramAnonymousInt1 < localLinkedList.size())
              {
                label120:
                com.tencent.mm.ai.a locala;
                jo localjo;
                if (paramAnonymousInt1 < paramAnonymousn.size())
                {
                  paramAnonymousString = (egi)paramAnonymousn.get(paramAnonymousInt1);
                  this.liN.hCt = paramAnonymousString.Hsm;
                  SendAppMessageTask.this.liL.add(new ShareInfo(paramAnonymousString.Hsm, paramAnonymousString.HRr));
                  locala = (com.tencent.mm.ai.a)this.liN.ao(com.tencent.mm.ai.a.class);
                  locala.hxY = paramAnonymousString.HQZ;
                  locala.hyl = paramAnonymousString.HRc;
                  if ((paramAnonymousString.HQZ) && (paramAnonymousString.HRs != null))
                  {
                    locala.hxZ = paramAnonymousString.HRs.content;
                    locala.hya = paramAnonymousString.HRs.Hsg;
                    locala.hyb = paramAnonymousString.HRs.Hsh;
                    locala.hyc = paramAnonymousString.HRs.Hsi;
                    locala.hyd = paramAnonymousString.HRs.Hsj;
                    locala.hye = paramAnonymousString.HRs.Hsl;
                    locala.hyg = paramAnonymousString.HRs.state;
                    locala.hyf = paramAnonymousString.HRs.Hsk;
                    localjo = new jo().sd(SendAppMessageTask.this.appId).se(SendAppMessageTask.this.path).sf(paramAnonymousString.Hsm).sg((String)localLinkedList.get(paramAnonymousInt1));
                    if (!((String)localLinkedList.get(paramAnonymousInt1)).toLowerCase().endsWith("@chatroom")) {
                      break label551;
                    }
                  }
                }
                label551:
                for (paramAnonymousb = jo.c.eBL;; paramAnonymousb = jo.c.eBM)
                {
                  localjo.eBr = paramAnonymousb;
                  localjo.eBs = jo.b.eBF;
                  localjo.dVd = j;
                  paramAnonymousb = localjo.sh(SendAppMessageTask.this.dkh);
                  paramAnonymousb.eBw = jo.a.jT(SendAppMessageTask.this.cQN + 1000);
                  paramAnonymousb = paramAnonymousb.Vs();
                  paramAnonymousb.eBu = jo.d.eBP;
                  paramAnonymousb.eBv = jo.e.eBT;
                  paramAnonymousb.aLk();
                  if ((paramAnonymousString.HRb) && (paramAnonymousString.HRt != null) && (paramAnonymousString.HRt.HBx)) {
                    locala.hyi = paramAnonymousString.HRt.HBy;
                  }
                  SendAppMessageTask.a(SendAppMessageTask.this, this.liN, this.hwi, (String)localLinkedList.get(paramAnonymousInt1), this.liO, j);
                  paramAnonymousInt1 += 1;
                  break;
                  paramAnonymousString = new egi();
                  break label120;
                }
              }
            }
            else
            {
              if (this.liN.hCp == 3) {
                this.liN.hCp = 2;
              }
              paramAnonymousString = localLinkedList.iterator();
              while (paramAnonymousString.hasNext())
              {
                paramAnonymousb = (String)paramAnonymousString.next();
                SendAppMessageTask.a(SendAppMessageTask.this, this.liN, this.hwi, paramAnonymousb, this.liO, j);
              }
            }
            SendAppMessageTask.a(SendAppMessageTask.this);
            AppMethodBeat.o(46796);
            return 0;
          }
        });
        AppMethodBeat.o(46799);
        return;
        if (bt.isNullOrNil(this.lix)) {
          break label1364;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.g.aQf(this.lix);
        if (this.kKe)
        {
          bool1 = i.deleteFile(this.lix);
          ad.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.lix, Boolean.valueOf(bool1) });
          break;
        }
        ad.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.lix });
        break;
        ad.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label208;
        label1039:
        if (2 == this.liz)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).hCu = this.ePC;
          ((k.b)localObject2).hCv = this.liy;
          break label653;
        }
        if (this.liz == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.liG;
          ((k.b)localObject2).appName = this.liH;
          ((k.b)localObject2).dHo = this.liI;
          ((k.b)localObject2).dHp = null;
          ((com.tencent.mm.ai.a)localObject4).appThumbUrl = this.liJ;
          break label653;
        }
        if (this.liz == 4)
        {
          ((k.b)localObject2).type = 48;
          m.aLc(com.tencent.mm.loader.j.b.asz());
          localObject5 = com.tencent.mm.loader.j.b.asz() + this.dIs;
          if (!((String)localObject5).equals(this.videoPath)) {
            ad.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(i.mz(this.videoPath, (String)localObject5)) });
          }
          ((com.tencent.mm.ai.a)localObject4).hyr = ((String)localObject5);
          ((com.tencent.mm.ai.a)localObject4).dIs = this.dIs;
          ((com.tencent.mm.ai.a)localObject4).hyt = this.lic;
          ((com.tencent.mm.ai.a)localObject4).hyv = this.hyv;
          break label653;
        }
        if (this.liz != 5) {
          break label653;
        }
        ((k.b)localObject2).type = 5;
        ((k.b)localObject2).thumburl = this.liw;
        break label653;
        label1290:
        i = 0;
      }
      label1295:
      Object localObject4 = new LinkedList(bt.U(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1364:
      localObject1 = null;
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(46800);
    if (this.krg != null) {
      this.krg.run();
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
    this.liv = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.liw = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.lix = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.kKe = bool1;
      this.dtF = paramParcel.readInt();
      this.kar = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.liA = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.dkh = paramParcel.readString();
      this.liB = paramParcel.readString();
      this.liC = paramParcel.readString();
      this.liD = paramParcel.readString();
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
      this.lhO = bool1;
      if (paramParcel.readInt() != 1) {
        break label515;
      }
      bool1 = true;
      label239:
      this.lhP = bool1;
      this.hAT = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label520;
      }
      bool1 = true;
      label262:
      this.lhQ = bool1;
      this.cacheKey = paramParcel.readString();
      this.cQN = paramParcel.readInt();
      this.liF = paramParcel.readString();
      this.liL = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.dJW = paramParcel.readString();
      this.aDD = paramParcel.readInt();
      this.ePC = paramParcel.readInt();
      this.liy = paramParcel.readString();
      this.kro = paramParcel.readInt();
      this.liz = paramParcel.readInt();
      this.liG = paramParcel.readString();
      this.liH = paramParcel.readString();
      this.liI = paramParcel.readString();
      this.liJ = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label525;
      }
      bool1 = true;
      label394:
      this.liE = bool1;
      this.videoPath = paramParcel.readString();
      this.dIs = paramParcel.readString();
      this.liK = paramParcel.readString();
      this.lic = paramParcel.readString();
      this.hyv = paramParcel.readString();
      this.jXI = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label530;
      }
      bool1 = true;
      label457:
      this.lhV = bool1;
      this.hyi = paramParcel.readString();
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
      this.hyw = bool1;
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
    paramParcel.writeString(this.liv);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.liw);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.lix);
    if (this.kKe)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.dtF);
      paramParcel.writeString(this.kar);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.liA);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.dkh);
      paramParcel.writeString(this.liB);
      paramParcel.writeString(this.liC);
      paramParcel.writeString(this.liD);
      if (!this.withShareTicket) {
        break label499;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.lhO) {
        break label504;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.lhP) {
        break label509;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hAT);
      if (!this.lhQ) {
        break label514;
      }
      paramInt = 1;
      label264:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.cQN);
      paramParcel.writeString(this.liF);
      paramParcel.writeList(this.liL);
      paramParcel.writeString(this.dJW);
      paramParcel.writeInt(this.aDD);
      paramParcel.writeInt(this.ePC);
      paramParcel.writeString(this.liy);
      paramParcel.writeInt(this.kro);
      paramParcel.writeInt(this.liz);
      paramParcel.writeString(this.liG);
      paramParcel.writeString(this.liH);
      paramParcel.writeString(this.liI);
      paramParcel.writeString(this.liJ);
      if (!this.liE) {
        break label519;
      }
      paramInt = 1;
      label390:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.dIs);
      paramParcel.writeString(this.liK);
      paramParcel.writeString(this.lic);
      paramParcel.writeString(this.hyv);
      paramParcel.writeInt(this.jXI);
      if (!this.lhV) {
        break label524;
      }
      paramInt = 1;
      label452:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.hyi);
      if (!this.hyw) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */