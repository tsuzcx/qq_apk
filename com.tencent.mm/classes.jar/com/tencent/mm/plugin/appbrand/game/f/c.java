package com.tencent.mm.plugin.appbrand.game.f;

public abstract class c
  implements Runnable
{
  e<c> gdp;
  
  public abstract void execute();
  
  public void run()
  {
    execute();
    if (this.gdp != null) {
      this.gdp.D(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.c
 * JD-Core Version:    0.7.0.1
 */