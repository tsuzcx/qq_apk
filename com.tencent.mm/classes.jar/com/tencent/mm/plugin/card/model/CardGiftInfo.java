package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.ayi;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String dFE;
  public String drf;
  public String footerWording;
  public String hAD;
  public String oyA;
  public String oyB;
  public String oyC;
  public String oyD;
  public LinkedList<AcceptedCardItem> oyE;
  public LinkedList<AccepterItem> oyF;
  public String oyG;
  public int oyH;
  public String oyI;
  public String oyJ;
  public String oyK;
  public String oyL;
  public String oyM;
  public String oyN;
  public int oyO;
  public String oyP;
  public String oyQ;
  public String oyR;
  public String oyS;
  public String oyc;
  public String oyd;
  public String oye;
  public String oyf;
  public String oyg;
  public String oyh;
  public String oyi;
  public String oyj;
  public String oyk;
  public String oyl;
  public String oym;
  public String oyn;
  public boolean oyo;
  public int oyp;
  public int oyq;
  public int oyr;
  public String oys;
  public String oyt;
  public int oyu;
  public String oyv;
  public String oyw;
  public String oyx;
  public String oyy;
  public String oyz;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.oyE = new LinkedList();
    this.oyF = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.oyE = new LinkedList();
    this.oyF = new LinkedList();
    this.drf = paramParcel.readString();
    this.dFE = paramParcel.readString();
    this.oyc = paramParcel.readString();
    this.oyd = paramParcel.readString();
    this.oye = paramParcel.readString();
    this.oyf = paramParcel.readString();
    this.oyg = paramParcel.readString();
    this.oyh = paramParcel.readString();
    this.oyi = paramParcel.readString();
    this.oyj = paramParcel.readString();
    this.oyk = paramParcel.readString();
    this.oyl = paramParcel.readString();
    this.oym = paramParcel.readString();
    this.oyn = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.hAD = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oyo = bool;
      this.oyp = paramParcel.readInt();
      this.oyq = paramParcel.readInt();
      this.oyr = paramParcel.readInt();
      this.oys = paramParcel.readString();
      this.oyt = paramParcel.readString();
      this.oyu = paramParcel.readInt();
      this.oyv = paramParcel.readString();
      this.oyw = paramParcel.readString();
      this.oyx = paramParcel.readString();
      this.oyy = paramParcel.readString();
      this.oyz = paramParcel.readString();
      this.oyA = paramParcel.readString();
      this.oyB = paramParcel.readString();
      this.oyC = paramParcel.readString();
      this.oyD = paramParcel.readString();
      paramParcel.readTypedList(this.oyE, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.oyF, AccepterItem.CREATOR);
      this.oyG = paramParcel.readString();
      this.oyH = paramParcel.readInt();
      this.oyI = paramParcel.readString();
      this.oyJ = paramParcel.readString();
      this.oyJ = paramParcel.readString();
      this.oyK = paramParcel.readString();
      this.oyL = paramParcel.readString();
      this.oyM = paramParcel.readString();
      this.oyN = paramParcel.readString();
      this.oyO = paramParcel.readInt();
      this.oyP = paramParcel.readString();
      this.oyQ = paramParcel.readString();
      this.oyR = paramParcel.readString();
      this.oyS = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(aq paramaq)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.drf = paramaq.Frz;
    localCardGiftInfo.dFE = paramaq.FrA;
    localCardGiftInfo.oyc = paramaq.FrB;
    localCardGiftInfo.oyd = paramaq.content;
    localCardGiftInfo.oye = paramaq.FrC;
    localCardGiftInfo.oyf = paramaq.FrD;
    localCardGiftInfo.oyg = paramaq.FrE;
    localCardGiftInfo.oyh = paramaq.FrF;
    localCardGiftInfo.oyj = paramaq.FrH;
    localCardGiftInfo.oyi = paramaq.FrG;
    localCardGiftInfo.oyk = paramaq.FrI;
    localCardGiftInfo.oyl = paramaq.FrJ;
    localCardGiftInfo.oym = paramaq.oyT;
    localCardGiftInfo.oyn = paramaq.oyU;
    localCardGiftInfo.footerWording = paramaq.FrK;
    localCardGiftInfo.hAD = paramaq.hAD;
    localCardGiftInfo.oyo = paramaq.FrL;
    localCardGiftInfo.oyp = paramaq.FrM;
    localCardGiftInfo.oyq = paramaq.FrN;
    localCardGiftInfo.oyr = paramaq.FrO;
    localCardGiftInfo.oys = paramaq.FrP;
    localCardGiftInfo.oyt = paramaq.FrQ;
    localCardGiftInfo.oyu = paramaq.FrR;
    localCardGiftInfo.oyv = paramaq.FrS;
    localCardGiftInfo.oyw = paramaq.FrT;
    localCardGiftInfo.oyx = paramaq.FrU;
    localCardGiftInfo.oyy = paramaq.FrV;
    localCardGiftInfo.oyz = paramaq.FrW;
    localCardGiftInfo.oyA = paramaq.FrX;
    localCardGiftInfo.oyB = paramaq.FrY;
    localCardGiftInfo.oyC = paramaq.oxM;
    localCardGiftInfo.oyD = paramaq.FrZ;
    Iterator localIterator = paramaq.oyE.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (at)localIterator.next();
      localLinkedList = localCardGiftInfo.oyE;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).oyU = ((at)localObject1).oyU;
      ((AcceptedCardItem)localObject2).oyT = ((at)localObject1).oyT;
      localLinkedList.add(localObject2);
    }
    localIterator = paramaq.oyF.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (au)localIterator.next();
      localLinkedList = localCardGiftInfo.oyF;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).oyU = ((au)localObject1).oyU;
      ((AccepterItem)localObject2).oyT = ((au)localObject1).oyT;
      ((AccepterItem)localObject2).oyW = ((au)localObject1).oyW;
      ((AccepterItem)localObject2).oyV = ((au)localObject1).oyV;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.oyG = paramaq.oyG;
    localCardGiftInfo.oyH = paramaq.oyH;
    localCardGiftInfo.oyI = paramaq.oyI;
    localCardGiftInfo.oyJ = paramaq.oyJ;
    localCardGiftInfo.oyK = paramaq.oyK;
    localCardGiftInfo.oyL = paramaq.oyL;
    localCardGiftInfo.oyM = paramaq.oyM;
    localCardGiftInfo.oyN = paramaq.oyN;
    localCardGiftInfo.oyO = paramaq.oyO;
    localCardGiftInfo.oyP = paramaq.oyP;
    localCardGiftInfo.oyR = paramaq.oyR;
    localCardGiftInfo.oyQ = paramaq.oyQ;
    localCardGiftInfo.oyS = paramaq.oyS;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(ayi paramayi)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.drf = paramayi.Frz;
    localCardGiftInfo.dFE = paramayi.FrA;
    localCardGiftInfo.oyc = paramayi.FrB;
    localCardGiftInfo.oyd = paramayi.content;
    localCardGiftInfo.oye = paramayi.FrC;
    localCardGiftInfo.oyf = paramayi.FrD;
    localCardGiftInfo.oyg = paramayi.FrE;
    localCardGiftInfo.oyh = paramayi.FrF;
    localCardGiftInfo.oyj = paramayi.FrH;
    localCardGiftInfo.oyi = paramayi.FrG;
    localCardGiftInfo.oyk = paramayi.FrI;
    localCardGiftInfo.oyl = paramayi.FrJ;
    localCardGiftInfo.oym = paramayi.oyT;
    localCardGiftInfo.oyn = paramayi.oyU;
    localCardGiftInfo.footerWording = paramayi.FrK;
    localCardGiftInfo.hAD = paramayi.hAD;
    localCardGiftInfo.oyo = paramayi.FrL;
    localCardGiftInfo.oyp = paramayi.FrM;
    localCardGiftInfo.oyq = paramayi.FrN;
    localCardGiftInfo.oyr = paramayi.FrO;
    localCardGiftInfo.oys = paramayi.FrP;
    localCardGiftInfo.oyt = paramayi.FrQ;
    localCardGiftInfo.oyu = paramayi.GvT;
    localCardGiftInfo.oyv = paramayi.FrS;
    localCardGiftInfo.oyw = paramayi.FrT;
    localCardGiftInfo.oyx = paramayi.FrU;
    localCardGiftInfo.oyy = paramayi.FrV;
    localCardGiftInfo.oyz = paramayi.FrW;
    localCardGiftInfo.oyA = paramayi.FrX;
    localCardGiftInfo.oyB = paramayi.FrY;
    localCardGiftInfo.oyC = paramayi.oxM;
    localCardGiftInfo.oyD = paramayi.FrZ;
    localCardGiftInfo.oyI = paramayi.oyI;
    localCardGiftInfo.oyJ = paramayi.oyJ;
    localCardGiftInfo.oyK = paramayi.oyK;
    localCardGiftInfo.oyL = paramayi.oyL;
    localCardGiftInfo.oyM = paramayi.oyM;
    localCardGiftInfo.oyN = paramayi.oyN;
    localCardGiftInfo.oyO = paramayi.oyO;
    localCardGiftInfo.oyP = paramayi.oyP;
    localCardGiftInfo.oyR = paramayi.oyR;
    localCardGiftInfo.oyQ = paramayi.oyQ;
    localCardGiftInfo.oyS = paramayi.oyS;
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
    String str = "CardGiftInfo{toUserName='" + this.drf + '\'' + ", fromUserName='" + this.dFE + '\'' + ", fromUserImgUrl='" + this.oyc + '\'' + ", fromUserContent='" + this.oyd + '\'' + ", fromUserContentPicUrl='" + this.oye + '\'' + ", fromUserContentVideoUrl='" + this.oyf + '\'' + ", fromUserContentThumbPicUrl='" + this.oyg + '\'' + ", picAESKey='" + this.oyh + '\'' + ", videoAESKey='" + this.oyi + '\'' + ", thumbVideoAESKey='" + this.oyj + '\'' + ", cardBackgroundPicUrl='" + this.oyk + '\'' + ", cardLogoLUrl='" + this.oyl + '\'' + ", cardTitle='" + this.oym + '\'' + ", cardPrice='" + this.oyn + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.hAD + '\'' + ", needJump=" + this.oyo + ", picDataLength=" + this.oyp + ", videoDataLength=" + this.oyq + ", thumbDataLength=" + this.oyr + ", descTitle='" + this.oys + '\'' + ", descIconUrl='" + this.oyt + '\'' + ", descLayoutMode=" + this.oyu + ", giftingMediaTitle='" + this.oyv + '\'' + ", descriptionTitleColor='" + this.oyw + '\'' + ", cardTitleColor='" + this.oyx + '\'' + ", cardPriceTitleColor='" + this.oyy + '\'' + ", userCardId='" + this.oyz + '\'' + ", operationTitle='" + this.oyA + '\'' + ", operationUrl='" + this.oyB + '\'' + ", cardTpId='" + this.oyC + '\'' + ", cardCode='" + this.oyD + '\'' + ", accepted_card_list_size='" + this.oyE.size() + '\'' + ", accepter_list_size='" + this.oyF.size() + '\'' + ", accepter_list_title='" + this.oyG + '\'' + ", out_of_card='" + this.oyH + '\'' + ", operation_wxa_username='" + this.oyI + '\'' + ", operation_wxa_path='" + this.oyJ + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.drf);
    paramParcel.writeString(this.dFE);
    paramParcel.writeString(this.oyc);
    paramParcel.writeString(this.oyd);
    paramParcel.writeString(this.oye);
    paramParcel.writeString(this.oyf);
    paramParcel.writeString(this.oyg);
    paramParcel.writeString(this.oyh);
    paramParcel.writeString(this.oyi);
    paramParcel.writeString(this.oyj);
    paramParcel.writeString(this.oyk);
    paramParcel.writeString(this.oyl);
    paramParcel.writeString(this.oym);
    paramParcel.writeString(this.oyn);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.hAD);
    if (this.oyo) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.oyp);
      paramParcel.writeInt(this.oyq);
      paramParcel.writeInt(this.oyr);
      paramParcel.writeString(this.oys);
      paramParcel.writeString(this.oyt);
      paramParcel.writeInt(this.oyu);
      paramParcel.writeString(this.oyv);
      paramParcel.writeString(this.oyw);
      paramParcel.writeString(this.oyx);
      paramParcel.writeString(this.oyy);
      paramParcel.writeString(this.oyz);
      paramParcel.writeString(this.oyA);
      paramParcel.writeString(this.oyB);
      paramParcel.writeString(this.oyC);
      paramParcel.writeString(this.oyD);
      paramParcel.writeTypedList(this.oyE);
      paramParcel.writeTypedList(this.oyF);
      paramParcel.writeString(this.oyG);
      paramParcel.writeInt(this.oyH);
      paramParcel.writeString(this.oyI);
      paramParcel.writeString(this.oyJ);
      paramParcel.writeString(this.oyJ);
      paramParcel.writeString(this.oyK);
      paramParcel.writeString(this.oyL);
      paramParcel.writeString(this.oyM);
      paramParcel.writeString(this.oyN);
      paramParcel.writeInt(this.oyO);
      paramParcel.writeString(this.oyP);
      paramParcel.writeString(this.oyQ);
      paramParcel.writeString(this.oyR);
      paramParcel.writeString(this.oyS);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String oyT;
    public String oyU;
    
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
      this.oyT = paramParcel.readString();
      this.oyU = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.oyT);
      paramParcel.writeString(this.oyU);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String oyT;
    public String oyU;
    public String oyV;
    public String oyW;
    
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
      this.oyT = paramParcel.readString();
      this.oyU = paramParcel.readString();
      this.oyV = paramParcel.readString();
      this.oyW = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.oyT);
      paramParcel.writeString(this.oyU);
      paramParcel.writeString(this.oyV);
      paramParcel.writeString(this.oyW);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */