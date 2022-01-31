package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;

public abstract class q
{
  public static q.b buU;
  public q.a buT;
  
  public abstract void a(m paramm);
  
  public void a(q.a parama)
  {
    this.buT = parama;
  }
  
  public abstract b ax(Context paramContext);
  
  public abstract void onDestroy();
  
  public abstract boolean rG();
  
  public abstract n rH();
  
  public void rI() {}
  
  public static final class a$a
  {
    public q.c buV;
    public boolean buW;
    public boolean buY = true;
    public Rect buZ;
    public String path;
    
    public final q.a sh()
    {
      return new q.a(this.path, this.buV, this.buW, this.buY, this.buZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.api.q
 * JD-Core Version:    0.7.0.1
 */