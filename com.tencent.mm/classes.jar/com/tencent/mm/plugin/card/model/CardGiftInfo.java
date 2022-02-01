package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.auk;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String dfJ;
  public String dtD;
  public String footerWording;
  public String hiu;
  public String nUH;
  public String nUI;
  public String nUJ;
  public String nUK;
  public String nUL;
  public String nUM;
  public String nUN;
  public String nUO;
  public String nUP;
  public String nUQ;
  public String nUR;
  public String nUS;
  public boolean nUT;
  public int nUU;
  public int nUV;
  public int nUW;
  public String nUX;
  public String nUY;
  public int nUZ;
  public String nVa;
  public String nVb;
  public String nVc;
  public String nVd;
  public String nVe;
  public String nVf;
  public String nVg;
  public String nVh;
  public String nVi;
  public LinkedList<AcceptedCardItem> nVj;
  public LinkedList<AccepterItem> nVk;
  public String nVl;
  public int nVm;
  public String nVn;
  public String nVo;
  public String nVp;
  public String nVq;
  public String nVr;
  public String nVs;
  public int nVt;
  public String nVu;
  public String nVv;
  public String nVw;
  public String nVx;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.nVj = new LinkedList();
    this.nVk = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.nVj = new LinkedList();
    this.nVk = new LinkedList();
    this.dfJ = paramParcel.readString();
    this.dtD = paramParcel.readString();
    this.nUH = paramParcel.readString();
    this.nUI = paramParcel.readString();
    this.nUJ = paramParcel.readString();
    this.nUK = paramParcel.readString();
    this.nUL = paramParcel.readString();
    this.nUM = paramParcel.readString();
    this.nUN = paramParcel.readString();
    this.nUO = paramParcel.readString();
    this.nUP = paramParcel.readString();
    this.nUQ = paramParcel.readString();
    this.nUR = paramParcel.readString();
    this.nUS = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.hiu = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nUT = bool;
      this.nUU = paramParcel.readInt();
      this.nUV = paramParcel.readInt();
      this.nUW = paramParcel.readInt();
      this.nUX = paramParcel.readString();
      this.nUY = paramParcel.readString();
      this.nUZ = paramParcel.readInt();
      this.nVa = paramParcel.readString();
      this.nVb = paramParcel.readString();
      this.nVc = paramParcel.readString();
      this.nVd = paramParcel.readString();
      this.nVe = paramParcel.readString();
      this.nVf = paramParcel.readString();
      this.nVg = paramParcel.readString();
      this.nVh = paramParcel.readString();
      this.nVi = paramParcel.readString();
      paramParcel.readTypedList(this.nVj, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.nVk, AccepterItem.CREATOR);
      this.nVl = paramParcel.readString();
      this.nVm = paramParcel.readInt();
      this.nVn = paramParcel.readString();
      this.nVo = paramParcel.readString();
      this.nVo = paramParcel.readString();
      this.nVp = paramParcel.readString();
      this.nVq = paramParcel.readString();
      this.nVr = paramParcel.readString();
      this.nVs = paramParcel.readString();
      this.nVt = paramParcel.readInt();
      this.nVu = paramParcel.readString();
      this.nVv = paramParcel.readString();
      this.nVw = paramParcel.readString();
      this.nVx = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(aq paramaq)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dfJ = paramaq.DMu;
    localCardGiftInfo.dtD = paramaq.DMv;
    localCardGiftInfo.nUH = paramaq.DMw;
    localCardGiftInfo.nUI = paramaq.content;
    localCardGiftInfo.nUJ = paramaq.DMx;
    localCardGiftInfo.nUK = paramaq.DMy;
    localCardGiftInfo.nUL = paramaq.DMz;
    localCardGiftInfo.nUM = paramaq.DMA;
    localCardGiftInfo.nUO = paramaq.DMC;
    localCardGiftInfo.nUN = paramaq.DMB;
    localCardGiftInfo.nUP = paramaq.DMD;
    localCardGiftInfo.nUQ = paramaq.DME;
    localCardGiftInfo.nUR = paramaq.nVy;
    localCardGiftInfo.nUS = paramaq.nVz;
    localCardGiftInfo.footerWording = paramaq.DMF;
    localCardGiftInfo.hiu = paramaq.hiu;
    localCardGiftInfo.nUT = paramaq.DMG;
    localCardGiftInfo.nUU = paramaq.DMH;
    localCardGiftInfo.nUV = paramaq.DMI;
    localCardGiftInfo.nUW = paramaq.DMJ;
    localCardGiftInfo.nUX = paramaq.DMK;
    localCardGiftInfo.nUY = paramaq.DML;
    localCardGiftInfo.nUZ = paramaq.DMM;
    localCardGiftInfo.nVa = paramaq.DMN;
    localCardGiftInfo.nVb = paramaq.DMO;
    localCardGiftInfo.nVc = paramaq.DMP;
    localCardGiftInfo.nVd = paramaq.DMQ;
    localCardGiftInfo.nVe = paramaq.DMR;
    localCardGiftInfo.nVf = paramaq.DMS;
    localCardGiftInfo.nVg = paramaq.DMT;
    localCardGiftInfo.nVh = paramaq.nUr;
    localCardGiftInfo.nVi = paramaq.DMU;
    Iterator localIterator = paramaq.nVj.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (at)localIterator.next();
      localLinkedList = localCardGiftInfo.nVj;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).nVz = ((at)localObject1).nVz;
      ((AcceptedCardItem)localObject2).nVy = ((at)localObject1).nVy;
      localLinkedList.add(localObject2);
    }
    localIterator = paramaq.nVk.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (au)localIterator.next();
      localLinkedList = localCardGiftInfo.nVk;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).nVz = ((au)localObject1).nVz;
      ((AccepterItem)localObject2).nVy = ((au)localObject1).nVy;
      ((AccepterItem)localObject2).nVB = ((au)localObject1).nVB;
      ((AccepterItem)localObject2).nVA = ((au)localObject1).nVA;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.nVl = paramaq.nVl;
    localCardGiftInfo.nVm = paramaq.nVm;
    localCardGiftInfo.nVn = paramaq.nVn;
    localCardGiftInfo.nVo = paramaq.nVo;
    localCardGiftInfo.nVp = paramaq.nVp;
    localCardGiftInfo.nVq = paramaq.nVq;
    localCardGiftInfo.nVr = paramaq.nVr;
    localCardGiftInfo.nVs = paramaq.nVs;
    localCardGiftInfo.nVt = paramaq.nVt;
    localCardGiftInfo.nVu = paramaq.nVu;
    localCardGiftInfo.nVw = paramaq.nVw;
    localCardGiftInfo.nVv = paramaq.nVv;
    localCardGiftInfo.nVx = paramaq.nVx;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(auk paramauk)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dfJ = paramauk.DMu;
    localCardGiftInfo.dtD = paramauk.DMv;
    localCardGiftInfo.nUH = paramauk.DMw;
    localCardGiftInfo.nUI = paramauk.content;
    localCardGiftInfo.nUJ = paramauk.DMx;
    localCardGiftInfo.nUK = paramauk.DMy;
    localCardGiftInfo.nUL = paramauk.DMz;
    localCardGiftInfo.nUM = paramauk.DMA;
    localCardGiftInfo.nUO = paramauk.DMC;
    localCardGiftInfo.nUN = paramauk.DMB;
    localCardGiftInfo.nUP = paramauk.DMD;
    localCardGiftInfo.nUQ = paramauk.DME;
    localCardGiftInfo.nUR = paramauk.nVy;
    localCardGiftInfo.nUS = paramauk.nVz;
    localCardGiftInfo.footerWording = paramauk.DMF;
    localCardGiftInfo.hiu = paramauk.hiu;
    localCardGiftInfo.nUT = paramauk.DMG;
    localCardGiftInfo.nUU = paramauk.DMH;
    localCardGiftInfo.nUV = paramauk.DMI;
    localCardGiftInfo.nUW = paramauk.DMJ;
    localCardGiftInfo.nUX = paramauk.DMK;
    localCardGiftInfo.nUY = paramauk.DML;
    localCardGiftInfo.nUZ = paramauk.EMP;
    localCardGiftInfo.nVa = paramauk.DMN;
    localCardGiftInfo.nVb = paramauk.DMO;
    localCardGiftInfo.nVc = paramauk.DMP;
    localCardGiftInfo.nVd = paramauk.DMQ;
    localCardGiftInfo.nVe = paramauk.DMR;
    localCardGiftInfo.nVf = paramauk.DMS;
    localCardGiftInfo.nVg = paramauk.DMT;
    localCardGiftInfo.nVh = paramauk.nUr;
    localCardGiftInfo.nVi = paramauk.DMU;
    localCardGiftInfo.nVn = paramauk.nVn;
    localCardGiftInfo.nVo = paramauk.nVo;
    localCardGiftInfo.nVp = paramauk.nVp;
    localCardGiftInfo.nVq = paramauk.nVq;
    localCardGiftInfo.nVr = paramauk.nVr;
    localCardGiftInfo.nVs = paramauk.nVs;
    localCardGiftInfo.nVt = paramauk.nVt;
    localCardGiftInfo.nVu = paramauk.nVu;
    localCardGiftInfo.nVw = paramauk.nVw;
    localCardGiftInfo.nVv = paramauk.nVv;
    localCardGiftInfo.nVx = paramauk.nVx;
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
    String str = "CardGiftInfo{toUserName='" + this.dfJ + '\'' + ", fromUserName='" + this.dtD + '\'' + ", fromUserImgUrl='" + this.nUH + '\'' + ", fromUserContent='" + this.nUI + '\'' + ", fromUserContentPicUrl='" + this.nUJ + '\'' + ", fromUserContentVideoUrl='" + this.nUK + '\'' + ", fromUserContentThumbPicUrl='" + this.nUL + '\'' + ", picAESKey='" + this.nUM + '\'' + ", videoAESKey='" + this.nUN + '\'' + ", thumbVideoAESKey='" + this.nUO + '\'' + ", cardBackgroundPicUrl='" + this.nUP + '\'' + ", cardLogoLUrl='" + this.nUQ + '\'' + ", cardTitle='" + this.nUR + '\'' + ", cardPrice='" + this.nUS + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.hiu + '\'' + ", needJump=" + this.nUT + ", picDataLength=" + this.nUU + ", videoDataLength=" + this.nUV + ", thumbDataLength=" + this.nUW + ", descTitle='" + this.nUX + '\'' + ", descIconUrl='" + this.nUY + '\'' + ", descLayoutMode=" + this.nUZ + ", giftingMediaTitle='" + this.nVa + '\'' + ", descriptionTitleColor='" + this.nVb + '\'' + ", cardTitleColor='" + this.nVc + '\'' + ", cardPriceTitleColor='" + this.nVd + '\'' + ", userCardId='" + this.nVe + '\'' + ", operationTitle='" + this.nVf + '\'' + ", operationUrl='" + this.nVg + '\'' + ", cardTpId='" + this.nVh + '\'' + ", cardCode='" + this.nVi + '\'' + ", accepted_card_list_size='" + this.nVj.size() + '\'' + ", accepter_list_size='" + this.nVk.size() + '\'' + ", accepter_list_title='" + this.nVl + '\'' + ", out_of_card='" + this.nVm + '\'' + ", operation_wxa_username='" + this.nVn + '\'' + ", operation_wxa_path='" + this.nVo + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.dfJ);
    paramParcel.writeString(this.dtD);
    paramParcel.writeString(this.nUH);
    paramParcel.writeString(this.nUI);
    paramParcel.writeString(this.nUJ);
    paramParcel.writeString(this.nUK);
    paramParcel.writeString(this.nUL);
    paramParcel.writeString(this.nUM);
    paramParcel.writeString(this.nUN);
    paramParcel.writeString(this.nUO);
    paramParcel.writeString(this.nUP);
    paramParcel.writeString(this.nUQ);
    paramParcel.writeString(this.nUR);
    paramParcel.writeString(this.nUS);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.hiu);
    if (this.nUT) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.nUU);
      paramParcel.writeInt(this.nUV);
      paramParcel.writeInt(this.nUW);
      paramParcel.writeString(this.nUX);
      paramParcel.writeString(this.nUY);
      paramParcel.writeInt(this.nUZ);
      paramParcel.writeString(this.nVa);
      paramParcel.writeString(this.nVb);
      paramParcel.writeString(this.nVc);
      paramParcel.writeString(this.nVd);
      paramParcel.writeString(this.nVe);
      paramParcel.writeString(this.nVf);
      paramParcel.writeString(this.nVg);
      paramParcel.writeString(this.nVh);
      paramParcel.writeString(this.nVi);
      paramParcel.writeTypedList(this.nVj);
      paramParcel.writeTypedList(this.nVk);
      paramParcel.writeString(this.nVl);
      paramParcel.writeInt(this.nVm);
      paramParcel.writeString(this.nVn);
      paramParcel.writeString(this.nVo);
      paramParcel.writeString(this.nVo);
      paramParcel.writeString(this.nVp);
      paramParcel.writeString(this.nVq);
      paramParcel.writeString(this.nVr);
      paramParcel.writeString(this.nVs);
      paramParcel.writeInt(this.nVt);
      paramParcel.writeString(this.nVu);
      paramParcel.writeString(this.nVv);
      paramParcel.writeString(this.nVw);
      paramParcel.writeString(this.nVx);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String nVy;
    public String nVz;
    
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
      this.nVy = paramParcel.readString();
      this.nVz = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.nVy);
      paramParcel.writeString(this.nVz);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String nVA;
    public String nVB;
    public String nVy;
    public String nVz;
    
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
      this.nVy = paramParcel.readString();
      this.nVz = paramParcel.readString();
      this.nVA = paramParcel.readString();
      this.nVB = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.nVy);
      paramParcel.writeString(this.nVz);
      paramParcel.writeString(this.nVA);
      paramParcel.writeString(this.nVB);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */