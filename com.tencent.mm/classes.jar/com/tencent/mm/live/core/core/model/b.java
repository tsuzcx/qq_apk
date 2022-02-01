package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveCacheInfo;", "", "()V", "TAG", "", "cacheLiveInfo", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/live/core/core/model/LiveCacheInfo$LiveDecryptionWrapper;", "getCacheLiveInfo$annotations", "getCacheLiveInfo", "()Lcom/tencent/mm/sdk/platformtools/LruCache;", "haveDecrypt", "", "key", "havePlay", "setDecryptParams", "", "decrypString", "setPlay", "LiveDecryptionWrapper", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b mMD;
  private static final LruCache<Integer, a> mME;
  
  static
  {
    AppMethodBeat.i(247928);
    mMD = new b();
    mME = new LruCache(10);
    AppMethodBeat.o(247928);
  }
  
  public static final void F(int paramInt, String paramString)
  {
    AppMethodBeat.i(247898);
    if (paramInt != 0)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label69;
      }
    }
    label69:
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("LiveCacheInfo", "setDecryptParams error,key:" + paramInt + ",decrypString:" + paramString);
      AppMethodBeat.o(247898);
      return;
    }
    Object localObject = (a)mME.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = mME;
        paramString = new a(paramInt, true, paramString, false);
        Log.i("LiveCacheInfo", s.X("setDecryptParams new, ", paramString));
        ah localah = ah.aiuX;
        ((LruCache)localObject).put(Integer.valueOf(paramInt), paramString);
      }
      AppMethodBeat.o(247898);
      return;
      ((a)localObject).key = paramInt;
      ((a)localObject).mMF = true;
      s.u(paramString, "<set-?>");
      ((a)localObject).mMG = paramString;
      ((a)localObject).mMH = false;
      Log.i("LiveCacheInfo", s.X("setDecryptParams reuse, ", localObject));
    }
  }
  
  public static final void sM(int paramInt)
  {
    AppMethodBeat.i(247906);
    if (paramInt == 0)
    {
      Log.e("LiveCacheInfo", "setPlay error,key is 0!");
      AppMethodBeat.o(247906);
      return;
    }
    Object localObject = (a)mME.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null)
      {
        localObject = mME;
        a locala = new a(paramInt, null, true, 6);
        Log.i("LiveCacheInfo", s.X("setPlay new, ", locala));
        ah localah = ah.aiuX;
        ((LruCache)localObject).put(Integer.valueOf(paramInt), locala);
      }
      AppMethodBeat.o(247906);
      return;
      ((a)localObject).key = paramInt;
      ((a)localObject).mMH = true;
      Log.i("LiveCacheInfo", s.X("setPlay reuse, ", localObject));
    }
  }
  
  public static boolean sN(int paramInt)
  {
    AppMethodBeat.i(247914);
    a locala = (a)mME.get(Integer.valueOf(paramInt));
    if ((locala != null) && (locala.mMF == true))
    {
      AppMethodBeat.o(247914);
      return true;
    }
    AppMethodBeat.o(247914);
    return false;
  }
  
  public static boolean sO(int paramInt)
  {
    AppMethodBeat.i(247921);
    a locala = (a)mME.get(Integer.valueOf(paramInt));
    if ((locala != null) && (locala.mMH == true))
    {
      AppMethodBeat.o(247921);
      return true;
    }
    AppMethodBeat.o(247921);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveCacheInfo$LiveDecryptionWrapper;", "", "key", "", "haveDecrypt", "", "decryptString", "", "havePlay", "(IZLjava/lang/String;Z)V", "getDecryptString", "()Ljava/lang/String;", "setDecryptString", "(Ljava/lang/String;)V", "getHaveDecrypt", "()Z", "setHaveDecrypt", "(Z)V", "getHavePlay", "setHavePlay", "getKey", "()I", "setKey", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "reset", "", "toString", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    int key;
    boolean mMF;
    String mMG;
    boolean mMH;
    
    public a()
    {
      this(0, null, false, 15);
    }
    
    public a(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
    {
      AppMethodBeat.i(247953);
      this.key = paramInt;
      this.mMF = paramBoolean1;
      this.mMG = paramString;
      this.mMH = paramBoolean2;
      AppMethodBeat.o(247953);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(247988);
      if (this == paramObject)
      {
        AppMethodBeat.o(247988);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(247988);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.key != paramObject.key)
      {
        AppMethodBeat.o(247988);
        return false;
      }
      if (this.mMF != paramObject.mMF)
      {
        AppMethodBeat.o(247988);
        return false;
      }
      if (!s.p(this.mMG, paramObject.mMG))
      {
        AppMethodBeat.o(247988);
        return false;
      }
      if (this.mMH != paramObject.mMH)
      {
        AppMethodBeat.o(247988);
        return false;
      }
      AppMethodBeat.o(247988);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(247972);
      String str = "key:" + this.key + ",haveDecrypt:" + this.mMF + ",decryptString:" + this.mMG + ",havePlay:" + this.mMH;
      AppMethodBeat.o(247972);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.b
 * JD-Core Version:    0.7.0.1
 */