package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.brr;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String fCl;
  public String fSj;
  public String footerWording;
  public String lmL;
  public int toA;
  public int toB;
  public int toC;
  public String toD;
  public String toE;
  public int toF;
  public String toG;
  public String toH;
  public String toI;
  public String toJ;
  public String toK;
  public String toL;
  public String toM;
  public String toN;
  public String toO;
  public LinkedList<AcceptedCardItem> toP;
  public LinkedList<AccepterItem> toQ;
  public String toR;
  public int toS;
  public String toT;
  public String toU;
  public String toV;
  public String toW;
  public String toX;
  public String toY;
  public int toZ;
  public String tom;
  public String ton;
  public String too;
  public String toq;
  public String tor;
  public String tos;
  public String tot;
  public String tou;
  public String tov;
  public String tow;
  public String tox;
  public String toy;
  public boolean toz;
  public String tpa;
  public String tpb;
  public String tpc;
  public String tpd;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.toP = new LinkedList();
    this.toQ = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.toP = new LinkedList();
    this.toQ = new LinkedList();
    this.fCl = paramParcel.readString();
    this.fSj = paramParcel.readString();
    this.tom = paramParcel.readString();
    this.ton = paramParcel.readString();
    this.too = paramParcel.readString();
    this.toq = paramParcel.readString();
    this.tor = paramParcel.readString();
    this.tos = paramParcel.readString();
    this.tot = paramParcel.readString();
    this.tou = paramParcel.readString();
    this.tov = paramParcel.readString();
    this.tow = paramParcel.readString();
    this.tox = paramParcel.readString();
    this.toy = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.lmL = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.toz = bool;
      this.toA = paramParcel.readInt();
      this.toB = paramParcel.readInt();
      this.toC = paramParcel.readInt();
      this.toD = paramParcel.readString();
      this.toE = paramParcel.readString();
      this.toF = paramParcel.readInt();
      this.toG = paramParcel.readString();
      this.toH = paramParcel.readString();
      this.toI = paramParcel.readString();
      this.toJ = paramParcel.readString();
      this.toK = paramParcel.readString();
      this.toL = paramParcel.readString();
      this.toM = paramParcel.readString();
      this.toN = paramParcel.readString();
      this.toO = paramParcel.readString();
      paramParcel.readTypedList(this.toP, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.toQ, AccepterItem.CREATOR);
      this.toR = paramParcel.readString();
      this.toS = paramParcel.readInt();
      this.toT = paramParcel.readString();
      this.toU = paramParcel.readString();
      this.toU = paramParcel.readString();
      this.toV = paramParcel.readString();
      this.toW = paramParcel.readString();
      this.toX = paramParcel.readString();
      this.toY = paramParcel.readString();
      this.toZ = paramParcel.readInt();
      this.tpa = paramParcel.readString();
      this.tpb = paramParcel.readString();
      this.tpc = paramParcel.readString();
      this.tpd = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(aq paramaq)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.fCl = paramaq.REH;
    localCardGiftInfo.fSj = paramaq.REI;
    localCardGiftInfo.tom = paramaq.REJ;
    localCardGiftInfo.ton = paramaq.content;
    localCardGiftInfo.too = paramaq.REK;
    localCardGiftInfo.toq = paramaq.REL;
    localCardGiftInfo.tor = paramaq.REM;
    localCardGiftInfo.tos = paramaq.REN;
    localCardGiftInfo.tou = paramaq.REP;
    localCardGiftInfo.tot = paramaq.REO;
    localCardGiftInfo.tov = paramaq.REQ;
    localCardGiftInfo.tow = paramaq.RER;
    localCardGiftInfo.tox = paramaq.tpe;
    localCardGiftInfo.toy = paramaq.tpf;
    localCardGiftInfo.footerWording = paramaq.RES;
    localCardGiftInfo.lmL = paramaq.lmL;
    localCardGiftInfo.toz = paramaq.RET;
    localCardGiftInfo.toA = paramaq.REU;
    localCardGiftInfo.toB = paramaq.REW;
    localCardGiftInfo.toC = paramaq.REX;
    localCardGiftInfo.toD = paramaq.REY;
    localCardGiftInfo.toE = paramaq.REZ;
    localCardGiftInfo.toF = paramaq.RFa;
    localCardGiftInfo.toG = paramaq.RFb;
    localCardGiftInfo.toH = paramaq.RFc;
    localCardGiftInfo.toI = paramaq.RFd;
    localCardGiftInfo.toJ = paramaq.RFe;
    localCardGiftInfo.toK = paramaq.RFf;
    localCardGiftInfo.toL = paramaq.RFg;
    localCardGiftInfo.toM = paramaq.RFh;
    localCardGiftInfo.toN = paramaq.tnX;
    localCardGiftInfo.toO = paramaq.RFi;
    Iterator localIterator = paramaq.toP.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (at)localIterator.next();
      localLinkedList = localCardGiftInfo.toP;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).tpf = ((at)localObject1).tpf;
      ((AcceptedCardItem)localObject2).tpe = ((at)localObject1).tpe;
      localLinkedList.add(localObject2);
    }
    localIterator = paramaq.toQ.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (au)localIterator.next();
      localLinkedList = localCardGiftInfo.toQ;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).tpf = ((au)localObject1).tpf;
      ((AccepterItem)localObject2).tpe = ((au)localObject1).tpe;
      ((AccepterItem)localObject2).tph = ((au)localObject1).tph;
      ((AccepterItem)localObject2).tpg = ((au)localObject1).tpg;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.toR = paramaq.toR;
    localCardGiftInfo.toS = paramaq.toS;
    localCardGiftInfo.toT = paramaq.toT;
    localCardGiftInfo.toU = paramaq.toU;
    localCardGiftInfo.toV = paramaq.toV;
    localCardGiftInfo.toW = paramaq.toW;
    localCardGiftInfo.toX = paramaq.toX;
    localCardGiftInfo.toY = paramaq.toY;
    localCardGiftInfo.toZ = paramaq.toZ;
    localCardGiftInfo.tpa = paramaq.tpa;
    localCardGiftInfo.tpc = paramaq.tpc;
    localCardGiftInfo.tpb = paramaq.tpb;
    localCardGiftInfo.tpd = paramaq.tpd;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(brr parambrr)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.fCl = parambrr.REH;
    localCardGiftInfo.fSj = parambrr.REI;
    localCardGiftInfo.tom = parambrr.REJ;
    localCardGiftInfo.ton = parambrr.content;
    localCardGiftInfo.too = parambrr.REK;
    localCardGiftInfo.toq = parambrr.REL;
    localCardGiftInfo.tor = parambrr.REM;
    localCardGiftInfo.tos = parambrr.REN;
    localCardGiftInfo.tou = parambrr.REP;
    localCardGiftInfo.tot = parambrr.REO;
    localCardGiftInfo.tov = parambrr.REQ;
    localCardGiftInfo.tow = parambrr.RER;
    localCardGiftInfo.tox = parambrr.tpe;
    localCardGiftInfo.toy = parambrr.tpf;
    localCardGiftInfo.footerWording = parambrr.RES;
    localCardGiftInfo.lmL = parambrr.lmL;
    localCardGiftInfo.toz = parambrr.RET;
    localCardGiftInfo.toA = parambrr.REU;
    localCardGiftInfo.toB = parambrr.REW;
    localCardGiftInfo.toC = parambrr.REX;
    localCardGiftInfo.toD = parambrr.REY;
    localCardGiftInfo.toE = parambrr.REZ;
    localCardGiftInfo.toF = parambrr.Tci;
    localCardGiftInfo.toG = parambrr.RFb;
    localCardGiftInfo.toH = parambrr.RFc;
    localCardGiftInfo.toI = parambrr.RFd;
    localCardGiftInfo.toJ = parambrr.RFe;
    localCardGiftInfo.toK = parambrr.RFf;
    localCardGiftInfo.toL = parambrr.RFg;
    localCardGiftInfo.toM = parambrr.RFh;
    localCardGiftInfo.toN = parambrr.tnX;
    localCardGiftInfo.toO = parambrr.RFi;
    localCardGiftInfo.toT = parambrr.toT;
    localCardGiftInfo.toU = parambrr.toU;
    localCardGiftInfo.toV = parambrr.toV;
    localCardGiftInfo.toW = parambrr.toW;
    localCardGiftInfo.toX = parambrr.toX;
    localCardGiftInfo.toY = parambrr.toY;
    localCardGiftInfo.toZ = parambrr.toZ;
    localCardGiftInfo.tpa = parambrr.tpa;
    localCardGiftInfo.tpc = parambrr.tpc;
    localCardGiftInfo.tpb = parambrr.tpb;
    localCardGiftInfo.tpd = parambrr.tpd;
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
    String str = "CardGiftInfo{toUserName='" + this.fCl + '\'' + ", fromUserName='" + this.fSj + '\'' + ", fromUserImgUrl='" + this.tom + '\'' + ", fromUserContent='" + this.ton + '\'' + ", fromUserContentPicUrl='" + this.too + '\'' + ", fromUserContentVideoUrl='" + this.toq + '\'' + ", fromUserContentThumbPicUrl='" + this.tor + '\'' + ", picAESKey='" + this.tos + '\'' + ", videoAESKey='" + this.tot + '\'' + ", thumbVideoAESKey='" + this.tou + '\'' + ", cardBackgroundPicUrl='" + this.tov + '\'' + ", cardLogoLUrl='" + this.tow + '\'' + ", cardTitle='" + this.tox + '\'' + ", cardPrice='" + this.toy + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.lmL + '\'' + ", needJump=" + this.toz + ", picDataLength=" + this.toA + ", videoDataLength=" + this.toB + ", thumbDataLength=" + this.toC + ", descTitle='" + this.toD + '\'' + ", descIconUrl='" + this.toE + '\'' + ", descLayoutMode=" + this.toF + ", giftingMediaTitle='" + this.toG + '\'' + ", descriptionTitleColor='" + this.toH + '\'' + ", cardTitleColor='" + this.toI + '\'' + ", cardPriceTitleColor='" + this.toJ + '\'' + ", userCardId='" + this.toK + '\'' + ", operationTitle='" + this.toL + '\'' + ", operationUrl='" + this.toM + '\'' + ", cardTpId='" + this.toN + '\'' + ", cardCode='" + this.toO + '\'' + ", accepted_card_list_size='" + this.toP.size() + '\'' + ", accepter_list_size='" + this.toQ.size() + '\'' + ", accepter_list_title='" + this.toR + '\'' + ", out_of_card='" + this.toS + '\'' + ", operation_wxa_username='" + this.toT + '\'' + ", operation_wxa_path='" + this.toU + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.fCl);
    paramParcel.writeString(this.fSj);
    paramParcel.writeString(this.tom);
    paramParcel.writeString(this.ton);
    paramParcel.writeString(this.too);
    paramParcel.writeString(this.toq);
    paramParcel.writeString(this.tor);
    paramParcel.writeString(this.tos);
    paramParcel.writeString(this.tot);
    paramParcel.writeString(this.tou);
    paramParcel.writeString(this.tov);
    paramParcel.writeString(this.tow);
    paramParcel.writeString(this.tox);
    paramParcel.writeString(this.toy);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.lmL);
    if (this.toz) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.toA);
      paramParcel.writeInt(this.toB);
      paramParcel.writeInt(this.toC);
      paramParcel.writeString(this.toD);
      paramParcel.writeString(this.toE);
      paramParcel.writeInt(this.toF);
      paramParcel.writeString(this.toG);
      paramParcel.writeString(this.toH);
      paramParcel.writeString(this.toI);
      paramParcel.writeString(this.toJ);
      paramParcel.writeString(this.toK);
      paramParcel.writeString(this.toL);
      paramParcel.writeString(this.toM);
      paramParcel.writeString(this.toN);
      paramParcel.writeString(this.toO);
      paramParcel.writeTypedList(this.toP);
      paramParcel.writeTypedList(this.toQ);
      paramParcel.writeString(this.toR);
      paramParcel.writeInt(this.toS);
      paramParcel.writeString(this.toT);
      paramParcel.writeString(this.toU);
      paramParcel.writeString(this.toU);
      paramParcel.writeString(this.toV);
      paramParcel.writeString(this.toW);
      paramParcel.writeString(this.toX);
      paramParcel.writeString(this.toY);
      paramParcel.writeInt(this.toZ);
      paramParcel.writeString(this.tpa);
      paramParcel.writeString(this.tpb);
      paramParcel.writeString(this.tpc);
      paramParcel.writeString(this.tpd);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String tpe;
    public String tpf;
    
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
      this.tpe = paramParcel.readString();
      this.tpf = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.tpe);
      paramParcel.writeString(this.tpf);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String tpe;
    public String tpf;
    public String tpg;
    public String tph;
    
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
      this.tpe = paramParcel.readString();
      this.tpf = paramParcel.readString();
      this.tpg = paramParcel.readString();
      this.tph = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.tpe);
      paramParcel.writeString(this.tpf);
      paramParcel.writeString(this.tpg);
      paramParcel.writeString(this.tph);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */