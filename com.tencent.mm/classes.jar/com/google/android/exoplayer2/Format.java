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
  public final String aMN;
  public final Metadata aMO;
  public final String aMP;
  public final String aMQ;
  public final int aMR;
  public final List<byte[]> aMS;
  public final DrmInitData aMT;
  public final float aMU;
  public final int aMV;
  public final float aMW;
  public final int aMX;
  public final byte[] aMY;
  public final ColorInfo aMZ;
  public final int aNa;
  public final int aNb;
  public final long aNc;
  public final int aNd;
  public final int aNe;
  private int aNf;
  public final int bitrate;
  public final int channelCount;
  public final int height;
  public final String id;
  public final String language;
  public final int pcmEncoding;
  public final int sampleRate;
  public final int width;
  
  static
  {
    AppMethodBeat.i(92348);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92348);
  }
  
  Format(Parcel paramParcel)
  {
    AppMethodBeat.i(92334);
    this.id = paramParcel.readString();
    this.aMP = paramParcel.readString();
    this.aMQ = paramParcel.readString();
    this.aMN = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.aMR = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.aMU = paramParcel.readFloat();
    this.aMV = paramParcel.readInt();
    this.aMW = paramParcel.readFloat();
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
      this.aMY = arrayOfByte;
      this.aMX = paramParcel.readInt();
      this.aMZ = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
      this.channelCount = paramParcel.readInt();
      this.sampleRate = paramParcel.readInt();
      this.pcmEncoding = paramParcel.readInt();
      this.aNa = paramParcel.readInt();
      this.aNb = paramParcel.readInt();
      this.aNd = paramParcel.readInt();
      this.language = paramParcel.readString();
      this.aNe = paramParcel.readInt();
      this.aNc = paramParcel.readLong();
      int j = paramParcel.readInt();
      this.aMS = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        this.aMS.add(paramParcel.createByteArray());
        i += 1;
      }
      i = 0;
      break;
    }
    this.aMT = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.aMO = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
    AppMethodBeat.o(92334);
  }
  
  private Format(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    AppMethodBeat.i(92333);
    this.id = paramString1;
    this.aMP = paramString2;
    this.aMQ = paramString3;
    this.aMN = paramString4;
    this.bitrate = paramInt1;
    this.aMR = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.aMU = paramFloat1;
    this.aMV = paramInt5;
    this.aMW = paramFloat2;
    this.aMY = paramArrayOfByte;
    this.aMX = paramInt6;
    this.aMZ = paramColorInfo;
    this.channelCount = paramInt7;
    this.sampleRate = paramInt8;
    this.pcmEncoding = paramInt9;
    this.aNa = paramInt10;
    this.aNb = paramInt11;
    this.aNd = paramInt12;
    this.language = paramString5;
    this.aNe = paramInt13;
    this.aNc = paramLong;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    }
    this.aMS = paramString1;
    this.aMT = paramDrmInitData;
    this.aMO = paramMetadata;
    AppMethodBeat.o(92333);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt6, String paramString3)
  {
    AppMethodBeat.i(92320);
    paramString1 = a(paramString1, paramString2, null, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, paramDrmInitData, paramInt6, paramString3, null);
    AppMethodBeat.o(92320);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, DrmInitData paramDrmInitData, String paramString3)
  {
    AppMethodBeat.i(92319);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, paramDrmInitData, 0, paramString3);
    AppMethodBeat.o(92319);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, float paramFloat, byte[] paramArrayOfByte, int paramInt5, ColorInfo paramColorInfo, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92317);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, paramInt1, paramInt2, paramInt3, -1.0F, paramInt4, paramFloat, paramArrayOfByte, paramInt5, paramColorInfo, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
    AppMethodBeat.o(92317);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<byte[]> paramList, float paramFloat)
  {
    AppMethodBeat.i(92316);
    paramString1 = a(paramString1, paramString2, -1, paramInt1, paramInt2, paramList, -1, paramFloat, null, -1, null, null);
    AppMethodBeat.o(92316);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(195249);
    paramString1 = new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt, paramString3, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(195249);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(92326);
    paramString1 = a(paramString1, paramString2, paramInt1, paramString3, paramInt2, null, 9223372036854775807L, Collections.emptyList());
    AppMethodBeat.o(92326);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, DrmInitData paramDrmInitData, long paramLong, List<byte[]> paramList)
  {
    AppMethodBeat.i(92328);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString3, paramInt2, paramLong, paramList, paramDrmInitData, null);
    AppMethodBeat.o(92328);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt, String paramString3, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92325);
    paramString1 = a(paramString1, paramString2, paramInt, paramString3, -1, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
    AppMethodBeat.o(92325);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(92327);
    paramString1 = a(null, paramString1, 0, paramString2, -1, null, paramLong, Collections.emptyList());
    AppMethodBeat.o(92327);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195245);
    paramString1 = new Format(paramString1, paramString2, null, paramString3, paramInt1, -1, paramInt2, paramInt3, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(195245);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt8, String paramString4, Metadata paramMetadata)
  {
    AppMethodBeat.i(195257);
    paramString1 = new Format(paramString1, null, paramString2, null, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString4, -1, 9223372036854775807L, paramList, paramDrmInitData, paramMetadata);
    AppMethodBeat.o(195257);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(195259);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, paramString4, -1);
    AppMethodBeat.o(195259);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(195261);
    paramString1 = new Format(paramString1, paramString2, paramString3, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString4, paramInt2, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(195261);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, List<byte[]> paramList, String paramString3, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92329);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, paramString3, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
    AppMethodBeat.o(92329);
    return paramString1;
  }
  
  public static String a(Format paramFormat)
  {
    AppMethodBeat.i(92346);
    if (paramFormat == null)
    {
      AppMethodBeat.o(92346);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(paramFormat.id).append(", mimeType=").append(paramFormat.aMQ);
    if (paramFormat.bitrate != -1) {
      localStringBuilder.append(", bitrate=").append(paramFormat.bitrate);
    }
    if ((paramFormat.width != -1) && (paramFormat.height != -1)) {
      localStringBuilder.append(", res=").append(paramFormat.width).append("x").append(paramFormat.height);
    }
    if (paramFormat.aMU != -1.0F) {
      localStringBuilder.append(", fps=").append(paramFormat.aMU);
    }
    if (paramFormat.channelCount != -1) {
      localStringBuilder.append(", channels=").append(paramFormat.channelCount);
    }
    if (paramFormat.sampleRate != -1) {
      localStringBuilder.append(", sample_rate=").append(paramFormat.sampleRate);
    }
    if (paramFormat.language != null) {
      localStringBuilder.append(", language=").append(paramFormat.language);
    }
    paramFormat = localStringBuilder.toString();
    AppMethodBeat.o(92346);
    return paramFormat;
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(92345);
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(92345);
  }
  
  public static Format bn(String paramString)
  {
    AppMethodBeat.i(195265);
    paramString = a(null, paramString, 0, null, null);
    AppMethodBeat.o(195265);
    return paramString;
  }
  
  public static Format d(String paramString, long paramLong)
  {
    AppMethodBeat.i(92331);
    paramString = new Format(null, null, paramString, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
    AppMethodBeat.o(92331);
    return paramString;
  }
  
  public static Format k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195277);
    paramString1 = new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(195277);
    return paramString1;
  }
  
  public static Format l(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92332);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(92332);
    return paramString1;
  }
  
  public final Format G(long paramLong)
  {
    AppMethodBeat.i(92336);
    Format localFormat = new Format(this.id, this.aMP, this.aMQ, this.aMN, this.bitrate, this.aMR, this.width, this.height, this.aMU, this.aMV, this.aMW, this.aMY, this.aMX, this.aMZ, this.channelCount, this.sampleRate, this.pcmEncoding, this.aNa, this.aNb, this.aNd, this.language, this.aNe, paramLong, this.aMS, this.aMT, this.aMO);
    AppMethodBeat.o(92336);
    return localFormat;
  }
  
  public final Format a(DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92339);
    paramDrmInitData = new Format(this.id, this.aMP, this.aMQ, this.aMN, this.bitrate, this.aMR, this.width, this.height, this.aMU, this.aMV, this.aMW, this.aMY, this.aMX, this.aMZ, this.channelCount, this.sampleRate, this.pcmEncoding, this.aNa, this.aNb, this.aNd, this.language, this.aNe, this.aNc, this.aMS, paramDrmInitData, this.aMO);
    AppMethodBeat.o(92339);
    return paramDrmInitData;
  }
  
  public final Format a(Metadata paramMetadata)
  {
    AppMethodBeat.i(92340);
    paramMetadata = new Format(this.id, this.aMP, this.aMQ, this.aMN, this.bitrate, this.aMR, this.width, this.height, this.aMU, this.aMV, this.aMW, this.aMY, this.aMX, this.aMZ, this.channelCount, this.sampleRate, this.pcmEncoding, this.aNa, this.aNb, this.aNd, this.language, this.aNe, this.aNc, this.aMS, this.aMT, paramMetadata);
    AppMethodBeat.o(92340);
    return paramMetadata;
  }
  
  public final Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(92337);
    paramString1 = new Format(paramString1, this.aMP, this.aMQ, paramString2, paramInt1, this.aMR, paramInt2, paramInt3, this.aMU, this.aMV, this.aMW, this.aMY, this.aMX, this.aMZ, this.channelCount, this.sampleRate, this.pcmEncoding, this.aNa, this.aNb, paramInt4, paramString3, this.aNe, this.aNc, this.aMS, this.aMT, this.aMO);
    AppMethodBeat.o(92337);
    return paramString1;
  }
  
  public final Format be(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92338);
    Format localFormat = new Format(this.id, this.aMP, this.aMQ, this.aMN, this.bitrate, this.aMR, this.width, this.height, this.aMU, this.aMV, this.aMW, this.aMY, this.aMX, this.aMZ, this.channelCount, this.sampleRate, this.pcmEncoding, paramInt1, paramInt2, this.aNd, this.language, this.aNe, this.aNc, this.aMS, this.aMT, this.aMO);
    AppMethodBeat.o(92338);
    return localFormat;
  }
  
  public final Format dT(int paramInt)
  {
    AppMethodBeat.i(92335);
    Format localFormat = new Format(this.id, this.aMP, this.aMQ, this.aMN, this.bitrate, paramInt, this.width, this.height, this.aMU, this.aMV, this.aMW, this.aMY, this.aMX, this.aMZ, this.channelCount, this.sampleRate, this.pcmEncoding, this.aNa, this.aNb, this.aNd, this.language, this.aNe, this.aNc, this.aMS, this.aMT, this.aMO);
    AppMethodBeat.o(92335);
    return localFormat;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92344);
    if (this == paramObject)
    {
      AppMethodBeat.o(92344);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92344);
      return false;
    }
    paramObject = (Format)paramObject;
    if ((this.bitrate != paramObject.bitrate) || (this.aMR != paramObject.aMR) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.aMU != paramObject.aMU) || (this.aMV != paramObject.aMV) || (this.aMW != paramObject.aMW) || (this.aMX != paramObject.aMX) || (this.channelCount != paramObject.channelCount) || (this.sampleRate != paramObject.sampleRate) || (this.pcmEncoding != paramObject.pcmEncoding) || (this.aNa != paramObject.aNa) || (this.aNb != paramObject.aNb) || (this.aNc != paramObject.aNc) || (this.aNd != paramObject.aNd) || (!x.h(this.id, paramObject.id)) || (!x.h(this.language, paramObject.language)) || (this.aNe != paramObject.aNe) || (!x.h(this.aMP, paramObject.aMP)) || (!x.h(this.aMQ, paramObject.aMQ)) || (!x.h(this.aMN, paramObject.aMN)) || (!x.h(this.aMT, paramObject.aMT)) || (!x.h(this.aMO, paramObject.aMO)) || (!x.h(this.aMZ, paramObject.aMZ)) || (!Arrays.equals(this.aMY, paramObject.aMY)) || (this.aMS.size() != paramObject.aMS.size()))
    {
      AppMethodBeat.o(92344);
      return false;
    }
    int i = 0;
    while (i < this.aMS.size())
    {
      if (!Arrays.equals((byte[])this.aMS.get(i), (byte[])paramObject.aMS.get(i)))
      {
        AppMethodBeat.o(92344);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(92344);
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(92343);
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
    if (this.aNf == 0)
    {
      if (this.id != null) {
        break label208;
      }
      i = 0;
      if (this.aMP != null) {
        break label219;
      }
      j = 0;
      if (this.aMQ != null) {
        break label230;
      }
      k = 0;
      if (this.aMN != null) {
        break label241;
      }
      m = 0;
      i3 = this.bitrate;
      i4 = this.width;
      i5 = this.height;
      i6 = this.channelCount;
      i7 = this.sampleRate;
      if (this.language != null) {
        break label253;
      }
      n = 0;
      i8 = this.aNe;
      if (this.aMT != null) {
        break label265;
      }
      i1 = 0;
      label109:
      if (this.aMO != null) {
        break label277;
      }
    }
    for (;;)
    {
      this.aNf = ((i1 + ((n + ((((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31) * 31 + i2);
      i = this.aNf;
      AppMethodBeat.o(92343);
      return i;
      label208:
      i = this.id.hashCode();
      break;
      label219:
      j = this.aMP.hashCode();
      break label34;
      label230:
      k = this.aMQ.hashCode();
      break label43;
      label241:
      m = this.aMN.hashCode();
      break label53;
      label253:
      n = this.language.hashCode();
      break label93;
      label265:
      i1 = this.aMT.hashCode();
      break label109;
      label277:
      i2 = this.aMO.hashCode();
    }
  }
  
  public final int rp()
  {
    if ((this.width == -1) || (this.height == -1)) {
      return -1;
    }
    return this.width * this.height;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat rq()
  {
    AppMethodBeat.i(92341);
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.aMQ);
    Object localObject = this.language;
    if (localObject != null) {
      localMediaFormat.setString("language", (String)localObject);
    }
    a(localMediaFormat, "max-input-size", this.aMR);
    a(localMediaFormat, "width", this.width);
    a(localMediaFormat, "height", this.height);
    float f = this.aMU;
    if (f != -1.0F) {
      localMediaFormat.setFloat("frame-rate", f);
    }
    a(localMediaFormat, "rotation-degrees", this.aMV);
    a(localMediaFormat, "channel-count", this.channelCount);
    a(localMediaFormat, "sample-rate", this.sampleRate);
    a(localMediaFormat, "encoder-delay", this.aNa);
    a(localMediaFormat, "encoder-padding", this.aNb);
    int i = 0;
    while (i < this.aMS.size())
    {
      localMediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), ByteBuffer.wrap((byte[])this.aMS.get(i)));
      i += 1;
    }
    localObject = this.aMZ;
    if (localObject != null)
    {
      a(localMediaFormat, "color-transfer", ((ColorInfo)localObject).colorTransfer);
      a(localMediaFormat, "color-standard", ((ColorInfo)localObject).aTA);
      a(localMediaFormat, "color-range", ((ColorInfo)localObject).colorRange);
      localObject = ((ColorInfo)localObject).brw;
      if (localObject != null) {
        localMediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap((byte[])localObject));
      }
    }
    AppMethodBeat.o(92341);
    return localMediaFormat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(92342);
    String str = "Format(" + this.id + ", " + this.aMP + ", " + this.aMQ + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.aMU + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    AppMethodBeat.o(92342);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92347);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.aMP);
    paramParcel.writeString(this.aMQ);
    paramParcel.writeString(this.aMN);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.aMR);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.aMU);
    paramParcel.writeInt(this.aMV);
    paramParcel.writeFloat(this.aMW);
    if (this.aMY != null) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.aMY != null) {
        paramParcel.writeByteArray(this.aMY);
      }
      paramParcel.writeInt(this.aMX);
      paramParcel.writeParcelable(this.aMZ, paramInt);
      paramParcel.writeInt(this.channelCount);
      paramParcel.writeInt(this.sampleRate);
      paramParcel.writeInt(this.pcmEncoding);
      paramParcel.writeInt(this.aNa);
      paramParcel.writeInt(this.aNb);
      paramParcel.writeInt(this.aNd);
      paramParcel.writeString(this.language);
      paramParcel.writeInt(this.aNe);
      paramParcel.writeLong(this.aNc);
      i = this.aMS.size();
      paramParcel.writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeByteArray((byte[])this.aMS.get(paramInt));
        paramInt += 1;
      }
    }
    paramParcel.writeParcelable(this.aMT, 0);
    paramParcel.writeParcelable(this.aMO, 0);
    AppMethodBeat.o(92347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.7.0.1
 */