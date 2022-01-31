package com.tencent.mm.ah;

import com.tencent.mm.ck.f;
import com.tencent.mm.ck.g;
import com.tencent.mm.protocal.c.bly;
import junit.framework.Assert;

public class a<_Resp extends bly>
{
  public b dmK;
  a.b<_Resp> ect = new a.b(this);
  private f<a<_Resp>> ecu;
  
  public f<a<_Resp>> Km()
  {
    try
    {
      Assert.assertNotNull("You should set a CommReqResp!", this.dmK);
      Assert.assertTrue("RunCgi NetSceneQueue not ready!", w.Lo());
      if (this.ecu == null) {
        this.ecu = g.c(new a.1(this));
      }
      f localf = this.ecu;
      return localf;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, m paramm) {}
  
  public final void a(b paramb)
  {
    this.dmK = paramb;
  }
  
  public static class a<T extends bly>
  {
    public String aox;
    public m bJk;
    public T ecw;
    public a ecx;
    public int errCode;
    public int errType;
    
    public static <T extends bly> a<T> a(int paramInt1, int paramInt2, String paramString, T paramT, m paramm, a parama)
    {
      a locala = new a();
      locala.errType = paramInt1;
      locala.errCode = paramInt2;
      locala.aox = paramString;
      locala.ecw = paramT;
      locala.bJk = paramm;
      locala.ecx = parama;
      if (parama != null) {
        parama.a(paramInt1, paramInt2, paramString, paramT, paramm);
      }
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ah.a
 * JD-Core Version:    0.7.0.1
 */