package com.tencent.mm.plugin.ipcall.a.e;

public class a
{
  public boolean bSr = false;
  
  protected void bcI() {}
  
  public final void finish()
  {
    if (this.bSr)
    {
      bcI();
      this.bSr = false;
    }
  }
  
  public void reset() {}
  
  public void start()
  {
    reset();
    this.bSr = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.e.a
 * JD-Core Version:    0.7.0.1
 */