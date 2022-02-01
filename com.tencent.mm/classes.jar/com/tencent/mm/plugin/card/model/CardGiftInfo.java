package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.as;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String dio;
  public String dvQ;
  public String footerWording;
  public String gHT;
  public String nrH;
  public String nrI;
  public String nrJ;
  public String nrK;
  public String nrL;
  public String nrM;
  public String nrN;
  public String nrO;
  public String nrP;
  public String nrQ;
  public String nrR;
  public String nrS;
  public boolean nrT;
  public int nrU;
  public int nrV;
  public int nrW;
  public String nrX;
  public String nrY;
  public int nrZ;
  public String nsa;
  public String nsb;
  public String nsc;
  public String nsd;
  public String nse;
  public String nsf;
  public String nsg;
  public String nsh;
  public String nsi;
  public LinkedList<AcceptedCardItem> nsj;
  public LinkedList<AccepterItem> nsk;
  public String nsl;
  public int nsm;
  public String nsn;
  public String nso;
  public String nsp;
  public String nsq;
  public String nsr;
  public String nss;
  public int nst;
  public String nsu;
  public String nsv;
  public String nsw;
  public String nsx;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.nsj = new LinkedList();
    this.nsk = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.nsj = new LinkedList();
    this.nsk = new LinkedList();
    this.dio = paramParcel.readString();
    this.dvQ = paramParcel.readString();
    this.nrH = paramParcel.readString();
    this.nrI = paramParcel.readString();
    this.nrJ = paramParcel.readString();
    this.nrK = paramParcel.readString();
    this.nrL = paramParcel.readString();
    this.nrM = paramParcel.readString();
    this.nrN = paramParcel.readString();
    this.nrO = paramParcel.readString();
    this.nrP = paramParcel.readString();
    this.nrQ = paramParcel.readString();
    this.nrR = paramParcel.readString();
    this.nrS = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.gHT = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nrT = bool;
      this.nrU = paramParcel.readInt();
      this.nrV = paramParcel.readInt();
      this.nrW = paramParcel.readInt();
      this.nrX = paramParcel.readString();
      this.nrY = paramParcel.readString();
      this.nrZ = paramParcel.readInt();
      this.nsa = paramParcel.readString();
      this.nsb = paramParcel.readString();
      this.nsc = paramParcel.readString();
      this.nsd = paramParcel.readString();
      this.nse = paramParcel.readString();
      this.nsf = paramParcel.readString();
      this.nsg = paramParcel.readString();
      this.nsh = paramParcel.readString();
      this.nsi = paramParcel.readString();
      paramParcel.readTypedList(this.nsj, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.nsk, AccepterItem.CREATOR);
      this.nsl = paramParcel.readString();
      this.nsm = paramParcel.readInt();
      this.nsn = paramParcel.readString();
      this.nso = paramParcel.readString();
      this.nso = paramParcel.readString();
      this.nsp = paramParcel.readString();
      this.nsq = paramParcel.readString();
      this.nsr = paramParcel.readString();
      this.nss = paramParcel.readString();
      this.nst = paramParcel.readInt();
      this.nsu = paramParcel.readString();
      this.nsv = paramParcel.readString();
      this.nsw = paramParcel.readString();
      this.nsx = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(aq paramaq)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dio = paramaq.Cud;
    localCardGiftInfo.dvQ = paramaq.Cue;
    localCardGiftInfo.nrH = paramaq.Cuf;
    localCardGiftInfo.nrI = paramaq.content;
    localCardGiftInfo.nrJ = paramaq.Cug;
    localCardGiftInfo.nrK = paramaq.Cuh;
    localCardGiftInfo.nrL = paramaq.Cui;
    localCardGiftInfo.nrM = paramaq.Cuj;
    localCardGiftInfo.nrO = paramaq.Cul;
    localCardGiftInfo.nrN = paramaq.Cuk;
    localCardGiftInfo.nrP = paramaq.Cum;
    localCardGiftInfo.nrQ = paramaq.Cun;
    localCardGiftInfo.nrR = paramaq.nsy;
    localCardGiftInfo.nrS = paramaq.nsz;
    localCardGiftInfo.footerWording = paramaq.Cuo;
    localCardGiftInfo.gHT = paramaq.gHT;
    localCardGiftInfo.nrT = paramaq.Cup;
    localCardGiftInfo.nrU = paramaq.Cuq;
    localCardGiftInfo.nrV = paramaq.Cur;
    localCardGiftInfo.nrW = paramaq.Cus;
    localCardGiftInfo.nrX = paramaq.Cut;
    localCardGiftInfo.nrY = paramaq.Cuu;
    localCardGiftInfo.nrZ = paramaq.Cuv;
    localCardGiftInfo.nsa = paramaq.Cuw;
    localCardGiftInfo.nsb = paramaq.Cux;
    localCardGiftInfo.nsc = paramaq.Cuy;
    localCardGiftInfo.nsd = paramaq.Cuz;
    localCardGiftInfo.nse = paramaq.CuA;
    localCardGiftInfo.nsf = paramaq.CuB;
    localCardGiftInfo.nsg = paramaq.CuC;
    localCardGiftInfo.nsh = paramaq.nrr;
    localCardGiftInfo.nsi = paramaq.CuD;
    Iterator localIterator = paramaq.nsj.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (ar)localIterator.next();
      localLinkedList = localCardGiftInfo.nsj;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).nsz = ((ar)localObject1).nsz;
      ((AcceptedCardItem)localObject2).nsy = ((ar)localObject1).nsy;
      localLinkedList.add(localObject2);
    }
    localIterator = paramaq.nsk.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (as)localIterator.next();
      localLinkedList = localCardGiftInfo.nsk;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).nsz = ((as)localObject1).nsz;
      ((AccepterItem)localObject2).nsy = ((as)localObject1).nsy;
      ((AccepterItem)localObject2).nsB = ((as)localObject1).nsB;
      ((AccepterItem)localObject2).nsA = ((as)localObject1).nsA;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.nsl = paramaq.nsl;
    localCardGiftInfo.nsm = paramaq.nsm;
    localCardGiftInfo.nsn = paramaq.nsn;
    localCardGiftInfo.nso = paramaq.nso;
    localCardGiftInfo.nsp = paramaq.nsp;
    localCardGiftInfo.nsq = paramaq.nsq;
    localCardGiftInfo.nsr = paramaq.nsr;
    localCardGiftInfo.nss = paramaq.nss;
    localCardGiftInfo.nst = paramaq.nst;
    localCardGiftInfo.nsu = paramaq.nsu;
    localCardGiftInfo.nsw = paramaq.nsw;
    localCardGiftInfo.nsv = paramaq.nsv;
    localCardGiftInfo.nsx = paramaq.nsx;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(arg paramarg)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dio = paramarg.Cud;
    localCardGiftInfo.dvQ = paramarg.Cue;
    localCardGiftInfo.nrH = paramarg.Cuf;
    localCardGiftInfo.nrI = paramarg.content;
    localCardGiftInfo.nrJ = paramarg.Cug;
    localCardGiftInfo.nrK = paramarg.Cuh;
    localCardGiftInfo.nrL = paramarg.Cui;
    localCardGiftInfo.nrM = paramarg.Cuj;
    localCardGiftInfo.nrO = paramarg.Cul;
    localCardGiftInfo.nrN = paramarg.Cuk;
    localCardGiftInfo.nrP = paramarg.Cum;
    localCardGiftInfo.nrQ = paramarg.Cun;
    localCardGiftInfo.nrR = paramarg.nsy;
    localCardGiftInfo.nrS = paramarg.nsz;
    localCardGiftInfo.footerWording = paramarg.Cuo;
    localCardGiftInfo.gHT = paramarg.gHT;
    localCardGiftInfo.nrT = paramarg.Cup;
    localCardGiftInfo.nrU = paramarg.Cuq;
    localCardGiftInfo.nrV = paramarg.Cur;
    localCardGiftInfo.nrW = paramarg.Cus;
    localCardGiftInfo.nrX = paramarg.Cut;
    localCardGiftInfo.nrY = paramarg.Cuu;
    localCardGiftInfo.nrZ = paramarg.DrN;
    localCardGiftInfo.nsa = paramarg.Cuw;
    localCardGiftInfo.nsb = paramarg.Cux;
    localCardGiftInfo.nsc = paramarg.Cuy;
    localCardGiftInfo.nsd = paramarg.Cuz;
    localCardGiftInfo.nse = paramarg.CuA;
    localCardGiftInfo.nsf = paramarg.CuB;
    localCardGiftInfo.nsg = paramarg.CuC;
    localCardGiftInfo.nsh = paramarg.nrr;
    localCardGiftInfo.nsi = paramarg.CuD;
    localCardGiftInfo.nsn = paramarg.nsn;
    localCardGiftInfo.nso = paramarg.nso;
    localCardGiftInfo.nsp = paramarg.nsp;
    localCardGiftInfo.nsq = paramarg.nsq;
    localCardGiftInfo.nsr = paramarg.nsr;
    localCardGiftInfo.nss = paramarg.nss;
    localCardGiftInfo.nst = paramarg.nst;
    localCardGiftInfo.nsu = paramarg.nsu;
    localCardGiftInfo.nsw = paramarg.nsw;
    localCardGiftInfo.nsv = paramarg.nsv;
    localCardGiftInfo.nsx = paramarg.nsx;
    AppMethodBeat.o(112731);
    return localCardGiftInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(112729);
    String str = "CardGiftInfo{toUserName='" + this.dio + '\'' + ", fromUserName='" + this.dvQ + '\'' + ", fromUserImgUrl='" + this.nrH + '\'' + ", fromUserContent='" + this.nrI + '\'' + ", fromUserContentPicUrl='" + this.nrJ + '\'' + ", fromUserContentVideoUrl='" + this.nrK + '\'' + ", fromUserContentThumbPicUrl='" + this.nrL + '\'' + ", picAESKey='" + this.nrM + '\'' + ", videoAESKey='" + this.nrN + '\'' + ", thumbVideoAESKey='" + this.nrO + '\'' + ", cardBackgroundPicUrl='" + this.nrP + '\'' + ", cardLogoLUrl='" + this.nrQ + '\'' + ", cardTitle='" + this.nrR + '\'' + ", cardPrice='" + this.nrS + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.gHT + '\'' + ", needJump=" + this.nrT + ", picDataLength=" + this.nrU + ", videoDataLength=" + this.nrV + ", thumbDataLength=" + this.nrW + ", descTitle='" + this.nrX + '\'' + ", descIconUrl='" + this.nrY + '\'' + ", descLayoutMode=" + this.nrZ + ", giftingMediaTitle='" + this.nsa + '\'' + ", descriptionTitleColor='" + this.nsb + '\'' + ", cardTitleColor='" + this.nsc + '\'' + ", cardPriceTitleColor='" + this.nsd + '\'' + ", userCardId='" + this.nse + '\'' + ", operationTitle='" + this.nsf + '\'' + ", operationUrl='" + this.nsg + '\'' + ", cardTpId='" + this.nsh + '\'' + ", cardCode='" + this.nsi + '\'' + ", accepted_card_list_size='" + this.nsj.size() + '\'' + ", accepter_list_size='" + this.nsk.size() + '\'' + ", accepter_list_title='" + this.nsl + '\'' + ", out_of_card='" + this.nsm + '\'' + ", operation_wxa_username='" + this.nsn + '\'' + ", operation_wxa_path='" + this.nso + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.dio);
    paramParcel.writeString(this.dvQ);
    paramParcel.writeString(this.nrH);
    paramParcel.writeString(this.nrI);
    paramParcel.writeString(this.nrJ);
    paramParcel.writeString(this.nrK);
    paramParcel.writeString(this.nrL);
    paramParcel.writeString(this.nrM);
    paramParcel.writeString(this.nrN);
    paramParcel.writeString(this.nrO);
    paramParcel.writeString(this.nrP);
    paramParcel.writeString(this.nrQ);
    paramParcel.writeString(this.nrR);
    paramParcel.writeString(this.nrS);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.gHT);
    if (this.nrT) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.nrU);
      paramParcel.writeInt(this.nrV);
      paramParcel.writeInt(this.nrW);
      paramParcel.writeString(this.nrX);
      paramParcel.writeString(this.nrY);
      paramParcel.writeInt(this.nrZ);
      paramParcel.writeString(this.nsa);
      paramParcel.writeString(this.nsb);
      paramParcel.writeString(this.nsc);
      paramParcel.writeString(this.nsd);
      paramParcel.writeString(this.nse);
      paramParcel.writeString(this.nsf);
      paramParcel.writeString(this.nsg);
      paramParcel.writeString(this.nsh);
      paramParcel.writeString(this.nsi);
      paramParcel.writeTypedList(this.nsj);
      paramParcel.writeTypedList(this.nsk);
      paramParcel.writeString(this.nsl);
      paramParcel.writeInt(this.nsm);
      paramParcel.writeString(this.nsn);
      paramParcel.writeString(this.nso);
      paramParcel.writeString(this.nso);
      paramParcel.writeString(this.nsp);
      paramParcel.writeString(this.nsq);
      paramParcel.writeString(this.nsr);
      paramParcel.writeString(this.nss);
      paramParcel.writeInt(this.nst);
      paramParcel.writeString(this.nsu);
      paramParcel.writeString(this.nsv);
      paramParcel.writeString(this.nsw);
      paramParcel.writeString(this.nsx);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String nsy;
    public String nsz;
    
    static
    {
      AppMethodBeat.i(112721);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(112721);
    }
    
    public AcceptedCardItem() {}
    
    private AcceptedCardItem(Parcel paramParcel)
    {
      AppMethodBeat.i(112719);
      this.nsy = paramParcel.readString();
      this.nsz = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.nsy);
      paramParcel.writeString(this.nsz);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String nsA;
    public String nsB;
    public String nsy;
    public String nsz;
    
    static
    {
      AppMethodBeat.i(112725);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(112725);
    }
    
    public AccepterItem() {}
    
    private AccepterItem(Parcel paramParcel)
    {
      AppMethodBeat.i(112723);
      this.nsy = paramParcel.readString();
      this.nsz = paramParcel.readString();
      this.nsA = paramParcel.readString();
      this.nsB = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.nsy);
      paramParcel.writeString(this.nsz);
      paramParcel.writeString(this.nsA);
      paramParcel.writeString(this.nsB);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */