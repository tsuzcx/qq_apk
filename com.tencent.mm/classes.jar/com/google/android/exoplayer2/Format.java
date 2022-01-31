package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
  implements Parcelable
{
  public static final Parcelable.Creator<Format> CREATOR;
  public final String awH;
  public final Metadata awI;
  public final String awJ;
  public final String awK;
  public final int awL;
  public final List<byte[]> awM;
  public final DrmInitData awN;
  public final float awO;
  public final int awP;
  public final float awQ;
  public final int awR;
  public final byte[] awS;
  public final ColorInfo awT;
  public final int awU;
  public final int awV;
  public final int awW;
  public final int awX;
  public final long awY;
  public final int awZ;
  public final String axa;
  public final int axb;
  private int axc;
  public final int bitrate;
  public final int height;
  public final String id;
  public final int sampleRate;
  public final int width;
  
  static
  {
    AppMethodBeat.i(95226);
    CREATOR = new Format.1();
    AppMethodBeat.o(95226);
  }
  
  Format(Parcel paramParcel)
  {
    AppMethodBeat.i(95212);
    this.id = paramParcel.readString();
    this.awJ = paramParcel.readString();
    this.awK = paramParcel.readString();
    this.awH = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.awL = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.awO = paramParcel.readFloat();
    this.awP = paramParcel.readInt();
    this.awQ = paramParcel.readFloat();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0) {
        break label268;
      }
    }
    label268:
    for (byte[] arrayOfByte = paramParcel.createByteArray();; arrayOfByte = null)
    {
      this.awS = arrayOfByte;
      this.awR = paramParcel.readInt();
      this.awT = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
      this.awU = paramParcel.readInt();
      this.sampleRate = paramParcel.readInt();
      this.awV = paramParcel.readInt();
      this.awW = paramParcel.readInt();
      this.awX = paramParcel.readInt();
      this.awZ = paramParcel.readInt();
      this.axa = paramParcel.readString();
      this.axb = paramParcel.readInt();
      this.awY = paramParcel.readLong();
      int j = paramParcel.readInt();
      this.awM = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        this.awM.add(paramParcel.createByteArray());
        i += 1;
      }
      i = 0;
      break;
    }
    this.awN = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.awI = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
    AppMethodBeat.o(95212);
  }
  
  private Format(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    AppMethodBeat.i(95211);
    this.id = paramString1;
    this.awJ = paramString2;
    this.awK = paramString3;
    this.awH = paramString4;
    this.bitrate = paramInt1;
    this.awL = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.awO = paramFloat1;
    this.awP = paramInt5;
    this.awQ = paramFloat2;
    this.awS = paramArrayOfByte;
    this.awR = paramInt6;
    this.awT = paramColorInfo;
    this.awU = paramInt7;
    this.sampleRate = paramInt8;
    this.awV = paramInt9;
    this.awW = paramInt10;
    this.awX = paramInt11;
    this.awZ = paramInt12;
    this.axa = paramString5;
    this.axb = paramInt13;
    this.awY = paramLong;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    }
    this.awM = paramString1;
    this.awN = paramDrmInitData;
    this.awI = paramMetadata;
    AppMethodBeat.o(95211);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt8, String paramString3, Metadata paramMetadata)
  {
    AppMethodBeat.i(95199);
    paramString1 = new Format(paramString1, null, paramString2, null, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString3, -1, 9223372036854775807L, paramList, paramDrmInitData, paramMetadata);
    AppMethodBeat.o(95199);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt6, String paramString3)
  {
    AppMethodBeat.i(95198);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, paramDrmInitData, paramInt6, paramString3, null);
    AppMethodBeat.o(95198);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, DrmInitData paramDrmInitData, String paramString3)
  {
    AppMethodBeat.i(95197);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, paramDrmInitData, 0, paramString3);
    AppMethodBeat.o(95197);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, float paramFloat, byte[] paramArrayOfByte, int paramInt5, ColorInfo paramColorInfo, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(95195);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, paramInt1, paramInt2, paramInt3, -1.0F, paramInt4, paramFloat, paramArrayOfByte, paramInt5, paramColorInfo, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
    AppMethodBeat.o(95195);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<byte[]> paramList, float paramFloat)
  {
    AppMethodBeat.i(95194);
    paramString1 = a(paramString1, paramString2, -1, paramInt1, paramInt2, paramList, -1, paramFloat, null, -1, null, null);
    AppMethodBeat.o(95194);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(95196);
    paramString1 = new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt, paramString3, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(95196);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(95204);
    paramString1 = a(paramString1, paramString2, paramInt1, paramString3, paramInt2, null, 9223372036854775807L, Collections.emptyList());
    AppMethodBeat.o(95204);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, DrmInitData paramDrmInitData, long paramLong, List<byte[]> paramList)
  {
    AppMethodBeat.i(95206);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString3, paramInt2, paramLong, paramList, paramDrmInitData, null);
    AppMethodBeat.o(95206);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt, String paramString3, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(95203);
    paramString1 = a(paramString1, paramString2, paramInt, paramString3, -1, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
    AppMethodBeat.o(95203);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(95205);
    paramString1 = a(null, paramString1, 0, paramString2, -1, null, paramLong, Collections.emptyList());
    AppMethodBeat.o(95205);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95193);
    paramString1 = new Format(paramString1, paramString2, null, paramString3, paramInt1, -1, paramInt2, paramInt3, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(95193);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(95200);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, paramString4, -1);
    AppMethodBeat.o(95200);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(95201);
    paramString1 = new Format(paramString1, paramString2, paramString3, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString4, paramInt2, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(95201);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, List<byte[]> paramList, String paramString3, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(95207);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, paramString3, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
    AppMethodBeat.o(95207);
    return paramString1;
  }
  
  public static String a(Format paramFormat)
  {
    AppMethodBeat.i(95224);
    if (paramFormat == null)
    {
      AppMethodBeat.o(95224);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(paramFormat.id).append(", mimeType=").append(paramFormat.awK);
    if (paramFormat.bitrate != -1) {
      localStringBuilder.append(", bitrate=").append(paramFormat.bitrate);
    }
    if ((paramFormat.width != -1) && (paramFormat.height != -1)) {
      localStringBuilder.append(", res=").append(paramFormat.width).append("x").append(paramFormat.height);
    }
    if (paramFormat.awO != -1.0F) {
      localStringBuilder.append(", fps=").append(paramFormat.awO);
    }
    if (paramFormat.awU != -1) {
      localStringBuilder.append(", channels=").append(paramFormat.awU);
    }
    if (paramFormat.sampleRate != -1) {
      localStringBuilder.append(", sample_rate=").append(paramFormat.sampleRate);
    }
    if (paramFormat.axa != null) {
      localStringBuilder.append(", language=").append(paramFormat.axa);
    }
    paramFormat = localStringBuilder.toString();
    AppMethodBeat.o(95224);
    return paramFormat;
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(95223);
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(95223);
  }
  
  public static Format al(String paramString)
  {
    AppMethodBeat.i(95202);
    paramString = a(null, paramString, 0, null, null);
    AppMethodBeat.o(95202);
    return paramString;
  }
  
  public static Format c(String paramString, long paramLong)
  {
    AppMethodBeat.i(95209);
    paramString = new Format(null, null, paramString, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
    AppMethodBeat.o(95209);
    return paramString;
  }
  
  public static Format j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95208);
    paramString1 = new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(95208);
    return paramString1;
  }
  
  public static Format k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95210);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(95210);
    return paramString1;
  }
  
  public final Format a(DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(95217);
    paramDrmInitData = new Format(this.id, this.awJ, this.awK, this.awH, this.bitrate, this.awL, this.width, this.height, this.awO, this.awP, this.awQ, this.awS, this.awR, this.awT, this.awU, this.sampleRate, this.awV, this.awW, this.awX, this.awZ, this.axa, this.axb, this.awY, this.awM, paramDrmInitData, this.awI);
    AppMethodBeat.o(95217);
    return paramDrmInitData;
  }
  
  public final Format a(Metadata paramMetadata)
  {
    AppMethodBeat.i(95218);
    paramMetadata = new Format(this.id, this.awJ, this.awK, this.awH, this.bitrate, this.awL, this.width, this.height, this.awO, this.awP, this.awQ, this.awS, this.awR, this.awT, this.awU, this.sampleRate, this.awV, this.awW, this.awX, this.awZ, this.axa, this.axb, this.awY, this.awM, this.awN, paramMetadata);
    AppMethodBeat.o(95218);
    return paramMetadata;
  }
  
  public final Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(95215);
    paramString1 = new Format(paramString1, this.awJ, this.awK, paramString2, paramInt1, this.awL, paramInt2, paramInt3, this.awO, this.awP, this.awQ, this.awS, this.awR, this.awT, this.awU, this.sampleRate, this.awV, this.awW, this.awX, paramInt4, paramString3, this.axb, this.awY, this.awM, this.awN, this.awI);
    AppMethodBeat.o(95215);
    return paramString1;
  }
  
  public final Format aR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95216);
    Format localFormat = new Format(this.id, this.awJ, this.awK, this.awH, this.bitrate, this.awL, this.width, this.height, this.awO, this.awP, this.awQ, this.awS, this.awR, this.awT, this.awU, this.sampleRate, this.awV, paramInt1, paramInt2, this.awZ, this.axa, this.axb, this.awY, this.awM, this.awN, this.awI);
    AppMethodBeat.o(95216);
    return localFormat;
  }
  
  public final Format cW(int paramInt)
  {
    AppMethodBeat.i(95213);
    Format localFormat = new Format(this.id, this.awJ, this.awK, this.awH, this.bitrate, paramInt, this.width, this.height, this.awO, this.awP, this.awQ, this.awS, this.awR, this.awT, this.awU, this.sampleRate, this.awV, this.awW, this.awX, this.awZ, this.axa, this.axb, this.awY, this.awM, this.awN, this.awI);
    AppMethodBeat.o(95213);
    return localFormat;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95222);
    if (this == paramObject)
    {
      AppMethodBeat.o(95222);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95222);
      return false;
    }
    paramObject = (Format)paramObject;
    if ((this.bitrate != paramObject.bitrate) || (this.awL != paramObject.awL) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.awO != paramObject.awO) || (this.awP != paramObject.awP) || (this.awQ != paramObject.awQ) || (this.awR != paramObject.awR) || (this.awU != paramObject.awU) || (this.sampleRate != paramObject.sampleRate) || (this.awV != paramObject.awV) || (this.awW != paramObject.awW) || (this.awX != paramObject.awX) || (this.awY != paramObject.awY) || (this.awZ != paramObject.awZ) || (!x.e(this.id, paramObject.id)) || (!x.e(this.axa, paramObject.axa)) || (this.axb != paramObject.axb) || (!x.e(this.awJ, paramObject.awJ)) || (!x.e(this.awK, paramObject.awK)) || (!x.e(this.awH, paramObject.awH)) || (!x.e(this.awN, paramObject.awN)) || (!x.e(this.awI, paramObject.awI)) || (!x.e(this.awT, paramObject.awT)) || (!Arrays.equals(this.awS, paramObject.awS)) || (this.awM.size() != paramObject.awM.size()))
    {
      AppMethodBeat.o(95222);
      return false;
    }
    int i = 0;
    while (i < this.awM.size())
    {
      if (!Arrays.equals((byte[])this.awM.get(i), (byte[])paramObject.awM.get(i)))
      {
        AppMethodBeat.o(95222);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(95222);
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(95221);
    int i;
    int j;
    label34:
    int k;
    label43:
    int m;
    label53:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int n;
    label93:
    int i8;
    int i1;
    if (this.axc == 0)
    {
      if (this.id != null) {
        break label208;
      }
      i = 0;
      if (this.awJ != null) {
        break label219;
      }
      j = 0;
      if (this.awK != null) {
        break label230;
      }
      k = 0;
      if (this.awH != null) {
        break label241;
      }
      m = 0;
      i3 = this.bitrate;
      i4 = this.width;
      i5 = this.height;
      i6 = this.awU;
      i7 = this.sampleRate;
      if (this.axa != null) {
        break label253;
      }
      n = 0;
      i8 = this.axb;
      if (this.awN != null) {
        break label265;
      }
      i1 = 0;
      label109:
      if (this.awI != null) {
        break label277;
      }
    }
    for (;;)
    {
      this.axc = ((i1 + ((n + ((((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31) * 31 + i2);
      i = this.axc;
      AppMethodBeat.o(95221);
      return i;
      label208:
      i = this.id.hashCode();
      break;
      label219:
      j = this.awJ.hashCode();
      break label34;
      label230:
      k = this.awK.hashCode();
      break label43;
      label241:
      m = this.awH.hashCode();
      break label53;
      label253:
      n = this.axa.hashCode();
      break label93;
      label265:
      i1 = this.awN.hashCode();
      break label109;
      label277:
      i2 = this.awI.hashCode();
    }
  }
  
  public final int mX()
  {
    if ((this.width == -1) || (this.height == -1)) {
      return -1;
    }
    return this.width * this.height;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat mY()
  {
    AppMethodBeat.i(95219);
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.awK);
    Object localObject = this.axa;
    if (localObject != null) {
      localMediaFormat.setString("language", (String)localObject);
    }
    a(localMediaFormat, "max-input-size", this.awL);
    a(localMediaFormat, "width", this.width);
    a(localMediaFormat, "height", this.height);
    float f = this.awO;
    if (f != -1.0F) {
      localMediaFormat.setFloat("frame-rate", f);
    }
    a(localMediaFormat, "rotation-degrees", this.awP);
    a(localMediaFormat, "channel-count", this.awU);
    a(localMediaFormat, "sample-rate", this.sampleRate);
    a(localMediaFormat, "encoder-delay", this.awW);
    a(localMediaFormat, "encoder-padding", this.awX);
    int i = 0;
    while (i < this.awM.size())
    {
      localMediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), ByteBuffer.wrap((byte[])this.awM.get(i)));
      i += 1;
    }
    localObject = this.awT;
    if (localObject != null)
    {
      a(localMediaFormat, "color-transfer", ((ColorInfo)localObject).aDD);
      a(localMediaFormat, "color-standard", ((ColorInfo)localObject).aDC);
      a(localMediaFormat, "color-range", ((ColorInfo)localObject).aDE);
      localObject = ((ColorInfo)localObject).bbz;
      if (localObject != null) {
        localMediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap((byte[])localObject));
      }
    }
    AppMethodBeat.o(95219);
    return localMediaFormat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(95220);
    String str = "Format(" + this.id + ", " + this.awJ + ", " + this.awK + ", " + this.bitrate + ", " + this.axa + ", [" + this.width + ", " + this.height + ", " + this.awO + "], [" + this.awU + ", " + this.sampleRate + "])";
    AppMethodBeat.o(95220);
    return str;
  }
  
  public final Format w(long paramLong)
  {
    AppMethodBeat.i(95214);
    Format localFormat = new Format(this.id, this.awJ, this.awK, this.awH, this.bitrate, this.awL, this.width, this.height, this.awO, this.awP, this.awQ, this.awS, this.awR, this.awT, this.awU, this.sampleRate, this.awV, this.awW, this.awX, this.awZ, this.axa, this.axb, paramLong, this.awM, this.awN, this.awI);
    AppMethodBeat.o(95214);
    return localFormat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95225);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.awJ);
    paramParcel.writeString(this.awK);
    paramParcel.writeString(this.awH);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.awL);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.awO);
    paramParcel.writeInt(this.awP);
    paramParcel.writeFloat(this.awQ);
    if (this.awS != null) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.awS != null) {
        paramParcel.writeByteArray(this.awS);
      }
      paramParcel.writeInt(this.awR);
      paramParcel.writeParcelable(this.awT, paramInt);
      paramParcel.writeInt(this.awU);
      paramParcel.writeInt(this.sampleRate);
      paramParcel.writeInt(this.awV);
      paramParcel.writeInt(this.awW);
      paramParcel.writeInt(this.awX);
      paramParcel.writeInt(this.awZ);
      paramParcel.writeString(this.axa);
      paramParcel.writeInt(this.axb);
      paramParcel.writeLong(this.awY);
      i = this.awM.size();
      paramParcel.writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeByteArray((byte[])this.awM.get(paramInt));
        paramInt += 1;
      }
    }
    paramParcel.writeParcelable(this.awN, 0);
    paramParcel.writeParcelable(this.awI, 0);
    AppMethodBeat.o(95225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.7.0.1
 */