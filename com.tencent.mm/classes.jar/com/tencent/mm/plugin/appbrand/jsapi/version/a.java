package com.tencent.mm.plugin.appbrand.jsapi.version;

public enum a
{
  public final String gCF;
  
  private a(String paramString)
  {
    this.gCF = paramString;
  }
  
  public static a uE(String paramString)
  {
    a[] arrayOfa = values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.gCF.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    throw new IllegalArgumentException(String.format("Invalid name %s", new Object[] { paramString }));
  }
  
  public final String toString()
  {
    return this.gCF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.a
 * JD-Core Version:    0.7.0.1
 */