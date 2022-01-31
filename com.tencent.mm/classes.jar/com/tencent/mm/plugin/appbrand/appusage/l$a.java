package com.tencent.mm.plugin.appbrand.appusage;

public enum l$a
{
  int blr;
  
  private l$a(int paramInt)
  {
    this.blr = paramInt;
  }
  
  public static a kx(int paramInt)
  {
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.blr == paramInt) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l.a
 * JD-Core Version:    0.7.0.1
 */