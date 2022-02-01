package com.tencent.matrix.resource.processor;

import android.os.Build.VERSION;
import com.tencent.matrix.resource.CanaryWorkerService;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.analyzer.model.d;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.c.a.a;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
{
  private static volatile boolean fcr = false;
  private final com.tencent.matrix.resource.f.b eZq;
  private com.tencent.matrix.resource.c.b fbr;
  private com.tencent.matrix.resource.c.a fcp;
  private a.a fcq;
  
  public b(com.tencent.matrix.resource.f.b paramb)
  {
    this.eZq = paramb;
  }
  
  public static boolean azg()
  {
    return fcr;
  }
  
  protected static com.tencent.matrix.resource.analyzer.model.a g(File paramFile, String paramString)
  {
    fcr = true;
    Object localObject = ((com.tencent.matrix.resource.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.resource.c.class)).eZp.fbg;
    localObject = com.tencent.matrix.resource.analyzer.model.c.n(Build.VERSION.SDK_INT, (String)localObject).azh();
    try
    {
      paramFile = new com.tencent.matrix.resource.analyzer.model.g(paramFile);
      paramString = new com.tencent.matrix.resource.analyzer.a(paramString, (d)localObject);
      paramFile = paramString.a(paramFile, paramString.eZr);
      com.tencent.matrix.resource.f.b.azx();
      fcr = false;
      return paramFile;
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramFile = com.tencent.matrix.resource.analyzer.model.a.a(paramFile, 0L);
      }
    }
  }
  
  protected final void a(int paramInt, a.b paramb, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    com.tencent.matrix.report.g localg = new com.tencent.matrix.report.g(paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dump_mode", paramb.name());
      localJSONObject.put("activity", paramString1);
      localJSONObject.put("ref_key", paramString2);
      localJSONObject.put("leak_detail", paramString3);
      localJSONObject.put("cost_millis", paramString4);
      localg.eYz = localJSONObject;
      this.eZq.fcO.onDetectIssue(localg);
      return;
    }
    catch (JSONException paramb)
    {
      for (;;)
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.LeakProcessor.Base", paramb, "", new Object[0]);
      }
    }
  }
  
  public abstract boolean a(DestroyedActivityInfo paramDestroyedActivityInfo);
  
  public final com.tencent.matrix.resource.c.b azr()
  {
    if (this.fbr == null) {
      this.fbr = new com.tencent.matrix.resource.c.b(this.eZq.mContext);
    }
    return this.fbr;
  }
  
  public final com.tencent.matrix.resource.c.a azs()
  {
    if (this.fcp == null) {
      this.fcp = new com.tencent.matrix.resource.c.a(this.eZq.mContext, azr());
    }
    return this.fcp;
  }
  
  protected final a.a azt()
  {
    if (this.fcq == null) {
      this.fcq = new a.a()
      {
        public final void a(com.tencent.matrix.resource.analyzer.model.f paramAnonymousf)
        {
          CanaryWorkerService.a(b.a(b.this).mContext, paramAnonymousf);
        }
      };
    }
    return this.fcq;
  }
  
  public final com.tencent.matrix.resource.f.b azu()
  {
    return this.eZq;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.b
 * JD-Core Version:    0.7.0.1
 */