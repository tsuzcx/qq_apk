package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.ayy;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String dGJ;
  public String dsk;
  public String footerWording;
  public String hDr;
  public String oEE;
  public String oEF;
  public String oEG;
  public String oEH;
  public String oEI;
  public String oEJ;
  public String oEK;
  public String oEL;
  public String oEM;
  public String oEN;
  public String oEO;
  public String oEP;
  public boolean oEQ;
  public int oER;
  public int oES;
  public int oET;
  public String oEU;
  public String oEV;
  public int oEW;
  public String oEX;
  public String oEY;
  public String oEZ;
  public String oFa;
  public String oFb;
  public String oFc;
  public String oFd;
  public String oFe;
  public String oFf;
  public LinkedList<AcceptedCardItem> oFg;
  public LinkedList<AccepterItem> oFh;
  public String oFi;
  public int oFj;
  public String oFk;
  public String oFl;
  public String oFm;
  public String oFn;
  public String oFo;
  public String oFp;
  public int oFq;
  public String oFr;
  public String oFs;
  public String oFt;
  public String oFu;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.oFg = new LinkedList();
    this.oFh = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.oFg = new LinkedList();
    this.oFh = new LinkedList();
    this.dsk = paramParcel.readString();
    this.dGJ = paramParcel.readString();
    this.oEE = paramParcel.readString();
    this.oEF = paramParcel.readString();
    this.oEG = paramParcel.readString();
    this.oEH = paramParcel.readString();
    this.oEI = paramParcel.readString();
    this.oEJ = paramParcel.readString();
    this.oEK = paramParcel.readString();
    this.oEL = paramParcel.readString();
    this.oEM = paramParcel.readString();
    this.oEN = paramParcel.readString();
    this.oEO = paramParcel.readString();
    this.oEP = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.hDr = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oEQ = bool;
      this.oER = paramParcel.readInt();
      this.oES = paramParcel.readInt();
      this.oET = paramParcel.readInt();
      this.oEU = paramParcel.readString();
      this.oEV = paramParcel.readString();
      this.oEW = paramParcel.readInt();
      this.oEX = paramParcel.readString();
      this.oEY = paramParcel.readString();
      this.oEZ = paramParcel.readString();
      this.oFa = paramParcel.readString();
      this.oFb = paramParcel.readString();
      this.oFc = paramParcel.readString();
      this.oFd = paramParcel.readString();
      this.oFe = paramParcel.readString();
      this.oFf = paramParcel.readString();
      paramParcel.readTypedList(this.oFg, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.oFh, AccepterItem.CREATOR);
      this.oFi = paramParcel.readString();
      this.oFj = paramParcel.readInt();
      this.oFk = paramParcel.readString();
      this.oFl = paramParcel.readString();
      this.oFl = paramParcel.readString();
      this.oFm = paramParcel.readString();
      this.oFn = paramParcel.readString();
      this.oFo = paramParcel.readString();
      this.oFp = paramParcel.readString();
      this.oFq = paramParcel.readInt();
      this.oFr = paramParcel.readString();
      this.oFs = paramParcel.readString();
      this.oFt = paramParcel.readString();
      this.oFu = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(aq paramaq)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dsk = paramaq.FJX;
    localCardGiftInfo.dGJ = paramaq.FJY;
    localCardGiftInfo.oEE = paramaq.FJZ;
    localCardGiftInfo.oEF = paramaq.content;
    localCardGiftInfo.oEG = paramaq.FKa;
    localCardGiftInfo.oEH = paramaq.FKb;
    localCardGiftInfo.oEI = paramaq.FKc;
    localCardGiftInfo.oEJ = paramaq.FKd;
    localCardGiftInfo.oEL = paramaq.FKf;
    localCardGiftInfo.oEK = paramaq.FKe;
    localCardGiftInfo.oEM = paramaq.FKg;
    localCardGiftInfo.oEN = paramaq.FKh;
    localCardGiftInfo.oEO = paramaq.oFv;
    localCardGiftInfo.oEP = paramaq.oFw;
    localCardGiftInfo.footerWording = paramaq.FKi;
    localCardGiftInfo.hDr = paramaq.hDr;
    localCardGiftInfo.oEQ = paramaq.FKj;
    localCardGiftInfo.oER = paramaq.FKk;
    localCardGiftInfo.oES = paramaq.FKl;
    localCardGiftInfo.oET = paramaq.FKm;
    localCardGiftInfo.oEU = paramaq.FKn;
    localCardGiftInfo.oEV = paramaq.FKo;
    localCardGiftInfo.oEW = paramaq.FKp;
    localCardGiftInfo.oEX = paramaq.FKq;
    localCardGiftInfo.oEY = paramaq.FKr;
    localCardGiftInfo.oEZ = paramaq.FKs;
    localCardGiftInfo.oFa = paramaq.FKt;
    localCardGiftInfo.oFb = paramaq.FKu;
    localCardGiftInfo.oFc = paramaq.FKv;
    localCardGiftInfo.oFd = paramaq.FKw;
    localCardGiftInfo.oFe = paramaq.oEo;
    localCardGiftInfo.oFf = paramaq.FKx;
    Iterator localIterator = paramaq.oFg.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (at)localIterator.next();
      localLinkedList = localCardGiftInfo.oFg;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).oFw = ((at)localObject1).oFw;
      ((AcceptedCardItem)localObject2).oFv = ((at)localObject1).oFv;
      localLinkedList.add(localObject2);
    }
    localIterator = paramaq.oFh.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (au)localIterator.next();
      localLinkedList = localCardGiftInfo.oFh;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).oFw = ((au)localObject1).oFw;
      ((AccepterItem)localObject2).oFv = ((au)localObject1).oFv;
      ((AccepterItem)localObject2).oFy = ((au)localObject1).oFy;
      ((AccepterItem)localObject2).oFx = ((au)localObject1).oFx;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.oFi = paramaq.oFi;
    localCardGiftInfo.oFj = paramaq.oFj;
    localCardGiftInfo.oFk = paramaq.oFk;
    localCardGiftInfo.oFl = paramaq.oFl;
    localCardGiftInfo.oFm = paramaq.oFm;
    localCardGiftInfo.oFn = paramaq.oFn;
    localCardGiftInfo.oFo = paramaq.oFo;
    localCardGiftInfo.oFp = paramaq.oFp;
    localCardGiftInfo.oFq = paramaq.oFq;
    localCardGiftInfo.oFr = paramaq.oFr;
    localCardGiftInfo.oFt = paramaq.oFt;
    localCardGiftInfo.oFs = paramaq.oFs;
    localCardGiftInfo.oFu = paramaq.oFu;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(ayy paramayy)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.dsk = paramayy.FJX;
    localCardGiftInfo.dGJ = paramayy.FJY;
    localCardGiftInfo.oEE = paramayy.FJZ;
    localCardGiftInfo.oEF = paramayy.content;
    localCardGiftInfo.oEG = paramayy.FKa;
    localCardGiftInfo.oEH = paramayy.FKb;
    localCardGiftInfo.oEI = paramayy.FKc;
    localCardGiftInfo.oEJ = paramayy.FKd;
    localCardGiftInfo.oEL = paramayy.FKf;
    localCardGiftInfo.oEK = paramayy.FKe;
    localCardGiftInfo.oEM = paramayy.FKg;
    localCardGiftInfo.oEN = paramayy.FKh;
    localCardGiftInfo.oEO = paramayy.oFv;
    localCardGiftInfo.oEP = paramayy.oFw;
    localCardGiftInfo.footerWording = paramayy.FKi;
    localCardGiftInfo.hDr = paramayy.hDr;
    localCardGiftInfo.oEQ = paramayy.FKj;
    localCardGiftInfo.oER = paramayy.FKk;
    localCardGiftInfo.oES = paramayy.FKl;
    localCardGiftInfo.oET = paramayy.FKm;
    localCardGiftInfo.oEU = paramayy.FKn;
    localCardGiftInfo.oEV = paramayy.FKo;
    localCardGiftInfo.oEW = paramayy.GPs;
    localCardGiftInfo.oEX = paramayy.FKq;
    localCardGiftInfo.oEY = paramayy.FKr;
    localCardGiftInfo.oEZ = paramayy.FKs;
    localCardGiftInfo.oFa = paramayy.FKt;
    localCardGiftInfo.oFb = paramayy.FKu;
    localCardGiftInfo.oFc = paramayy.FKv;
    localCardGiftInfo.oFd = paramayy.FKw;
    localCardGiftInfo.oFe = paramayy.oEo;
    localCardGiftInfo.oFf = paramayy.FKx;
    localCardGiftInfo.oFk = paramayy.oFk;
    localCardGiftInfo.oFl = paramayy.oFl;
    localCardGiftInfo.oFm = paramayy.oFm;
    localCardGiftInfo.oFn = paramayy.oFn;
    localCardGiftInfo.oFo = paramayy.oFo;
    localCardGiftInfo.oFp = paramayy.oFp;
    localCardGiftInfo.oFq = paramayy.oFq;
    localCardGiftInfo.oFr = paramayy.oFr;
    localCardGiftInfo.oFt = paramayy.oFt;
    localCardGiftInfo.oFs = paramayy.oFs;
    localCardGiftInfo.oFu = paramayy.oFu;
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
    String str = "CardGiftInfo{toUserName='" + this.dsk + '\'' + ", fromUserName='" + this.dGJ + '\'' + ", fromUserImgUrl='" + this.oEE + '\'' + ", fromUserContent='" + this.oEF + '\'' + ", fromUserContentPicUrl='" + this.oEG + '\'' + ", fromUserContentVideoUrl='" + this.oEH + '\'' + ", fromUserContentThumbPicUrl='" + this.oEI + '\'' + ", picAESKey='" + this.oEJ + '\'' + ", videoAESKey='" + this.oEK + '\'' + ", thumbVideoAESKey='" + this.oEL + '\'' + ", cardBackgroundPicUrl='" + this.oEM + '\'' + ", cardLogoLUrl='" + this.oEN + '\'' + ", cardTitle='" + this.oEO + '\'' + ", cardPrice='" + this.oEP + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.hDr + '\'' + ", needJump=" + this.oEQ + ", picDataLength=" + this.oER + ", videoDataLength=" + this.oES + ", thumbDataLength=" + this.oET + ", descTitle='" + this.oEU + '\'' + ", descIconUrl='" + this.oEV + '\'' + ", descLayoutMode=" + this.oEW + ", giftingMediaTitle='" + this.oEX + '\'' + ", descriptionTitleColor='" + this.oEY + '\'' + ", cardTitleColor='" + this.oEZ + '\'' + ", cardPriceTitleColor='" + this.oFa + '\'' + ", userCardId='" + this.oFb + '\'' + ", operationTitle='" + this.oFc + '\'' + ", operationUrl='" + this.oFd + '\'' + ", cardTpId='" + this.oFe + '\'' + ", cardCode='" + this.oFf + '\'' + ", accepted_card_list_size='" + this.oFg.size() + '\'' + ", accepter_list_size='" + this.oFh.size() + '\'' + ", accepter_list_title='" + this.oFi + '\'' + ", out_of_card='" + this.oFj + '\'' + ", operation_wxa_username='" + this.oFk + '\'' + ", operation_wxa_path='" + this.oFl + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.dsk);
    paramParcel.writeString(this.dGJ);
    paramParcel.writeString(this.oEE);
    paramParcel.writeString(this.oEF);
    paramParcel.writeString(this.oEG);
    paramParcel.writeString(this.oEH);
    paramParcel.writeString(this.oEI);
    paramParcel.writeString(this.oEJ);
    paramParcel.writeString(this.oEK);
    paramParcel.writeString(this.oEL);
    paramParcel.writeString(this.oEM);
    paramParcel.writeString(this.oEN);
    paramParcel.writeString(this.oEO);
    paramParcel.writeString(this.oEP);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.hDr);
    if (this.oEQ) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.oER);
      paramParcel.writeInt(this.oES);
      paramParcel.writeInt(this.oET);
      paramParcel.writeString(this.oEU);
      paramParcel.writeString(this.oEV);
      paramParcel.writeInt(this.oEW);
      paramParcel.writeString(this.oEX);
      paramParcel.writeString(this.oEY);
      paramParcel.writeString(this.oEZ);
      paramParcel.writeString(this.oFa);
      paramParcel.writeString(this.oFb);
      paramParcel.writeString(this.oFc);
      paramParcel.writeString(this.oFd);
      paramParcel.writeString(this.oFe);
      paramParcel.writeString(this.oFf);
      paramParcel.writeTypedList(this.oFg);
      paramParcel.writeTypedList(this.oFh);
      paramParcel.writeString(this.oFi);
      paramParcel.writeInt(this.oFj);
      paramParcel.writeString(this.oFk);
      paramParcel.writeString(this.oFl);
      paramParcel.writeString(this.oFl);
      paramParcel.writeString(this.oFm);
      paramParcel.writeString(this.oFn);
      paramParcel.writeString(this.oFo);
      paramParcel.writeString(this.oFp);
      paramParcel.writeInt(this.oFq);
      paramParcel.writeString(this.oFr);
      paramParcel.writeString(this.oFs);
      paramParcel.writeString(this.oFt);
      paramParcel.writeString(this.oFu);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String oFv;
    public String oFw;
    
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
      this.oFv = paramParcel.readString();
      this.oFw = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.oFv);
      paramParcel.writeString(this.oFw);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String oFv;
    public String oFw;
    public String oFx;
    public String oFy;
    
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
      this.oFv = paramParcel.readString();
      this.oFw = paramParcel.readString();
      this.oFx = paramParcel.readString();
      this.oFy = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.oFv);
      paramParcel.writeString(this.oFw);
      paramParcel.writeString(this.oFx);
      paramParcel.writeString(this.oFy);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */