package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.a;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.b.a.no;
import com.tencent.mm.g.b.a.no.a;
import com.tencent.mm.g.b.a.no.b;
import com.tencent.mm.g.b.a.no.c;
import com.tencent.mm.g.b.a.no.d;
import com.tencent.mm.g.b.a.no.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.dxs;
import com.tencent.mm.protocal.protobuf.eie;
import com.tencent.mm.protocal.protobuf.fci;
import com.tencent.mm.protocal.protobuf.fcj;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  public String dCw;
  public int dMe;
  public String description;
  public String ebj;
  public String eda;
  public int fuQ;
  public String iconUrl;
  public String ivd;
  public String ivp;
  public boolean ivq;
  public String ixM;
  public boolean lSk;
  public int leb;
  public String lhn;
  public int lyE;
  public Runnable lyv;
  public String mrD;
  public String mrI;
  public String mrJ;
  public boolean mrn;
  public boolean mro;
  public boolean mrp;
  public boolean mru;
  public int mrw;
  public String mrx;
  public String msd;
  public String mse;
  public String msf;
  public String msh;
  public int msi;
  public int msj;
  public String msk;
  public String msl;
  public String msm;
  public boolean msn;
  public String mso;
  public String msp;
  public String msq;
  public String msr;
  public String mss;
  public ArrayList<ShareInfo> mst;
  public String nickname;
  public String path;
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
    this.msi = 1;
    this.fuQ = k.a.iwD.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.ivq = false;
    AppMethodBeat.o(46798);
  }
  
  protected SendAppMessageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(46806);
    this.msi = 1;
    this.fuQ = k.a.iwD.ordinal();
    this.subType = 0;
    this.scene = 1000;
    this.ivq = false;
    f(paramParcel);
    AppMethodBeat.o(46806);
  }
  
  private void a(k.b paramb, byte[] paramArrayOfByte, String paramString, StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(46802);
    w.a.aSz().a(paramb, this.appId, this.title, paramString, null, paramArrayOfByte);
    if (!Util.isNullOrNil(this.msd))
    {
      paramb = new tw();
      paramb.eaq.dkV = paramString;
      paramb.eaq.content = this.msd;
      paramb.eaq.type = ab.JG(paramString);
      paramb.eaq.flags = 0;
      EventCenter.instance.publish(paramb);
    }
    int i = 1;
    if (paramString.toLowerCase().endsWith("@chatroom"))
    {
      paramb = ((c)g.af(c.class)).aSX().Kh(paramString);
      if (paramb != null) {
        i = paramb.size();
      }
    }
    else
    {
      if (!ab.Eq(paramString)) {
        break label222;
      }
    }
    label222:
    for (int j = 2;; j = 1)
    {
      y.a(this.appId, paramInt, this.dCw, this.msk, paramString, this.title, this.path, this.msl, this.msm, i, paramStringBuilder.toString(), this.mrx, this.serviceType, this.mse, this.appVersion, j, this.eda);
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
  
  public final void bjj()
  {
    int i = 3;
    AppMethodBeat.i(46799);
    Log.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[] { this.userName, this.mse });
    Object localObject2 = new byte[0];
    Object localObject1;
    if ((!Util.isNullOrNil(this.mse)) && ((this.mse.startsWith("http://")) || (this.mse.startsWith("https://")))) {
      localObject1 = com.tencent.mm.modelappbrand.a.b.aXY().a(this.mse, null);
    }
    for (;;)
    {
      Object localObject3;
      label208:
      Object localObject5;
      label714:
      final int j;
      boolean bool1;
      fci localfci;
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
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[] { this.appId, this.title, this.description, this.userName, this.path, this.mse });
        localObject2 = ad.JX("wxapp_" + this.appId + this.path);
        ad.aVe().G((String)localObject2, true).l("prePublishId", "wxapp_" + this.appId + this.path);
        localObject2 = new k.b();
        ((k.b)localObject2).title = this.title;
        ((k.b)localObject2).description = this.description;
        ((k.b)localObject2).izi = this.userName;
        ((k.b)localObject2).izh = this.path;
        ((k.b)localObject2).izj = this.appId;
        ((k.b)localObject2).izz = this.dMe;
        ((k.b)localObject2).izA = this.version;
        ((k.b)localObject2).izl = this.lhn;
        ((k.b)localObject2).izk = this.type;
        ((k.b)localObject2).izr = this.lyE;
        ((k.b)localObject2).url = this.url;
        ((k.b)localObject2).izB = this.iconUrl;
        ((k.b)localObject2).eam = ("wxapp_" + this.appId + this.path);
        ((k.b)localObject2).eag = this.userName;
        ((k.b)localObject2).eah = this.nickname;
        localObject4 = new a();
        ((a)localObject4).iuQ = this.mrn;
        ((a)localObject4).iuR = this.cacheKey;
        ((a)localObject4).iuS = this.serviceType;
        ((a)localObject4).iuT = this.mro;
        ((a)localObject4).ive = this.eda;
        ((a)localObject4).imageUrl = this.mse;
        ((a)localObject4).ivh = Util.isNullOrNil(this.mse);
        ((a)localObject4).ivc = this.leb;
        ((a)localObject4).ivq = this.ivq;
        ((a)localObject4).ivf = this.subType;
        ((k.b)localObject2).a((f)localObject4);
        localObject3 = y.bN(this.appId, this.msj);
        ((k.b)localObject2).izn = ((StringBuilder)localObject3).toString();
        localObject5 = new z();
        ((z)localObject5).msM = 1;
        ((z)localObject5).msN = this.title;
        ((z)localObject5).msO = this.path;
        ((z)localObject5).msP = this.mse;
        ((z)localObject5).msQ = this.mrw;
        aa.a(((k.b)localObject2).izn, (z)localObject5);
        if (1 != this.msi) {
          break label1100;
        }
        ((k.b)localObject2).type = 33;
        Log.i("MicroMsg.SendAppMessageTask", "doSendMessage isUpdateMsg:%b, withShareTicket:%b, isToDoMessage:%b isPrivateMsg:%b", new Object[] { Boolean.valueOf(this.mro), Boolean.valueOf(this.withShareTicket), Boolean.valueOf(this.mru), Boolean.valueOf(this.mrp) });
        if (((!this.mro) || (!this.withShareTicket)) && (!this.withShareTicket) && (!this.mru) && (!this.mrp)) {
          break label1374;
        }
        j = this.scene;
        bool1 = this.mro;
        boolean bool2 = this.mrp;
        localObject4 = this.ixM;
        localObject5 = new d.a();
        ((d.a)localObject5).funcId = 1118;
        ((d.a)localObject5).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
        localfci = new fci();
        localfci.dNI = this.appId;
        localLinkedList = new LinkedList(Util.stringsToList(this.toUser.split(",")));
        localfci.Nyh = localLinkedList;
        localfci.Nyj = ((String)localObject4);
        localfci.Nyi = bool1;
        localfci.Nyk = this.mru;
        localfci.Nhv = this.ivd;
        localfci.Nyl = bool2;
        if (!bool2) {
          break label1369;
        }
      }
      for (;;)
      {
        localfci.LEg = i;
        ((d.a)localObject5).iLN = localfci;
        ((d.a)localObject5).iLO = new fcj();
        com.tencent.mm.ak.aa.a(((d.a)localObject5).aXF(), new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, q paramAnonymousq)
          {
            AppMethodBeat.i(46796);
            Log.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramAnonymousString = (fcj)paramAnonymousd.iLL.iLR;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null) && (!Util.isNullOrNil(paramAnonymousString.Nym)))
            {
              paramAnonymousq = paramAnonymousString.Nym;
              SendAppMessageTask.this.mst = new ArrayList();
              paramAnonymousInt1 = 0;
              if (paramAnonymousInt1 < localLinkedList.size())
              {
                label120:
                a locala;
                no localno;
                if (paramAnonymousInt1 < paramAnonymousq.size())
                {
                  paramAnonymousString = (fcr)paramAnonymousq.get(paramAnonymousInt1);
                  this.msv.izo = paramAnonymousString.MXx;
                  SendAppMessageTask.this.mst.add(new ShareInfo(paramAnonymousString.MXx, paramAnonymousString.NyA));
                  locala = (a)this.msv.as(a.class);
                  locala.iuT = paramAnonymousString.Nyi;
                  locala.ivg = paramAnonymousString.Nyl;
                  if ((paramAnonymousString.Nyi) && (paramAnonymousString.NyB != null))
                  {
                    locala.iuU = paramAnonymousString.NyB.content;
                    locala.iuV = paramAnonymousString.NyB.MXr;
                    locala.iuW = paramAnonymousString.NyB.MXs;
                    locala.iuX = paramAnonymousString.NyB.MXt;
                    locala.iuY = paramAnonymousString.NyB.MXu;
                    locala.iuZ = paramAnonymousString.NyB.MXw;
                    locala.ivb = paramAnonymousString.NyB.state;
                    locala.iva = paramAnonymousString.NyB.MXv;
                    localno = new no().AJ(SendAppMessageTask.this.appId).AK(SendAppMessageTask.this.path).AL(paramAnonymousString.MXx).AM((String)localLinkedList.get(paramAnonymousInt1));
                    if (!((String)localLinkedList.get(paramAnonymousInt1)).toLowerCase().endsWith("@chatroom")) {
                      break label551;
                    }
                  }
                }
                label551:
                for (paramAnonymousd = no.c.fhS;; paramAnonymousd = no.c.fhT)
                {
                  localno.fhy = paramAnonymousd;
                  localno.fhz = no.b.fhM;
                  localno.erW = j;
                  paramAnonymousd = localno.AN(SendAppMessageTask.this.dCw);
                  paramAnonymousd.fhD = no.a.mX(SendAppMessageTask.this.serviceType + 1000);
                  paramAnonymousd = paramAnonymousd.ajq();
                  paramAnonymousd.fhB = no.d.fhW;
                  paramAnonymousd.fhC = no.e.fia;
                  paramAnonymousd.bfK();
                  if ((paramAnonymousString.Nyk) && (paramAnonymousString.NyC != null) && (paramAnonymousString.NyC.Nhu)) {
                    locala.ivd = paramAnonymousString.NyC.Nhv;
                  }
                  SendAppMessageTask.a(SendAppMessageTask.this, this.msv, this.isX, (String)localLinkedList.get(paramAnonymousInt1), this.msw, j);
                  paramAnonymousInt1 += 1;
                  break;
                  paramAnonymousString = new fcr();
                  break label120;
                }
              }
            }
            else
            {
              if (this.msv.izk == 3) {
                this.msv.izk = 2;
              }
              paramAnonymousString = localLinkedList.iterator();
              while (paramAnonymousString.hasNext())
              {
                paramAnonymousd = (String)paramAnonymousString.next();
                SendAppMessageTask.a(SendAppMessageTask.this, this.msv, this.isX, paramAnonymousd, this.msw, j);
              }
            }
            SendAppMessageTask.a(SendAppMessageTask.this);
            AppMethodBeat.o(46796);
            return 0;
          }
        });
        AppMethodBeat.o(46799);
        return;
        if (Util.isNullOrNil(this.msf)) {
          break label1443;
        }
        localObject1 = BitmapUtil.getBitmapNative(this.msf);
        if (this.lSk)
        {
          bool1 = s.deleteFile(this.msf);
          Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.msf, Boolean.valueOf(bool1) });
          break;
        }
        Log.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[] { this.msf });
        break;
        Log.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        localObject1 = localObject2;
        break label208;
        label1100:
        if (2 == this.msi)
        {
          ((k.b)localObject2).type = 44;
          ((k.b)localObject2).izp = this.fuQ;
          ((k.b)localObject2).izq = this.msh;
          ((k.b)localObject2).izs = this.mrI;
          ((k.b)localObject2).izt = this.mrJ;
          break label714;
        }
        if (this.msi == 3)
        {
          ((k.b)localObject2).type = 46;
          ((k.b)localObject2).appId = this.mso;
          ((k.b)localObject2).appName = this.msp;
          ((k.b)localObject2).eag = this.msq;
          ((k.b)localObject2).eah = null;
          ((a)localObject4).appThumbUrl = this.msr;
          break label714;
        }
        if (this.msi == 4)
        {
          ((k.b)localObject2).type = 48;
          FilePathGenerator.checkMkdir(com.tencent.mm.loader.j.b.aLo());
          localObject5 = com.tencent.mm.loader.j.b.aLo() + this.ebj;
          if (!((String)localObject5).equals(this.videoPath)) {
            Log.i("MicroMsg.SendAppMessageTask", "hy: copy upload file to %s, len is %d", new Object[] { localObject5, Long.valueOf(s.nw(this.videoPath, (String)localObject5)) });
          }
          ((a)localObject4).ivl = ((String)localObject5);
          ((a)localObject4).ebj = this.ebj;
          ((a)localObject4).ivn = this.mrD;
          ((a)localObject4).ivp = this.ivp;
          break label714;
        }
        if (this.msi != 5) {
          break label714;
        }
        ((k.b)localObject2).type = 5;
        ((k.b)localObject2).thumburl = this.mse;
        break label714;
        label1369:
        i = 0;
      }
      label1374:
      Object localObject4 = new LinkedList(Util.stringsToList(this.toUser.split(","))).iterator();
      while (((Iterator)localObject4).hasNext()) {
        b((k.b)localObject2, (byte[])localObject1, (String)((Iterator)localObject4).next(), (StringBuilder)localObject3, this.scene);
      }
      AppMethodBeat.o(46799);
      return;
      label1443:
      localObject1 = null;
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(46800);
    if (this.lyv != null) {
      this.lyv.run();
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
    this.msd = paramParcel.readString();
    this.toUser = paramParcel.readString();
    this.url = paramParcel.readString();
    this.path = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.mse = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.msf = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.lSk = bool1;
      this.dMe = paramParcel.readInt();
      this.lhn = paramParcel.readString();
      this.version = paramParcel.readInt();
      this.nickname = paramParcel.readString();
      this.msj = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.dCw = paramParcel.readString();
      this.msk = paramParcel.readString();
      this.msl = paramParcel.readString();
      this.msm = paramParcel.readString();
      if (paramParcel.readByte() != 1) {
        break label529;
      }
      bool1 = true;
      label209:
      this.withShareTicket = bool1;
      if (paramParcel.readInt() != 1) {
        break label534;
      }
      bool1 = true;
      label224:
      this.mrn = bool1;
      if (paramParcel.readInt() != 1) {
        break label539;
      }
      bool1 = true;
      label239:
      this.mro = bool1;
      this.ixM = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label544;
      }
      bool1 = true;
      label262:
      this.mrp = bool1;
      this.cacheKey = paramParcel.readString();
      this.serviceType = paramParcel.readInt();
      this.mrx = paramParcel.readString();
      this.mst = paramParcel.readArrayList(SendAppMessageTask.class.getClassLoader());
      this.eda = paramParcel.readString();
      this.appVersion = paramParcel.readInt();
      this.fuQ = paramParcel.readInt();
      this.msh = paramParcel.readString();
      this.lyE = paramParcel.readInt();
      this.msi = paramParcel.readInt();
      this.mso = paramParcel.readString();
      this.msp = paramParcel.readString();
      this.msq = paramParcel.readString();
      this.msr = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label549;
      }
      bool1 = true;
      label394:
      this.msn = bool1;
      this.videoPath = paramParcel.readString();
      this.ebj = paramParcel.readString();
      this.mss = paramParcel.readString();
      this.mrD = paramParcel.readString();
      this.ivp = paramParcel.readString();
      this.leb = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label554;
      }
      bool1 = true;
      label457:
      this.mru = bool1;
      this.ivd = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label559;
      }
    }
    label529:
    label534:
    label539:
    label544:
    label549:
    label554:
    label559:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ivq = bool1;
      this.subType = paramParcel.readInt();
      this.mrI = paramParcel.readString();
      this.mrJ = paramParcel.readString();
      this.mrw = paramParcel.readInt();
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
    paramParcel.writeString(this.msd);
    paramParcel.writeString(this.toUser);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.mse);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeString(this.msf);
    if (this.lSk)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.dMe);
      paramParcel.writeString(this.lhn);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.nickname);
      paramParcel.writeInt(this.msj);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.dCw);
      paramParcel.writeString(this.msk);
      paramParcel.writeString(this.msl);
      paramParcel.writeString(this.msm);
      if (!this.withShareTicket) {
        break label523;
      }
      paramInt = 1;
      label213:
      paramParcel.writeByte((byte)paramInt);
      if (!this.mrn) {
        break label528;
      }
      paramInt = 1;
      label228:
      paramParcel.writeInt(paramInt);
      if (!this.mro) {
        break label533;
      }
      paramInt = 1;
      label242:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ixM);
      if (!this.mrp) {
        break label538;
      }
      paramInt = 1;
      label264:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cacheKey);
      paramParcel.writeInt(this.serviceType);
      paramParcel.writeString(this.mrx);
      paramParcel.writeList(this.mst);
      paramParcel.writeString(this.eda);
      paramParcel.writeInt(this.appVersion);
      paramParcel.writeInt(this.fuQ);
      paramParcel.writeString(this.msh);
      paramParcel.writeInt(this.lyE);
      paramParcel.writeInt(this.msi);
      paramParcel.writeString(this.mso);
      paramParcel.writeString(this.msp);
      paramParcel.writeString(this.msq);
      paramParcel.writeString(this.msr);
      if (!this.msn) {
        break label543;
      }
      paramInt = 1;
      label390:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.videoPath);
      paramParcel.writeString(this.ebj);
      paramParcel.writeString(this.mss);
      paramParcel.writeString(this.mrD);
      paramParcel.writeString(this.ivp);
      paramParcel.writeInt(this.leb);
      if (!this.mru) {
        break label548;
      }
      paramInt = 1;
      label452:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.ivd);
      if (!this.ivq) {
        break label553;
      }
    }
    label523:
    label528:
    label533:
    label538:
    label543:
    label548:
    label553:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.subType);
      paramParcel.writeString(this.mrI);
      paramParcel.writeString(this.mrJ);
      paramParcel.writeInt(this.mrw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask
 * JD-Core Version:    0.7.0.1
 */