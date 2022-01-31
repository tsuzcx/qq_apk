package com.tencent.liteav.audio.impl.Play;

class d$a
  extends Thread
{
  volatile boolean b = false;
  
  public d$a(d paramd, String paramString)
  {
    super(paramString);
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void b()
  {
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.d.a
 * JD-Core Version:    0.7.0.1
 */