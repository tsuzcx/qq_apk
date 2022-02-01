package com.b.a;

import android.content.Context;
import android.os.Environment;
import com.b.a.a.c;
import com.b.a.a.f;
import com.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class f$a
{
  public File cAK;
  public c cAL;
  public com.b.a.a.a cAM;
  public com.b.a.c.b cAN;
  public com.b.a.b.b cAO;
  
  public f$a(Context paramContext)
  {
    AppMethodBeat.i(183569);
    this.cAN = new com.b.a.c.a(paramContext);
    Object localObject2 = null;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localObject2 = paramContext.getExternalCacheDir();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getCacheDir();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new File("/data/data/" + paramContext.getPackageName() + "/cache/");
    }
    this.cAK = new File((File)localObject2, "video-cache");
    this.cAM = new g(536870912L);
    this.cAL = new f();
    this.cAO = new com.b.a.b.a();
    AppMethodBeat.o(183569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.b.a.f.a
 * JD-Core Version:    0.7.0.1
 */