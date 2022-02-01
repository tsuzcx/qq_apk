package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bki;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String cardTpId;
  public String dJw;
  public String dYs;
  public String footerWording;
  public String ixw;
  public int pSA;
  public int pSB;
  public int pSC;
  public String pSD;
  public String pSE;
  public int pSF;
  public String pSG;
  public String pSH;
  public String pSI;
  public String pSJ;
  public String pSK;
  public String pSL;
  public String pSM;
  public String pSN;
  public LinkedList<AcceptedCardItem> pSO;
  public LinkedList<AccepterItem> pSP;
  public String pSQ;
  public int pSR;
  public String pSS;
  public String pST;
  public String pSU;
  public String pSV;
  public String pSW;
  public String pSX;
  public int pSY;
  public String pSZ;
  public String pSn;
  public String pSo;
  public String pSp;
  public String pSq;
  public String pSr;
  public String pSs;
  public String pSt;
  public String pSu;
  public String pSv;
  public String pSw;
  public String pSx;
  public String pSy;
  public boolean pSz;
  public String pTa;
  public String pTb;
  public String pTc;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new CardGiftInfo.1();
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.pSO = new LinkedList();
    this.pSP = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.pSO = new LinkedList();
    this.pSP = new LinkedList();
    this.dJw = paramParcel.readString();
    this.dYs = paramParcel.readString();
    this.pSn = paramParcel.readString();
    this.pSo = paramParcel.readString();
    this.pSp = paramParcel.readString();
    this.pSq = paramParcel.readString();
    this.pSr = paramParcel.readString();
    this.pSs = paramParcel.readString();
    this.pSt = paramParcel.readString();
    this.pSu = paramParcel.readString();
    this.pSv = paramParcel.readString();
    this.pSw = paramParcel.readString();
    this.pSx = paramParcel.readString();
    this.pSy = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.ixw = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.pSz = bool;
      this.pSA = paramParcel.readInt();
      this.pSB = paramParcel.readInt();
      this.pSC = paramParcel.readInt();
      this.pSD = paramParcel.readString();
      this.pSE = paramParcel.readString();
      this.pSF = paramParcel.readInt();
      this.pSG = paramParcel.readString();
      this.pSH = paramParcel.readString();
      this.pSI = paramParcel.readString();
      this.pSJ = paramParcel.readString();
      this.pSK = paramParcel.readString();
      this.pSL = paramParcel.readString();
      this.pSM = paramParcel.readString();
      this.cardTpId = paramParcel.readString();
      this.pSN = paramParcel.readString();
      paramParcel.readTypedList(this.pSO, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.pSP, AccepterItem.CREATOR);
      this.pSQ = paramParcel.readString();
      this.pSR = paramParcel.readInt();
      this.pSS = paramParcel.readString();
      this.pST = paramParcel.readString();
      this.pST = paramParcel.readString();
      this.pSU = paramParcel.readString();
      this.pSV = paramParcel.readString();
      this.pSW = paramParcel.readString();
      this.pSX = paramParcel.readString();
      this.pSY = paramParcel.readInt();
      this.pSZ = paramParcel.readString();
      this.pTa = paramParcel.readString();
      this.pTb = paramParcel.readString();
      this.pTc = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(as paramas)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dJw = paramas.KDp;
    localCardGiftInfo.dYs = paramas.KDq;
    localCardGiftInfo.pSn = paramas.KDr;
    localCardGiftInfo.pSo = paramas.content;
    localCardGiftInfo.pSp = paramas.KDs;
    localCardGiftInfo.pSq = paramas.KDt;
    localCardGiftInfo.pSr = paramas.KDu;
    localCardGiftInfo.pSs = paramas.KDv;
    localCardGiftInfo.pSu = paramas.KDx;
    localCardGiftInfo.pSt = paramas.KDw;
    localCardGiftInfo.pSv = paramas.KDy;
    localCardGiftInfo.pSw = paramas.KDz;
    localCardGiftInfo.pSx = paramas.pTd;
    localCardGiftInfo.pSy = paramas.pTe;
    localCardGiftInfo.footerWording = paramas.KDA;
    localCardGiftInfo.ixw = paramas.ixw;
    localCardGiftInfo.pSz = paramas.KDB;
    localCardGiftInfo.pSA = paramas.KDC;
    localCardGiftInfo.pSB = paramas.KDD;
    localCardGiftInfo.pSC = paramas.KDE;
    localCardGiftInfo.pSD = paramas.KDF;
    localCardGiftInfo.pSE = paramas.KDG;
    localCardGiftInfo.pSF = paramas.KDH;
    localCardGiftInfo.pSG = paramas.KDI;
    localCardGiftInfo.pSH = paramas.KDJ;
    localCardGiftInfo.pSI = paramas.KDK;
    localCardGiftInfo.pSJ = paramas.KDL;
    localCardGiftInfo.pSK = paramas.KDM;
    localCardGiftInfo.pSL = paramas.KDN;
    localCardGiftInfo.pSM = paramas.KDO;
    localCardGiftInfo.cardTpId = paramas.pRX;
    localCardGiftInfo.pSN = paramas.KDP;
    Iterator localIterator = paramas.pSO.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (av)localIterator.next();
      localLinkedList = localCardGiftInfo.pSO;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).pTe = ((av)localObject1).pTe;
      ((AcceptedCardItem)localObject2).pTd = ((av)localObject1).pTd;
      localLinkedList.add(localObject2);
    }
    localIterator = paramas.pSP.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (aw)localIterator.next();
      localLinkedList = localCardGiftInfo.pSP;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).pTe = ((aw)localObject1).pTe;
      ((AccepterItem)localObject2).pTd = ((aw)localObject1).pTd;
      ((AccepterItem)localObject2).pTg = ((aw)localObject1).pTg;
      ((AccepterItem)localObject2).pTf = ((aw)localObject1).pTf;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.pSQ = paramas.pSQ;
    localCardGiftInfo.pSR = paramas.pSR;
    localCardGiftInfo.pSS = paramas.pSS;
    localCardGiftInfo.pST = paramas.pST;
    localCardGiftInfo.pSU = paramas.pSU;
    localCardGiftInfo.pSV = paramas.pSV;
    localCardGiftInfo.pSW = paramas.pSW;
    localCardGiftInfo.pSX = paramas.pSX;
    localCardGiftInfo.pSY = paramas.pSY;
    localCardGiftInfo.pSZ = paramas.pSZ;
    localCardGiftInfo.pTb = paramas.pTb;
    localCardGiftInfo.pTa = paramas.pTa;
    localCardGiftInfo.pTc = paramas.pTc;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(bki parambki)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dJw = parambki.KDp;
    localCardGiftInfo.dYs = parambki.KDq;
    localCardGiftInfo.pSn = parambki.KDr;
    localCardGiftInfo.pSo = parambki.content;
    localCardGiftInfo.pSp = parambki.KDs;
    localCardGiftInfo.pSq = parambki.KDt;
    localCardGiftInfo.pSr = parambki.KDu;
    localCardGiftInfo.pSs = parambki.KDv;
    localCardGiftInfo.pSu = parambki.KDx;
    localCardGiftInfo.pSt = parambki.KDw;
    localCardGiftInfo.pSv = parambki.KDy;
    localCardGiftInfo.pSw = parambki.KDz;
    localCardGiftInfo.pSx = parambki.pTd;
    localCardGiftInfo.pSy = parambki.pTe;
    localCardGiftInfo.footerWording = parambki.KDA;
    localCardGiftInfo.ixw = parambki.ixw;
    localCardGiftInfo.pSz = parambki.KDB;
    localCardGiftInfo.pSA = parambki.KDC;
    localCardGiftInfo.pSB = parambki.KDD;
    localCardGiftInfo.pSC = parambki.KDE;
    localCardGiftInfo.pSD = parambki.KDF;
    localCardGiftInfo.pSE = parambki.KDG;
    localCardGiftInfo.pSF = parambki.LTy;
    localCardGiftInfo.pSG = parambki.KDI;
    localCardGiftInfo.pSH = parambki.KDJ;
    localCardGiftInfo.pSI = parambki.KDK;
    localCardGiftInfo.pSJ = parambki.KDL;
    localCardGiftInfo.pSK = parambki.KDM;
    localCardGiftInfo.pSL = parambki.KDN;
    localCardGiftInfo.pSM = parambki.KDO;
    localCardGiftInfo.cardTpId = parambki.pRX;
    localCardGiftInfo.pSN = parambki.KDP;
    localCardGiftInfo.pSS = parambki.pSS;
    localCardGiftInfo.pST = parambki.pST;
    localCardGiftInfo.pSU = parambki.pSU;
    localCardGiftInfo.pSV = parambki.pSV;
    localCardGiftInfo.pSW = parambki.pSW;
    localCardGiftInfo.pSX = parambki.pSX;
    localCardGiftInfo.pSY = parambki.pSY;
    localCardGiftInfo.pSZ = parambki.pSZ;
    localCardGiftInfo.pTb = parambki.pTb;
    localCardGiftInfo.pTa = parambki.pTa;
    localCardGiftInfo.pTc = parambki.pTc;
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
    String str = "CardGiftInfo{toUserName='" + this.dJw + '\'' + ", fromUserName='" + this.dYs + '\'' + ", fromUserImgUrl='" + this.pSn + '\'' + ", fromUserContent='" + this.pSo + '\'' + ", fromUserContentPicUrl='" + this.pSp + '\'' + ", fromUserContentVideoUrl='" + this.pSq + '\'' + ", fromUserContentThumbPicUrl='" + this.pSr + '\'' + ", picAESKey='" + this.pSs + '\'' + ", videoAESKey='" + this.pSt + '\'' + ", thumbVideoAESKey='" + this.pSu + '\'' + ", cardBackgroundPicUrl='" + this.pSv + '\'' + ", cardLogoLUrl='" + this.pSw + '\'' + ", cardTitle='" + this.pSx + '\'' + ", cardPrice='" + this.pSy + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.ixw + '\'' + ", needJump=" + this.pSz + ", picDataLength=" + this.pSA + ", videoDataLength=" + this.pSB + ", thumbDataLength=" + this.pSC + ", descTitle='" + this.pSD + '\'' + ", descIconUrl='" + this.pSE + '\'' + ", descLayoutMode=" + this.pSF + ", giftingMediaTitle='" + this.pSG + '\'' + ", descriptionTitleColor='" + this.pSH + '\'' + ", cardTitleColor='" + this.pSI + '\'' + ", cardPriceTitleColor='" + this.pSJ + '\'' + ", userCardId='" + this.pSK + '\'' + ", operationTitle='" + this.pSL + '\'' + ", operationUrl='" + this.pSM + '\'' + ", cardTpId='" + this.cardTpId + '\'' + ", cardCode='" + this.pSN + '\'' + ", accepted_card_list_size='" + this.pSO.size() + '\'' + ", accepter_list_size='" + this.pSP.size() + '\'' + ", accepter_list_title='" + this.pSQ + '\'' + ", out_of_card='" + this.pSR + '\'' + ", operation_wxa_username='" + this.pSS + '\'' + ", operation_wxa_path='" + this.pST + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.dJw);
    paramParcel.writeString(this.dYs);
    paramParcel.writeString(this.pSn);
    paramParcel.writeString(this.pSo);
    paramParcel.writeString(this.pSp);
    paramParcel.writeString(this.pSq);
    paramParcel.writeString(this.pSr);
    paramParcel.writeString(this.pSs);
    paramParcel.writeString(this.pSt);
    paramParcel.writeString(this.pSu);
    paramParcel.writeString(this.pSv);
    paramParcel.writeString(this.pSw);
    paramParcel.writeString(this.pSx);
    paramParcel.writeString(this.pSy);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.ixw);
    if (this.pSz) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.pSA);
      paramParcel.writeInt(this.pSB);
      paramParcel.writeInt(this.pSC);
      paramParcel.writeString(this.pSD);
      paramParcel.writeString(this.pSE);
      paramParcel.writeInt(this.pSF);
      paramParcel.writeString(this.pSG);
      paramParcel.writeString(this.pSH);
      paramParcel.writeString(this.pSI);
      paramParcel.writeString(this.pSJ);
      paramParcel.writeString(this.pSK);
      paramParcel.writeString(this.pSL);
      paramParcel.writeString(this.pSM);
      paramParcel.writeString(this.cardTpId);
      paramParcel.writeString(this.pSN);
      paramParcel.writeTypedList(this.pSO);
      paramParcel.writeTypedList(this.pSP);
      paramParcel.writeString(this.pSQ);
      paramParcel.writeInt(this.pSR);
      paramParcel.writeString(this.pSS);
      paramParcel.writeString(this.pST);
      paramParcel.writeString(this.pST);
      paramParcel.writeString(this.pSU);
      paramParcel.writeString(this.pSV);
      paramParcel.writeString(this.pSW);
      paramParcel.writeString(this.pSX);
      paramParcel.writeInt(this.pSY);
      paramParcel.writeString(this.pSZ);
      paramParcel.writeString(this.pTa);
      paramParcel.writeString(this.pTb);
      paramParcel.writeString(this.pTc);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String pTd;
    public String pTe;
    
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
      this.pTd = paramParcel.readString();
      this.pTe = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.pTd);
      paramParcel.writeString(this.pTe);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String pTd;
    public String pTe;
    public String pTf;
    public String pTg;
    
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
      this.pTd = paramParcel.readString();
      this.pTe = paramParcel.readString();
      this.pTf = paramParcel.readString();
      this.pTg = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.pTd);
      paramParcel.writeString(this.pTe);
      paramParcel.writeString(this.pTf);
      paramParcel.writeString(this.pTg);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */