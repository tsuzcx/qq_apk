package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
  implements Parcelable
{
  public static final Parcelable.Creator<Format> CREATOR = new Format.1();
  public final byte[] auA;
  public final ColorInfo auB;
  public final int auC;
  public final int auD;
  public final int auE;
  public final int auF;
  public final long auG;
  public final int auH;
  public final String auI;
  public final int auJ;
  private int auK;
  public final String aup;
  public final Metadata auq;
  public final String aur;
  public final String aus;
  public final int aut;
  public final List<byte[]> auu;
  public final DrmInitData auv;
  public final float auw;
  public final int aux;
  public final float auy;
  public final int auz;
  public final int bitrate;
  public final int height;
  public final String id;
  public final int sampleRate;
  public final int width;
  
  Format(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.aur = paramParcel.readString();
    this.aus = paramParcel.readString();
    this.aup = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.aut = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.auw = paramParcel.readFloat();
    this.aux = paramParcel.readInt();
    this.auy = paramParcel.readFloat();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0) {
        break label263;
      }
    }
    label263:
    for (byte[] arrayOfByte = paramParcel.createByteArray();; arrayOfByte = null)
    {
      this.auA = arrayOfByte;
      this.auz = paramParcel.readInt();
      this.auB = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
      this.auC = paramParcel.readInt();
      this.sampleRate = paramParcel.readInt();
      this.auD = paramParcel.readInt();
      this.auE = paramParcel.readInt();
      this.auF = paramParcel.readInt();
      this.auH = paramParcel.readInt();
      this.auI = paramParcel.readString();
      this.auJ = paramParcel.readInt();
      this.auG = paramParcel.readLong();
      int j = paramParcel.readInt();
      this.auu = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        this.auu.add(paramParcel.createByteArray());
        i += 1;
      }
      i = 0;
      break;
    }
    this.auv = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.auq = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
  }
  
  public Format(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    this.id = paramString1;
    this.aur = paramString2;
    this.aus = paramString3;
    this.aup = paramString4;
    this.bitrate = paramInt1;
    this.aut = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.auw = paramFloat1;
    this.aux = paramInt5;
    this.auy = paramFloat2;
    this.auA = paramArrayOfByte;
    this.auz = paramInt6;
    this.auB = paramColorInfo;
    this.auC = paramInt7;
    this.sampleRate = paramInt8;
    this.auD = paramInt9;
    this.auE = paramInt10;
    this.auF = paramInt11;
    this.auH = paramInt12;
    this.auI = paramString5;
    this.auJ = paramInt13;
    this.auG = paramLong;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    }
    this.auu = paramString1;
    this.auv = paramDrmInitData;
    this.auq = paramMetadata;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, DrmInitData paramDrmInitData, String paramString3, Metadata paramMetadata)
  {
    return new Format(paramString1, null, paramString2, null, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, 0, paramString3, -1, 9223372036854775807L, paramList, paramDrmInitData, paramMetadata);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, DrmInitData paramDrmInitData, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, paramDrmInitData, paramString3, null);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, DrmInitData paramDrmInitData, String paramString3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, paramDrmInitData, paramString3);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<byte[]> paramList, float paramFloat)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, paramList, -1, paramFloat, null, -1, null);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<byte[]> paramList, int paramInt3, float paramFloat, byte[] paramArrayOfByte, int paramInt4, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, paramString2, null, -1, -1, paramInt1, paramInt2, -1.0F, paramInt3, paramFloat, paramArrayOfByte, paramInt4, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    return a(paramString1, paramString2, paramInt1, paramString3, paramInt2, 9223372036854775807L, Collections.emptyList());
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, long paramLong, List<byte[]> paramList)
  {
    return new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString3, paramInt2, paramLong, paramList, null, null);
  }
  
  public static Format a(String paramString1, String paramString2, long paramLong)
  {
    return a(null, paramString1, 0, paramString2, -1, paramLong, Collections.emptyList());
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    return new Format(paramString1, paramString2, null, paramString3, paramInt1, -1, paramInt2, paramInt3, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramInt, paramString4, -1);
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    return new Format(paramString1, paramString2, paramString3, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString4, paramInt2, 9223372036854775807L, null, null, null);
  }
  
  public static Format a(String paramString1, String paramString2, List<byte[]> paramList, String paramString3)
  {
    return new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, paramString3, -1, 9223372036854775807L, paramList, null, null);
  }
  
  public static String a(Format paramFormat)
  {
    if (paramFormat == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(paramFormat.id).append(", mimeType=").append(paramFormat.aus);
    if (paramFormat.bitrate != -1) {
      localStringBuilder.append(", bitrate=").append(paramFormat.bitrate);
    }
    if ((paramFormat.width != -1) && (paramFormat.height != -1)) {
      localStringBuilder.append(", res=").append(paramFormat.width).append("x").append(paramFormat.height);
    }
    if (paramFormat.auw != -1.0F) {
      localStringBuilder.append(", fps=").append(paramFormat.auw);
    }
    if (paramFormat.auC != -1) {
      localStringBuilder.append(", channels=").append(paramFormat.auC);
    }
    if (paramFormat.sampleRate != -1) {
      localStringBuilder.append(", sample_rate=").append(paramFormat.sampleRate);
    }
    if (paramFormat.auI != null) {
      localStringBuilder.append(", language=").append(paramFormat.auI);
    }
    return localStringBuilder.toString();
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  public static Format ah(String paramString)
  {
    return a(null, paramString, 0, null, -1, 9223372036854775807L, Collections.emptyList());
  }
  
  public static Format b(String paramString, long paramLong)
  {
    return new Format(null, null, paramString, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
  }
  
  public static Format b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt, paramString3, -1, 9223372036854775807L, null, null, null);
  }
  
  public static Format h(String paramString1, String paramString2)
  {
    return new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
  }
  
  public static Format j(String paramString1, String paramString2)
  {
    return new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    do
                                                    {
                                                      do
                                                      {
                                                        do
                                                        {
                                                          do
                                                          {
                                                            return bool1;
                                                            bool1 = bool2;
                                                          } while (paramObject == null);
                                                          bool1 = bool2;
                                                        } while (getClass() != paramObject.getClass());
                                                        paramObject = (Format)paramObject;
                                                        bool1 = bool2;
                                                      } while (this.bitrate != paramObject.bitrate);
                                                      bool1 = bool2;
                                                    } while (this.aut != paramObject.aut);
                                                    bool1 = bool2;
                                                  } while (this.width != paramObject.width);
                                                  bool1 = bool2;
                                                } while (this.height != paramObject.height);
                                                bool1 = bool2;
                                              } while (this.auw != paramObject.auw);
                                              bool1 = bool2;
                                            } while (this.aux != paramObject.aux);
                                            bool1 = bool2;
                                          } while (this.auy != paramObject.auy);
                                          bool1 = bool2;
                                        } while (this.auz != paramObject.auz);
                                        bool1 = bool2;
                                      } while (this.auC != paramObject.auC);
                                      bool1 = bool2;
                                    } while (this.sampleRate != paramObject.sampleRate);
                                    bool1 = bool2;
                                  } while (this.auD != paramObject.auD);
                                  bool1 = bool2;
                                } while (this.auE != paramObject.auE);
                                bool1 = bool2;
                              } while (this.auF != paramObject.auF);
                              bool1 = bool2;
                            } while (this.auG != paramObject.auG);
                            bool1 = bool2;
                          } while (this.auH != paramObject.auH);
                          bool1 = bool2;
                        } while (!t.e(this.id, paramObject.id));
                        bool1 = bool2;
                      } while (!t.e(this.auI, paramObject.auI));
                      bool1 = bool2;
                    } while (this.auJ != paramObject.auJ);
                    bool1 = bool2;
                  } while (!t.e(this.aur, paramObject.aur));
                  bool1 = bool2;
                } while (!t.e(this.aus, paramObject.aus));
                bool1 = bool2;
              } while (!t.e(this.aup, paramObject.aup));
              bool1 = bool2;
            } while (!t.e(this.auv, paramObject.auv));
            bool1 = bool2;
          } while (!t.e(this.auq, paramObject.auq));
          bool1 = bool2;
        } while (!t.e(this.auB, paramObject.auB));
        bool1 = bool2;
      } while (!Arrays.equals(this.auA, paramObject.auA));
      bool1 = bool2;
    } while (this.auu.size() != paramObject.auu.size());
    int i = 0;
    for (;;)
    {
      if (i >= this.auu.size()) {
        break label499;
      }
      bool1 = bool2;
      if (!Arrays.equals((byte[])this.auu.get(i), (byte[])paramObject.auu.get(i))) {
        break;
      }
      i += 1;
    }
    label499:
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    int i;
    int j;
    label28:
    int k;
    label37:
    int m;
    label47:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int n;
    label87:
    int i8;
    int i1;
    if (this.auK == 0)
    {
      if (this.id != null) {
        break label194;
      }
      i = 0;
      if (this.aur != null) {
        break label205;
      }
      j = 0;
      if (this.aus != null) {
        break label216;
      }
      k = 0;
      if (this.aup != null) {
        break label227;
      }
      m = 0;
      i3 = this.bitrate;
      i4 = this.width;
      i5 = this.height;
      i6 = this.auC;
      i7 = this.sampleRate;
      if (this.auI != null) {
        break label239;
      }
      n = 0;
      i8 = this.auJ;
      if (this.auv != null) {
        break label251;
      }
      i1 = 0;
      label103:
      if (this.auq != null) {
        break label263;
      }
    }
    for (;;)
    {
      this.auK = ((i1 + ((n + ((((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31) * 31 + i2);
      return this.auK;
      label194:
      i = this.id.hashCode();
      break;
      label205:
      j = this.aur.hashCode();
      break label28;
      label216:
      k = this.aus.hashCode();
      break label37;
      label227:
      m = this.aup.hashCode();
      break label47;
      label239:
      n = this.auI.hashCode();
      break label87;
      label251:
      i1 = this.auv.hashCode();
      break label103;
      label263:
      i2 = this.auq.hashCode();
    }
  }
  
  public final int kQ()
  {
    if ((this.width == -1) || (this.height == -1)) {
      return -1;
    }
    return this.width * this.height;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat kR()
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.aus);
    Object localObject = this.auI;
    if (localObject != null) {
      localMediaFormat.setString("language", (String)localObject);
    }
    a(localMediaFormat, "max-input-size", this.aut);
    a(localMediaFormat, "width", this.width);
    a(localMediaFormat, "height", this.height);
    float f = this.auw;
    if (f != -1.0F) {
      localMediaFormat.setFloat("frame-rate", f);
    }
    a(localMediaFormat, "rotation-degrees", this.aux);
    a(localMediaFormat, "channel-count", this.auC);
    a(localMediaFormat, "sample-rate", this.sampleRate);
    a(localMediaFormat, "encoder-delay", this.auE);
    a(localMediaFormat, "encoder-padding", this.auF);
    int i = 0;
    while (i < this.auu.size())
    {
      localMediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[])this.auu.get(i)));
      i += 1;
    }
    localObject = this.auB;
    if (localObject != null)
    {
      a(localMediaFormat, "color-transfer", ((ColorInfo)localObject).aTa);
      a(localMediaFormat, "color-standard", ((ColorInfo)localObject).aSY);
      a(localMediaFormat, "color-range", ((ColorInfo)localObject).aSZ);
      localObject = ((ColorInfo)localObject).aTb;
      if (localObject != null) {
        localMediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap((byte[])localObject));
      }
    }
    return localMediaFormat;
  }
  
  public final String toString()
  {
    return "Format(" + this.id + ", " + this.aur + ", " + this.aus + ", " + this.bitrate + ", " + this.auI + ", [" + this.width + ", " + this.height + ", " + this.auw + "], [" + this.auC + ", " + this.sampleRate + "])";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.aur);
    paramParcel.writeString(this.aus);
    paramParcel.writeString(this.aup);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.aut);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.auw);
    paramParcel.writeInt(this.aux);
    paramParcel.writeFloat(this.auy);
    if (this.auA != null) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.auA != null) {
        paramParcel.writeByteArray(this.auA);
      }
      paramParcel.writeInt(this.auz);
      paramParcel.writeParcelable(this.auB, paramInt);
      paramParcel.writeInt(this.auC);
      paramParcel.writeInt(this.sampleRate);
      paramParcel.writeInt(this.auD);
      paramParcel.writeInt(this.auE);
      paramParcel.writeInt(this.auF);
      paramParcel.writeInt(this.auH);
      paramParcel.writeString(this.auI);
      paramParcel.writeInt(this.auJ);
      paramParcel.writeLong(this.auG);
      i = this.auu.size();
      paramParcel.writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeByteArray((byte[])this.auu.get(paramInt));
        paramInt += 1;
      }
    }
    paramParcel.writeParcelable(this.auv, 0);
    paramParcel.writeParcelable(this.auq, 0);
  }
  
  public final Format x(long paramLong)
  {
    return new Format(this.id, this.aur, this.aus, this.aup, this.bitrate, this.aut, this.width, this.height, this.auw, this.aux, this.auy, this.auA, this.auz, this.auB, this.auC, this.sampleRate, this.auD, this.auE, this.auF, this.auH, this.auI, this.auJ, paramLong, this.auu, this.auv, this.auq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.7.0.1
 */