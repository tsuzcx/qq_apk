package com.bumptech.glide.load.b;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

public abstract class j
{
  public static final j aGZ = new j()
  {
    public final boolean a(a paramAnonymousa)
    {
      return paramAnonymousa == a.aEH;
    }
    
    public final boolean a(boolean paramAnonymousBoolean, a paramAnonymousa, c paramAnonymousc)
    {
      return (paramAnonymousa != a.aEJ) && (paramAnonymousa != a.aEK);
    }
    
    public final boolean oP()
    {
      return true;
    }
    
    public final boolean oQ()
    {
      return true;
    }
  };
  public static final j aHa = new j()
  {
    public final boolean a(a paramAnonymousa)
    {
      return false;
    }
    
    public final boolean a(boolean paramAnonymousBoolean, a paramAnonymousa, c paramAnonymousc)
    {
      return false;
    }
    
    public final boolean oP()
    {
      return false;
    }
    
    public final boolean oQ()
    {
      return false;
    }
  };
  public static final j aHb = new j()
  {
    public final boolean a(a paramAnonymousa)
    {
      return (paramAnonymousa != a.aEI) && (paramAnonymousa != a.aEK);
    }
    
    public final boolean a(boolean paramAnonymousBoolean, a paramAnonymousa, c paramAnonymousc)
    {
      return false;
    }
    
    public final boolean oP()
    {
      return false;
    }
    
    public final boolean oQ()
    {
      return true;
    }
  };
  public static final j aHc = new j()
  {
    public final boolean a(a paramAnonymousa)
    {
      return false;
    }
    
    public final boolean a(boolean paramAnonymousBoolean, a paramAnonymousa, c paramAnonymousc)
    {
      return (paramAnonymousa != a.aEJ) && (paramAnonymousa != a.aEK);
    }
    
    public final boolean oP()
    {
      return true;
    }
    
    public final boolean oQ()
    {
      return false;
    }
  };
  public static final j aHd = new j()
  {
    public final boolean a(a paramAnonymousa)
    {
      return paramAnonymousa == a.aEH;
    }
    
    public final boolean a(boolean paramAnonymousBoolean, a paramAnonymousa, c paramAnonymousc)
    {
      return ((paramAnonymousBoolean) && (paramAnonymousa == a.aEI)) || ((paramAnonymousa == a.aEG) && (paramAnonymousc == c.aER));
    }
    
    public final boolean oP()
    {
      return true;
    }
    
    public final boolean oQ()
    {
      return true;
    }
  };
  
  public abstract boolean a(a parama);
  
  public abstract boolean a(boolean paramBoolean, a parama, c paramc);
  
  public abstract boolean oP();
  
  public abstract boolean oQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.j
 * JD-Core Version:    0.7.0.1
 */