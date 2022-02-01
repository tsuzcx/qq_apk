package com.tencent.maas.analytics;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.g;
import com.google.d.am.j;
import com.google.d.ar;
import com.google.d.at;
import com.google.d.b.a;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bk;
import com.google.d.bo;
import com.google.d.bp;
import com.google.d.c;
import com.google.d.cb;
import com.google.d.ch;
import com.google.d.cs;
import com.google.d.cx;
import com.google.d.dn;
import com.google.d.dn.a;
import com.google.d.h;
import com.google.d.i;
import com.google.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class MJAnalyticsS12
{
  private static am.g descriptor;
  private static final am.a internal_static_MJAnalyticsEvent_descriptor;
  private static final bg.e internal_static_MJAnalyticsEvent_fieldAccessorTable;
  
  static
  {
    AppMethodBeat.i(216969);
    descriptor = am.g.a(new String[] { "\n\024MJAnalyticsS12.proto\"z\n\020MJAnalyticsEvent\022\f\n\004name\030\001 \002(\t\022\022\n\nerror_code\030\002 \001(\t\022\025\n\rerror_message\030\003 \001(\t\022\f\n\004keys\030\004 \003(\t\022\016\n\006values\030\005 \003(\t\022\017\n\007expands\030\006 \003(\tB,\n\032com.tencent.maas.analyticsB\016MJAnalyticsS12" }, new am.g[0]);
    internal_static_MJAnalyticsEvent_descriptor = (am.a)getDescriptor().ahs().get(0);
    internal_static_MJAnalyticsEvent_fieldAccessorTable = new bg.e(internal_static_MJAnalyticsEvent_descriptor, new String[] { "Name", "ErrorCode", "ErrorMessage", "Keys", "Values", "Expands" });
    AppMethodBeat.o(216969);
  }
  
  public static am.g getDescriptor()
  {
    return descriptor;
  }
  
  public static void registerAllExtensions(ar paramar)
  {
    AppMethodBeat.i(216947);
    registerAllExtensions(paramar);
    AppMethodBeat.o(216947);
  }
  
  public static void registerAllExtensions(at paramat) {}
  
  public static final class MJAnalyticsEvent
    extends bg
    implements MJAnalyticsS12.MJAnalyticsEventOrBuilder
  {
    private static final MJAnalyticsEvent DEFAULT_INSTANCE;
    public static final int ERROR_CODE_FIELD_NUMBER = 2;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 3;
    public static final int EXPANDS_FIELD_NUMBER = 6;
    public static final int KEYS_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    @Deprecated
    public static final cs<MJAnalyticsEvent> PARSER;
    public static final int VALUES_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    private volatile Object errorCode_;
    private volatile Object errorMessage_;
    private bp expands_;
    private bp keys_;
    private byte memoizedIsInitialized = -1;
    private volatile Object name_;
    private bp values_;
    
    static
    {
      AppMethodBeat.i(217220);
      DEFAULT_INSTANCE = new MJAnalyticsEvent();
      PARSER = new c()
      {
        public MJAnalyticsS12.MJAnalyticsEvent parsePartialFrom(i paramAnonymousi, at paramAnonymousat)
        {
          AppMethodBeat.i(216958);
          paramAnonymousi = new MJAnalyticsS12.MJAnalyticsEvent(paramAnonymousi, paramAnonymousat, null);
          AppMethodBeat.o(216958);
          return paramAnonymousi;
        }
      };
      AppMethodBeat.o(217220);
    }
    
    private MJAnalyticsEvent()
    {
      this.name_ = "";
      this.errorCode_ = "";
      this.errorMessage_ = "";
      this.keys_ = bo.dTm;
      this.values_ = bo.dTm;
      this.expands_ = bo.dTm;
    }
    
    private MJAnalyticsEvent(bg.a<?> parama)
    {
      super();
    }
    
    private MJAnalyticsEvent(i parami, at paramat)
    {
      this();
      AppMethodBeat.i(216991);
      if (paramat == null)
      {
        parami = new NullPointerException();
        AppMethodBeat.o(216991);
        throw parami;
      }
      dn.a locala = dn.ajE();
      int i1 = 0;
      int i = 0;
      for (;;)
      {
        label38:
        int k;
        int m;
        int j;
        if (i1 == 0)
        {
          k = i;
          m = i;
          j = i;
        }
        for (;;)
        {
          try
          {
            n = parami.aac();
            switch (n)
            {
            case 10: 
              k = i;
              m = i;
              j = i;
              if (parseUnknownField(parami, locala, paramat, n)) {
                break label38;
              }
              i1 = 1;
              break label38;
              k = i;
              m = i;
              j = i;
              localh = parami.aak();
              k = i;
              m = i;
              j = i;
              this.bitField0_ |= 0x1;
              k = i;
              m = i;
              j = i;
              this.name_ = localh;
              break label38;
            }
          }
          catch (bk parami)
          {
            try
            {
              parami.dST = this;
              AppMethodBeat.o(216991);
              throw parami;
            }
            finally
            {
              j = k;
              if ((j & 0x8) != 0) {
                this.keys_ = this.keys_.aiv();
              }
              if ((j & 0x10) != 0) {
                this.values_ = this.values_.aiv();
              }
              if ((j & 0x20) != 0) {
                this.expands_ = this.expands_.aiv();
              }
              this.unknownFields = locala.ajH();
              makeExtensionsImmutable();
              AppMethodBeat.o(216991);
            }
            k = i;
            m = i;
            j = i;
            localh = parami.aak();
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x2;
            k = i;
            m = i;
            j = i;
            this.errorCode_ = localh;
            break;
          }
          catch (IOException parami)
          {
            j = m;
            parami = new bk(parami);
            j = m;
            parami.dST = this;
            j = m;
            AppMethodBeat.o(216991);
            j = m;
            throw parami;
          }
          finally
          {
            continue;
            k = i;
            m = i;
            j = i;
            localh = parami.aak();
            k = i;
            m = i;
            j = i;
            this.bitField0_ |= 0x4;
            k = i;
            m = i;
            j = i;
            this.errorMessage_ = localh;
          }
          break;
          k = i;
          m = i;
          j = i;
          h localh = parami.aak();
          int n = i;
          if ((i & 0x8) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.keys_ = new bo();
            n = i | 0x8;
          }
          k = n;
          m = n;
          j = n;
          this.keys_.d(localh);
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          localh = parami.aak();
          n = i;
          if ((i & 0x10) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.values_ = new bo();
            n = i | 0x10;
          }
          k = n;
          m = n;
          j = n;
          this.values_.d(localh);
          i = n;
          break;
          k = i;
          m = i;
          j = i;
          localh = parami.aak();
          n = i;
          if ((i & 0x20) == 0)
          {
            k = i;
            m = i;
            j = i;
            this.expands_ = new bo();
            n = i | 0x20;
          }
          k = n;
          m = n;
          j = n;
          this.expands_.d(localh);
          i = n;
          break;
          if ((i & 0x8) != 0) {
            this.keys_ = this.keys_.aiv();
          }
          if ((i & 0x10) != 0) {
            this.values_ = this.values_.aiv();
          }
          if ((i & 0x20) != 0) {
            this.expands_ = this.expands_.aiv();
          }
          this.unknownFields = locala.ajH();
          makeExtensionsImmutable();
          AppMethodBeat.o(216991);
          return;
        }
        i1 = 1;
      }
    }
    
    public static MJAnalyticsEvent getDefaultInstance()
    {
      return DEFAULT_INSTANCE;
    }
    
    public static final am.a getDescriptor()
    {
      AppMethodBeat.i(216995);
      am.a locala = MJAnalyticsS12.internal_static_MJAnalyticsEvent_descriptor;
      AppMethodBeat.o(216995);
      return locala;
    }
    
    public static Builder newBuilder()
    {
      AppMethodBeat.i(217084);
      Builder localBuilder = DEFAULT_INSTANCE.toBuilder();
      AppMethodBeat.o(217084);
      return localBuilder;
    }
    
    public static Builder newBuilder(MJAnalyticsEvent paramMJAnalyticsEvent)
    {
      AppMethodBeat.i(217093);
      paramMJAnalyticsEvent = DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMJAnalyticsEvent);
      AppMethodBeat.o(217093);
      return paramMJAnalyticsEvent;
    }
    
    public static MJAnalyticsEvent parseDelimitedFrom(InputStream paramInputStream)
    {
      AppMethodBeat.i(217051);
      paramInputStream = (MJAnalyticsEvent)bg.parseDelimitedWithIOException(PARSER, paramInputStream);
      AppMethodBeat.o(217051);
      return paramInputStream;
    }
    
    public static MJAnalyticsEvent parseDelimitedFrom(InputStream paramInputStream, at paramat)
    {
      AppMethodBeat.i(217059);
      paramInputStream = (MJAnalyticsEvent)bg.parseDelimitedWithIOException(PARSER, paramInputStream, paramat);
      AppMethodBeat.o(217059);
      return paramInputStream;
    }
    
    public static MJAnalyticsEvent parseFrom(h paramh)
    {
      AppMethodBeat.i(217011);
      paramh = (MJAnalyticsEvent)PARSER.parseFrom(paramh);
      AppMethodBeat.o(217011);
      return paramh;
    }
    
    public static MJAnalyticsEvent parseFrom(h paramh, at paramat)
    {
      AppMethodBeat.i(217016);
      paramh = (MJAnalyticsEvent)PARSER.parseFrom(paramh, paramat);
      AppMethodBeat.o(217016);
      return paramh;
    }
    
    public static MJAnalyticsEvent parseFrom(i parami)
    {
      AppMethodBeat.i(217068);
      parami = (MJAnalyticsEvent)bg.parseWithIOException(PARSER, parami);
      AppMethodBeat.o(217068);
      return parami;
    }
    
    public static MJAnalyticsEvent parseFrom(i parami, at paramat)
    {
      AppMethodBeat.i(217078);
      parami = (MJAnalyticsEvent)bg.parseWithIOException(PARSER, parami, paramat);
      AppMethodBeat.o(217078);
      return parami;
    }
    
    public static MJAnalyticsEvent parseFrom(InputStream paramInputStream)
    {
      AppMethodBeat.i(217035);
      paramInputStream = (MJAnalyticsEvent)bg.parseWithIOException(PARSER, paramInputStream);
      AppMethodBeat.o(217035);
      return paramInputStream;
    }
    
    public static MJAnalyticsEvent parseFrom(InputStream paramInputStream, at paramat)
    {
      AppMethodBeat.i(217041);
      paramInputStream = (MJAnalyticsEvent)bg.parseWithIOException(PARSER, paramInputStream, paramat);
      AppMethodBeat.o(217041);
      return paramInputStream;
    }
    
    public static MJAnalyticsEvent parseFrom(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(217002);
      paramByteBuffer = (MJAnalyticsEvent)PARSER.parseFrom(paramByteBuffer);
      AppMethodBeat.o(217002);
      return paramByteBuffer;
    }
    
    public static MJAnalyticsEvent parseFrom(ByteBuffer paramByteBuffer, at paramat)
    {
      AppMethodBeat.i(217006);
      paramByteBuffer = (MJAnalyticsEvent)PARSER.parseFrom(paramByteBuffer, paramat);
      AppMethodBeat.o(217006);
      return paramByteBuffer;
    }
    
    public static MJAnalyticsEvent parseFrom(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(217023);
      paramArrayOfByte = (MJAnalyticsEvent)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(217023);
      return paramArrayOfByte;
    }
    
    public static MJAnalyticsEvent parseFrom(byte[] paramArrayOfByte, at paramat)
    {
      AppMethodBeat.i(217027);
      paramArrayOfByte = (MJAnalyticsEvent)PARSER.parseFrom(paramArrayOfByte, paramat);
      AppMethodBeat.o(217027);
      return paramArrayOfByte;
    }
    
    public static cs<MJAnalyticsEvent> parser()
    {
      return PARSER;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(217416);
      if (paramObject == this)
      {
        AppMethodBeat.o(217416);
        return true;
      }
      if (!(paramObject instanceof MJAnalyticsEvent))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(217416);
        return bool;
      }
      paramObject = (MJAnalyticsEvent)paramObject;
      if (hasName() != paramObject.hasName())
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if ((hasName()) && (!getName().equals(paramObject.getName())))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if (hasErrorCode() != paramObject.hasErrorCode())
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if ((hasErrorCode()) && (!getErrorCode().equals(paramObject.getErrorCode())))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if (hasErrorMessage() != paramObject.hasErrorMessage())
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if ((hasErrorMessage()) && (!getErrorMessage().equals(paramObject.getErrorMessage())))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if (!getKeysList().equals(paramObject.getKeysList()))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if (!getValuesList().equals(paramObject.getValuesList()))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if (!getExpandsList().equals(paramObject.getExpandsList()))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(217416);
        return false;
      }
      AppMethodBeat.o(217416);
      return true;
    }
    
    public final MJAnalyticsEvent getDefaultInstanceForType()
    {
      return DEFAULT_INSTANCE;
    }
    
    public final String getErrorCode()
    {
      AppMethodBeat.i(217286);
      Object localObject = this.errorCode_;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(217286);
        return localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.errorCode_ = str;
      }
      AppMethodBeat.o(217286);
      return str;
    }
    
    public final h getErrorCodeBytes()
    {
      AppMethodBeat.i(217294);
      Object localObject = this.errorCode_;
      if ((localObject instanceof String))
      {
        localObject = h.dS((String)localObject);
        this.errorCode_ = localObject;
        AppMethodBeat.o(217294);
        return localObject;
      }
      localObject = (h)localObject;
      AppMethodBeat.o(217294);
      return localObject;
    }
    
    public final String getErrorMessage()
    {
      AppMethodBeat.i(217306);
      Object localObject = this.errorMessage_;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(217306);
        return localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.errorMessage_ = str;
      }
      AppMethodBeat.o(217306);
      return str;
    }
    
    public final h getErrorMessageBytes()
    {
      AppMethodBeat.i(217316);
      Object localObject = this.errorMessage_;
      if ((localObject instanceof String))
      {
        localObject = h.dS((String)localObject);
        this.errorMessage_ = localObject;
        AppMethodBeat.o(217316);
        return localObject;
      }
      localObject = (h)localObject;
      AppMethodBeat.o(217316);
      return localObject;
    }
    
    public final String getExpands(int paramInt)
    {
      AppMethodBeat.i(217389);
      String str = (String)this.expands_.get(paramInt);
      AppMethodBeat.o(217389);
      return str;
    }
    
    public final h getExpandsBytes(int paramInt)
    {
      AppMethodBeat.i(217396);
      h localh = this.expands_.ll(paramInt);
      AppMethodBeat.o(217396);
      return localh;
    }
    
    public final int getExpandsCount()
    {
      AppMethodBeat.i(217383);
      int i = this.expands_.size();
      AppMethodBeat.o(217383);
      return i;
    }
    
    public final cx getExpandsList()
    {
      return this.expands_;
    }
    
    public final String getKeys(int paramInt)
    {
      AppMethodBeat.i(217336);
      String str = (String)this.keys_.get(paramInt);
      AppMethodBeat.o(217336);
      return str;
    }
    
    public final h getKeysBytes(int paramInt)
    {
      AppMethodBeat.i(217345);
      h localh = this.keys_.ll(paramInt);
      AppMethodBeat.o(217345);
      return localh;
    }
    
    public final int getKeysCount()
    {
      AppMethodBeat.i(217327);
      int i = this.keys_.size();
      AppMethodBeat.o(217327);
      return i;
    }
    
    public final cx getKeysList()
    {
      return this.keys_;
    }
    
    public final String getName()
    {
      AppMethodBeat.i(217262);
      Object localObject = this.name_;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(217262);
        return localObject;
      }
      localObject = (h)localObject;
      String str = ((h)localObject).ZV();
      if (((h)localObject).ZW()) {
        this.name_ = str;
      }
      AppMethodBeat.o(217262);
      return str;
    }
    
    public final h getNameBytes()
    {
      AppMethodBeat.i(217269);
      Object localObject = this.name_;
      if ((localObject instanceof String))
      {
        localObject = h.dS((String)localObject);
        this.name_ = localObject;
        AppMethodBeat.o(217269);
        return localObject;
      }
      localObject = (h)localObject;
      AppMethodBeat.o(217269);
      return localObject;
    }
    
    public final cs<MJAnalyticsEvent> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(217412);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(217412);
        return i;
      }
      if ((this.bitField0_ & 0x1) != 0) {}
      for (int j = bg.computeStringSize(1, this.name_) + 0;; j = 0)
      {
        i = j;
        if ((this.bitField0_ & 0x2) != 0) {
          i = j + bg.computeStringSize(2, this.errorCode_);
        }
        j = i;
        if ((this.bitField0_ & 0x4) != 0) {
          j = i + bg.computeStringSize(3, this.errorMessage_);
        }
        int k = 0;
        i = 0;
        while (k < this.keys_.size())
        {
          i += computeStringSizeNoTag(this.keys_.getRaw(k));
          k += 1;
        }
        int i1 = getKeysList().size();
        int m = 0;
        k = 0;
        while (m < this.values_.size())
        {
          k += computeStringSizeNoTag(this.values_.getRaw(m));
          m += 1;
        }
        int i2 = getValuesList().size();
        m = 0;
        int n = 0;
        while (m < this.expands_.size())
        {
          n += computeStringSizeNoTag(this.expands_.getRaw(m));
          m += 1;
        }
        i = j + i + i1 * 1 + k + i2 * 1 + n + getExpandsList().size() * 1 + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        AppMethodBeat.o(217412);
        return i;
      }
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final String getValues(int paramInt)
    {
      AppMethodBeat.i(217364);
      String str = (String)this.values_.get(paramInt);
      AppMethodBeat.o(217364);
      return str;
    }
    
    public final h getValuesBytes(int paramInt)
    {
      AppMethodBeat.i(217370);
      h localh = this.values_.ll(paramInt);
      AppMethodBeat.o(217370);
      return localh;
    }
    
    public final int getValuesCount()
    {
      AppMethodBeat.i(217356);
      int i = this.values_.size();
      AppMethodBeat.o(217356);
      return i;
    }
    
    public final cx getValuesList()
    {
      return this.values_;
    }
    
    public final boolean hasErrorCode()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean hasErrorMessage()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean hasName()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(217422);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(217422);
        return i;
      }
      int j = getDescriptor().hashCode() + 779;
      int i = j;
      if (hasName()) {
        i = (j * 37 + 1) * 53 + getName().hashCode();
      }
      j = i;
      if (hasErrorCode()) {
        j = (i * 37 + 2) * 53 + getErrorCode().hashCode();
      }
      i = j;
      if (hasErrorMessage()) {
        i = (j * 37 + 3) * 53 + getErrorMessage().hashCode();
      }
      j = i;
      if (getKeysCount() > 0) {
        j = (i * 37 + 4) * 53 + getKeysList().hashCode();
      }
      i = j;
      if (getValuesCount() > 0) {
        i = (j * 37 + 5) * 53 + getValuesList().hashCode();
      }
      j = i;
      if (getExpandsCount() > 0) {
        j = (i * 37 + 6) * 53 + getExpandsList().hashCode();
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(217422);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(217246);
      bg.e locale = MJAnalyticsS12.internal_static_MJAnalyticsEvent_fieldAccessorTable.b(MJAnalyticsEvent.class, Builder.class);
      AppMethodBeat.o(217246);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(217399);
      int i = this.memoizedIsInitialized;
      if (i == 1)
      {
        AppMethodBeat.o(217399);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(217399);
        return false;
      }
      if (!hasName())
      {
        this.memoizedIsInitialized = 0;
        AppMethodBeat.o(217399);
        return false;
      }
      this.memoizedIsInitialized = 1;
      AppMethodBeat.o(217399);
      return true;
    }
    
    public final Builder newBuilderForType()
    {
      AppMethodBeat.i(217427);
      Builder localBuilder = newBuilder();
      AppMethodBeat.o(217427);
      return localBuilder;
    }
    
    protected final Builder newBuilderForType(bg.b paramb)
    {
      AppMethodBeat.i(217442);
      paramb = new Builder(paramb, null);
      AppMethodBeat.o(217442);
      return paramb;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(217230);
      paramf = new MJAnalyticsEvent();
      AppMethodBeat.o(217230);
      return paramf;
    }
    
    public final Builder toBuilder()
    {
      AppMethodBeat.i(217435);
      if (this == DEFAULT_INSTANCE)
      {
        localBuilder = new Builder(null);
        AppMethodBeat.o(217435);
        return localBuilder;
      }
      Builder localBuilder = new Builder(null).mergeFrom(this);
      AppMethodBeat.o(217435);
      return localBuilder;
    }
    
    public final void writeTo(k paramk)
    {
      int k = 0;
      AppMethodBeat.i(217406);
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.name_);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        bg.writeString(paramk, 2, this.errorCode_);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        bg.writeString(paramk, 3, this.errorMessage_);
      }
      int i = 0;
      while (i < this.keys_.size())
      {
        bg.writeString(paramk, 4, this.keys_.getRaw(i));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.values_.size()) {
          break;
        }
        bg.writeString(paramk, 5, this.values_.getRaw(i));
        i += 1;
      }
      while (j < this.expands_.size())
      {
        bg.writeString(paramk, 6, this.expands_.getRaw(j));
        j += 1;
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(217406);
    }
    
    public static final class Builder
      extends bg.a<Builder>
      implements MJAnalyticsS12.MJAnalyticsEventOrBuilder
    {
      private int bitField0_;
      private Object errorCode_;
      private Object errorMessage_;
      private bp expands_;
      private bp keys_;
      private Object name_;
      private bp values_;
      
      private Builder()
      {
        AppMethodBeat.i(216952);
        this.name_ = "";
        this.errorCode_ = "";
        this.errorMessage_ = "";
        this.keys_ = bo.dTm;
        this.values_ = bo.dTm;
        this.expands_ = bo.dTm;
        maybeForceBuilderInitialization();
        AppMethodBeat.o(216952);
      }
      
      private Builder(bg.b paramb)
      {
        super();
        AppMethodBeat.i(216957);
        this.name_ = "";
        this.errorCode_ = "";
        this.errorMessage_ = "";
        this.keys_ = bo.dTm;
        this.values_ = bo.dTm;
        this.expands_ = bo.dTm;
        maybeForceBuilderInitialization();
        AppMethodBeat.o(216957);
      }
      
      private void ensureExpandsIsMutable()
      {
        AppMethodBeat.i(216978);
        if ((this.bitField0_ & 0x20) == 0)
        {
          this.expands_ = new bo(this.expands_);
          this.bitField0_ |= 0x20;
        }
        AppMethodBeat.o(216978);
      }
      
      private void ensureKeysIsMutable()
      {
        AppMethodBeat.i(216966);
        if ((this.bitField0_ & 0x8) == 0)
        {
          this.keys_ = new bo(this.keys_);
          this.bitField0_ |= 0x8;
        }
        AppMethodBeat.o(216966);
      }
      
      private void ensureValuesIsMutable()
      {
        AppMethodBeat.i(216972);
        if ((this.bitField0_ & 0x10) == 0)
        {
          this.values_ = new bo(this.values_);
          this.bitField0_ |= 0x10;
        }
        AppMethodBeat.o(216972);
      }
      
      public static final am.a getDescriptor()
      {
        AppMethodBeat.i(216946);
        am.a locala = MJAnalyticsS12.internal_static_MJAnalyticsEvent_descriptor;
        AppMethodBeat.o(216946);
        return locala;
      }
      
      private void maybeForceBuilderInitialization()
      {
        AppMethodBeat.i(216962);
        AppMethodBeat.o(216962);
      }
      
      public final Builder addAllExpands(Iterable<String> paramIterable)
      {
        AppMethodBeat.i(217404);
        ensureExpandsIsMutable();
        b.a.addAll(paramIterable, this.expands_);
        onChanged();
        AppMethodBeat.o(217404);
        return this;
      }
      
      public final Builder addAllKeys(Iterable<String> paramIterable)
      {
        AppMethodBeat.i(217281);
        ensureKeysIsMutable();
        b.a.addAll(paramIterable, this.keys_);
        onChanged();
        AppMethodBeat.o(217281);
        return this;
      }
      
      public final Builder addAllValues(Iterable<String> paramIterable)
      {
        AppMethodBeat.i(217348);
        ensureValuesIsMutable();
        b.a.addAll(paramIterable, this.values_);
        onChanged();
        AppMethodBeat.o(217348);
        return this;
      }
      
      public final Builder addExpands(String paramString)
      {
        AppMethodBeat.i(217398);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217398);
          throw paramString;
        }
        ensureExpandsIsMutable();
        this.expands_.add(paramString);
        onChanged();
        AppMethodBeat.o(217398);
        return this;
      }
      
      public final Builder addExpandsBytes(h paramh)
      {
        AppMethodBeat.i(217410);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(217410);
          throw paramh;
        }
        ensureExpandsIsMutable();
        this.expands_.d(paramh);
        onChanged();
        AppMethodBeat.o(217410);
        return this;
      }
      
      public final Builder addKeys(String paramString)
      {
        AppMethodBeat.i(217273);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217273);
          throw paramString;
        }
        ensureKeysIsMutable();
        this.keys_.add(paramString);
        onChanged();
        AppMethodBeat.o(217273);
        return this;
      }
      
      public final Builder addKeysBytes(h paramh)
      {
        AppMethodBeat.i(217295);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(217295);
          throw paramh;
        }
        ensureKeysIsMutable();
        this.keys_.d(paramh);
        onChanged();
        AppMethodBeat.o(217295);
        return this;
      }
      
      public final Builder addRepeatedField(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217067);
        paramf = (Builder)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(217067);
        return paramf;
      }
      
      public final Builder addValues(String paramString)
      {
        AppMethodBeat.i(217339);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217339);
          throw paramString;
        }
        ensureValuesIsMutable();
        this.values_.add(paramString);
        onChanged();
        AppMethodBeat.o(217339);
        return this;
      }
      
      public final Builder addValuesBytes(h paramh)
      {
        AppMethodBeat.i(217362);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(217362);
          throw paramh;
        }
        ensureValuesIsMutable();
        this.values_.d(paramh);
        onChanged();
        AppMethodBeat.o(217362);
        return this;
      }
      
      public final MJAnalyticsS12.MJAnalyticsEvent build()
      {
        AppMethodBeat.i(217010);
        Object localObject = buildPartial();
        if (!((MJAnalyticsS12.MJAnalyticsEvent)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(217010);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217010);
        return localObject;
      }
      
      public final MJAnalyticsS12.MJAnalyticsEvent buildPartial()
      {
        AppMethodBeat.i(217019);
        MJAnalyticsS12.MJAnalyticsEvent localMJAnalyticsEvent = new MJAnalyticsS12.MJAnalyticsEvent(this, null);
        int k = this.bitField0_;
        int j = 0;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        MJAnalyticsS12.MJAnalyticsEvent.access$602(localMJAnalyticsEvent, this.name_);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        MJAnalyticsS12.MJAnalyticsEvent.access$702(localMJAnalyticsEvent, this.errorCode_);
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        MJAnalyticsS12.MJAnalyticsEvent.access$802(localMJAnalyticsEvent, this.errorMessage_);
        if ((this.bitField0_ & 0x8) != 0)
        {
          this.keys_ = this.keys_.aiv();
          this.bitField0_ &= 0xFFFFFFF7;
        }
        MJAnalyticsS12.MJAnalyticsEvent.access$902(localMJAnalyticsEvent, this.keys_);
        if ((this.bitField0_ & 0x10) != 0)
        {
          this.values_ = this.values_.aiv();
          this.bitField0_ &= 0xFFFFFFEF;
        }
        MJAnalyticsS12.MJAnalyticsEvent.access$1002(localMJAnalyticsEvent, this.values_);
        if ((this.bitField0_ & 0x20) != 0)
        {
          this.expands_ = this.expands_.aiv();
          this.bitField0_ &= 0xFFFFFFDF;
        }
        MJAnalyticsS12.MJAnalyticsEvent.access$1102(localMJAnalyticsEvent, this.expands_);
        MJAnalyticsS12.MJAnalyticsEvent.access$1202(localMJAnalyticsEvent, j);
        onBuilt();
        AppMethodBeat.o(217019);
        return localMJAnalyticsEvent;
      }
      
      public final Builder clear()
      {
        AppMethodBeat.i(216996);
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.errorCode_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.errorMessage_ = "";
        this.bitField0_ &= 0xFFFFFFFB;
        this.keys_ = bo.dTm;
        this.bitField0_ &= 0xFFFFFFF7;
        this.values_ = bo.dTm;
        this.bitField0_ &= 0xFFFFFFEF;
        this.expands_ = bo.dTm;
        this.bitField0_ &= 0xFFFFFFDF;
        AppMethodBeat.o(216996);
        return this;
      }
      
      public final Builder clearErrorCode()
      {
        AppMethodBeat.i(217171);
        this.bitField0_ &= 0xFFFFFFFD;
        this.errorCode_ = MJAnalyticsS12.MJAnalyticsEvent.getDefaultInstance().getErrorCode();
        onChanged();
        AppMethodBeat.o(217171);
        return this;
      }
      
      public final Builder clearErrorMessage()
      {
        AppMethodBeat.i(217215);
        this.bitField0_ &= 0xFFFFFFFB;
        this.errorMessage_ = MJAnalyticsS12.MJAnalyticsEvent.getDefaultInstance().getErrorMessage();
        onChanged();
        AppMethodBeat.o(217215);
        return this;
      }
      
      public final Builder clearExpands()
      {
        AppMethodBeat.i(217407);
        this.expands_ = bo.dTm;
        this.bitField0_ &= 0xFFFFFFDF;
        onChanged();
        AppMethodBeat.o(217407);
        return this;
      }
      
      public final Builder clearField(am.f paramf)
      {
        AppMethodBeat.i(217039);
        paramf = (Builder)super.clearField(paramf);
        AppMethodBeat.o(217039);
        return paramf;
      }
      
      public final Builder clearKeys()
      {
        AppMethodBeat.i(217289);
        this.keys_ = bo.dTm;
        this.bitField0_ &= 0xFFFFFFF7;
        onChanged();
        AppMethodBeat.o(217289);
        return this;
      }
      
      public final Builder clearName()
      {
        AppMethodBeat.i(217133);
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = MJAnalyticsS12.MJAnalyticsEvent.getDefaultInstance().getName();
        onChanged();
        AppMethodBeat.o(217133);
        return this;
      }
      
      public final Builder clearOneof(am.j paramj)
      {
        AppMethodBeat.i(217049);
        paramj = (Builder)super.clearOneof(paramj);
        AppMethodBeat.o(217049);
        return paramj;
      }
      
      public final Builder clearValues()
      {
        AppMethodBeat.i(217355);
        this.values_ = bo.dTm;
        this.bitField0_ &= 0xFFFFFFEF;
        onChanged();
        AppMethodBeat.o(217355);
        return this;
      }
      
      public final Builder clone()
      {
        AppMethodBeat.i(217025);
        Builder localBuilder = (Builder)super.clone();
        AppMethodBeat.o(217025);
        return localBuilder;
      }
      
      public final MJAnalyticsS12.MJAnalyticsEvent getDefaultInstanceForType()
      {
        AppMethodBeat.i(217007);
        MJAnalyticsS12.MJAnalyticsEvent localMJAnalyticsEvent = MJAnalyticsS12.MJAnalyticsEvent.getDefaultInstance();
        AppMethodBeat.o(217007);
        return localMJAnalyticsEvent;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(217001);
        am.a locala = MJAnalyticsS12.internal_static_MJAnalyticsEvent_descriptor;
        AppMethodBeat.o(217001);
        return locala;
      }
      
      public final String getErrorCode()
      {
        AppMethodBeat.i(217147);
        Object localObject = this.errorCode_;
        if (!(localObject instanceof String))
        {
          localObject = (h)localObject;
          String str = ((h)localObject).ZV();
          if (((h)localObject).ZW()) {
            this.errorCode_ = str;
          }
          AppMethodBeat.o(217147);
          return str;
        }
        localObject = (String)localObject;
        AppMethodBeat.o(217147);
        return localObject;
      }
      
      public final h getErrorCodeBytes()
      {
        AppMethodBeat.i(217154);
        Object localObject = this.errorCode_;
        if ((localObject instanceof String))
        {
          localObject = h.dS((String)localObject);
          this.errorCode_ = localObject;
          AppMethodBeat.o(217154);
          return localObject;
        }
        localObject = (h)localObject;
        AppMethodBeat.o(217154);
        return localObject;
      }
      
      public final String getErrorMessage()
      {
        AppMethodBeat.i(217193);
        Object localObject = this.errorMessage_;
        if (!(localObject instanceof String))
        {
          localObject = (h)localObject;
          String str = ((h)localObject).ZV();
          if (((h)localObject).ZW()) {
            this.errorMessage_ = str;
          }
          AppMethodBeat.o(217193);
          return str;
        }
        localObject = (String)localObject;
        AppMethodBeat.o(217193);
        return localObject;
      }
      
      public final h getErrorMessageBytes()
      {
        AppMethodBeat.i(217200);
        Object localObject = this.errorMessage_;
        if ((localObject instanceof String))
        {
          localObject = h.dS((String)localObject);
          this.errorMessage_ = localObject;
          AppMethodBeat.o(217200);
          return localObject;
        }
        localObject = (h)localObject;
        AppMethodBeat.o(217200);
        return localObject;
      }
      
      public final String getExpands(int paramInt)
      {
        AppMethodBeat.i(217381);
        String str = (String)this.expands_.get(paramInt);
        AppMethodBeat.o(217381);
        return str;
      }
      
      public final h getExpandsBytes(int paramInt)
      {
        AppMethodBeat.i(217386);
        h localh = this.expands_.ll(paramInt);
        AppMethodBeat.o(217386);
        return localh;
      }
      
      public final int getExpandsCount()
      {
        AppMethodBeat.i(217376);
        int i = this.expands_.size();
        AppMethodBeat.o(217376);
        return i;
      }
      
      public final cx getExpandsList()
      {
        AppMethodBeat.i(217369);
        bp localbp = this.expands_.aiv();
        AppMethodBeat.o(217369);
        return localbp;
      }
      
      public final String getKeys(int paramInt)
      {
        AppMethodBeat.i(217253);
        String str = (String)this.keys_.get(paramInt);
        AppMethodBeat.o(217253);
        return str;
      }
      
      public final h getKeysBytes(int paramInt)
      {
        AppMethodBeat.i(217260);
        h localh = this.keys_.ll(paramInt);
        AppMethodBeat.o(217260);
        return localh;
      }
      
      public final int getKeysCount()
      {
        AppMethodBeat.i(217243);
        int i = this.keys_.size();
        AppMethodBeat.o(217243);
        return i;
      }
      
      public final cx getKeysList()
      {
        AppMethodBeat.i(217236);
        bp localbp = this.keys_.aiv();
        AppMethodBeat.o(217236);
        return localbp;
      }
      
      public final String getName()
      {
        AppMethodBeat.i(217116);
        Object localObject = this.name_;
        if (!(localObject instanceof String))
        {
          localObject = (h)localObject;
          String str = ((h)localObject).ZV();
          if (((h)localObject).ZW()) {
            this.name_ = str;
          }
          AppMethodBeat.o(217116);
          return str;
        }
        localObject = (String)localObject;
        AppMethodBeat.o(217116);
        return localObject;
      }
      
      public final h getNameBytes()
      {
        AppMethodBeat.i(217121);
        Object localObject = this.name_;
        if ((localObject instanceof String))
        {
          localObject = h.dS((String)localObject);
          this.name_ = localObject;
          AppMethodBeat.o(217121);
          return localObject;
        }
        localObject = (h)localObject;
        AppMethodBeat.o(217121);
        return localObject;
      }
      
      public final String getValues(int paramInt)
      {
        AppMethodBeat.i(217320);
        String str = (String)this.values_.get(paramInt);
        AppMethodBeat.o(217320);
        return str;
      }
      
      public final h getValuesBytes(int paramInt)
      {
        AppMethodBeat.i(217325);
        h localh = this.values_.ll(paramInt);
        AppMethodBeat.o(217325);
        return localh;
      }
      
      public final int getValuesCount()
      {
        AppMethodBeat.i(217310);
        int i = this.values_.size();
        AppMethodBeat.o(217310);
        return i;
      }
      
      public final cx getValuesList()
      {
        AppMethodBeat.i(217303);
        bp localbp = this.values_.aiv();
        AppMethodBeat.o(217303);
        return localbp;
      }
      
      public final boolean hasErrorCode()
      {
        return (this.bitField0_ & 0x2) != 0;
      }
      
      public final boolean hasErrorMessage()
      {
        return (this.bitField0_ & 0x4) != 0;
      }
      
      public final boolean hasName()
      {
        return (this.bitField0_ & 0x1) != 0;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(216990);
        bg.e locale = MJAnalyticsS12.internal_static_MJAnalyticsEvent_fieldAccessorTable.b(MJAnalyticsS12.MJAnalyticsEvent.class, Builder.class);
        AppMethodBeat.o(216990);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(217099);
        if (!hasName())
        {
          AppMethodBeat.o(217099);
          return false;
        }
        AppMethodBeat.o(217099);
        return true;
      }
      
      public final Builder mergeFrom(cb paramcb)
      {
        AppMethodBeat.i(217077);
        if ((paramcb instanceof MJAnalyticsS12.MJAnalyticsEvent))
        {
          paramcb = mergeFrom((MJAnalyticsS12.MJAnalyticsEvent)paramcb);
          AppMethodBeat.o(217077);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(217077);
        return this;
      }
      
      /* Error */
      public final Builder mergeFrom(i parami, at paramat)
      {
        // Byte code:
        //   0: ldc_w 412
        //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   6: aconst_null
        //   7: astore_3
        //   8: getstatic 416	com/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent:PARSER	Lcom/google/d/cs;
        //   11: aload_1
        //   12: aload_2
        //   13: invokeinterface 422 3 0
        //   18: checkcast 9	com/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent
        //   21: astore_1
        //   22: aload_1
        //   23: ifnull +9 -> 32
        //   26: aload_0
        //   27: aload_1
        //   28: invokevirtual 407	com/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent$Builder:mergeFrom	(Lcom/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent;)Lcom/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent$Builder;
        //   31: pop
        //   32: ldc_w 412
        //   35: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   38: aload_0
        //   39: areturn
        //   40: astore_1
        //   41: aload_1
        //   42: getfield 426	com/google/d/bk:dST	Lcom/google/d/ce;
        //   45: checkcast 9	com/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent
        //   48: astore_2
        //   49: aload_1
        //   50: invokevirtual 430	com/google/d/bk:aii	()Ljava/io/IOException;
        //   53: astore_1
        //   54: ldc_w 412
        //   57: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   60: aload_1
        //   61: athrow
        //   62: astore_1
        //   63: aload_2
        //   64: ifnull +9 -> 73
        //   67: aload_0
        //   68: aload_2
        //   69: invokevirtual 407	com/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent$Builder:mergeFrom	(Lcom/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent;)Lcom/tencent/maas/analytics/MJAnalyticsS12$MJAnalyticsEvent$Builder;
        //   72: pop
        //   73: ldc_w 412
        //   76: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   79: aload_1
        //   80: athrow
        //   81: astore_1
        //   82: aload_3
        //   83: astore_2
        //   84: goto -21 -> 63
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	Builder
        //   0	87	1	parami	i
        //   0	87	2	paramat	at
        //   7	76	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	22	40	com/google/d/bk
        //   49	62	62	finally
        //   8	22	81	finally
        //   41	49	81	finally
      }
      
      public final Builder mergeFrom(MJAnalyticsS12.MJAnalyticsEvent paramMJAnalyticsEvent)
      {
        AppMethodBeat.i(217091);
        if (paramMJAnalyticsEvent == MJAnalyticsS12.MJAnalyticsEvent.getDefaultInstance())
        {
          AppMethodBeat.o(217091);
          return this;
        }
        if (paramMJAnalyticsEvent.hasName())
        {
          this.bitField0_ |= 0x1;
          this.name_ = paramMJAnalyticsEvent.name_;
          onChanged();
        }
        if (paramMJAnalyticsEvent.hasErrorCode())
        {
          this.bitField0_ |= 0x2;
          this.errorCode_ = paramMJAnalyticsEvent.errorCode_;
          onChanged();
        }
        if (paramMJAnalyticsEvent.hasErrorMessage())
        {
          this.bitField0_ |= 0x4;
          this.errorMessage_ = paramMJAnalyticsEvent.errorMessage_;
          onChanged();
        }
        if (!paramMJAnalyticsEvent.keys_.isEmpty())
        {
          if (this.keys_.isEmpty())
          {
            this.keys_ = paramMJAnalyticsEvent.keys_;
            this.bitField0_ &= 0xFFFFFFF7;
            onChanged();
          }
        }
        else
        {
          if (!paramMJAnalyticsEvent.values_.isEmpty())
          {
            if (!this.values_.isEmpty()) {
              break label291;
            }
            this.values_ = paramMJAnalyticsEvent.values_;
            this.bitField0_ &= 0xFFFFFFEF;
            label198:
            onChanged();
          }
          if (!paramMJAnalyticsEvent.expands_.isEmpty())
          {
            if (!this.expands_.isEmpty()) {
              break label312;
            }
            this.expands_ = paramMJAnalyticsEvent.expands_;
            this.bitField0_ &= 0xFFFFFFDF;
          }
        }
        for (;;)
        {
          onChanged();
          mergeUnknownFields(paramMJAnalyticsEvent.unknownFields);
          onChanged();
          AppMethodBeat.o(217091);
          return this;
          ensureKeysIsMutable();
          this.keys_.addAll(paramMJAnalyticsEvent.keys_);
          break;
          label291:
          ensureValuesIsMutable();
          this.values_.addAll(paramMJAnalyticsEvent.values_);
          break label198;
          label312:
          ensureExpandsIsMutable();
          this.expands_.addAll(paramMJAnalyticsEvent.expands_);
        }
      }
      
      public final Builder mergeUnknownFields(dn paramdn)
      {
        AppMethodBeat.i(217417);
        paramdn = (Builder)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(217417);
        return paramdn;
      }
      
      public final Builder setErrorCode(String paramString)
      {
        AppMethodBeat.i(217162);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217162);
          throw paramString;
        }
        this.bitField0_ |= 0x2;
        this.errorCode_ = paramString;
        onChanged();
        AppMethodBeat.o(217162);
        return this;
      }
      
      public final Builder setErrorCodeBytes(h paramh)
      {
        AppMethodBeat.i(217179);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(217179);
          throw paramh;
        }
        this.bitField0_ |= 0x2;
        this.errorCode_ = paramh;
        onChanged();
        AppMethodBeat.o(217179);
        return this;
      }
      
      public final Builder setErrorMessage(String paramString)
      {
        AppMethodBeat.i(217208);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217208);
          throw paramString;
        }
        this.bitField0_ |= 0x4;
        this.errorMessage_ = paramString;
        onChanged();
        AppMethodBeat.o(217208);
        return this;
      }
      
      public final Builder setErrorMessageBytes(h paramh)
      {
        AppMethodBeat.i(217227);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(217227);
          throw paramh;
        }
        this.bitField0_ |= 0x4;
        this.errorMessage_ = paramh;
        onChanged();
        AppMethodBeat.o(217227);
        return this;
      }
      
      public final Builder setExpands(int paramInt, String paramString)
      {
        AppMethodBeat.i(217392);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217392);
          throw paramString;
        }
        ensureExpandsIsMutable();
        this.expands_.set(paramInt, paramString);
        onChanged();
        AppMethodBeat.o(217392);
        return this;
      }
      
      public final Builder setField(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217031);
        paramf = (Builder)super.setField(paramf, paramObject);
        AppMethodBeat.o(217031);
        return paramf;
      }
      
      public final Builder setKeys(int paramInt, String paramString)
      {
        AppMethodBeat.i(217265);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217265);
          throw paramString;
        }
        ensureKeysIsMutable();
        this.keys_.set(paramInt, paramString);
        onChanged();
        AppMethodBeat.o(217265);
        return this;
      }
      
      public final Builder setName(String paramString)
      {
        AppMethodBeat.i(217125);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217125);
          throw paramString;
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramString;
        onChanged();
        AppMethodBeat.o(217125);
        return this;
      }
      
      public final Builder setNameBytes(h paramh)
      {
        AppMethodBeat.i(217136);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(217136);
          throw paramh;
        }
        this.bitField0_ |= 0x1;
        this.name_ = paramh;
        onChanged();
        AppMethodBeat.o(217136);
        return this;
      }
      
      public final Builder setRepeatedField(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(217060);
        paramf = (Builder)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(217060);
        return paramf;
      }
      
      public final Builder setUnknownFields(dn paramdn)
      {
        AppMethodBeat.i(217414);
        paramdn = (Builder)super.setUnknownFields(paramdn);
        AppMethodBeat.o(217414);
        return paramdn;
      }
      
      public final Builder setValues(int paramInt, String paramString)
      {
        AppMethodBeat.i(217330);
        if (paramString == null)
        {
          paramString = new NullPointerException();
          AppMethodBeat.o(217330);
          throw paramString;
        }
        ensureValuesIsMutable();
        this.values_.set(paramInt, paramString);
        onChanged();
        AppMethodBeat.o(217330);
        return this;
      }
    }
  }
  
  public static abstract interface MJAnalyticsEventOrBuilder
    extends ch
  {
    public abstract String getErrorCode();
    
    public abstract h getErrorCodeBytes();
    
    public abstract String getErrorMessage();
    
    public abstract h getErrorMessageBytes();
    
    public abstract String getExpands(int paramInt);
    
    public abstract h getExpandsBytes(int paramInt);
    
    public abstract int getExpandsCount();
    
    public abstract List<String> getExpandsList();
    
    public abstract String getKeys(int paramInt);
    
    public abstract h getKeysBytes(int paramInt);
    
    public abstract int getKeysCount();
    
    public abstract List<String> getKeysList();
    
    public abstract String getName();
    
    public abstract h getNameBytes();
    
    public abstract String getValues(int paramInt);
    
    public abstract h getValuesBytes(int paramInt);
    
    public abstract int getValuesCount();
    
    public abstract List<String> getValuesList();
    
    public abstract boolean hasErrorCode();
    
    public abstract boolean hasErrorMessage();
    
    public abstract boolean hasName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.maas.analytics.MJAnalyticsS12
 * JD-Core Version:    0.7.0.1
 */