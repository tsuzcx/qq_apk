package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.mm.bv.a;
import com.tencent.mm.ck.c;

public final class u
{
  private static SparseArray<u.a> mdk = new SparseArray();
  private static c<t> mdl;
  
  public static <T extends a> void a(int paramInt, s<T> params)
  {
    try
    {
      u.a locala2 = (u.a)mdk.get(paramInt);
      u.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new u.a((byte)0);
        mdk.put(paramInt, locala1);
      }
      locala1.aj(params);
      return;
    }
    finally {}
  }
  
  public static void a(s params)
  {
    try
    {
      u.a locala = (u.a)mdk.get(5);
      if (locala != null)
      {
        locala.remove(params);
        if (locala.size() == 0) {
          mdk.remove(5);
        }
      }
      return;
    }
    finally {}
  }
  
  public static <T extends a> void b(int paramInt, T paramT)
  {
    try
    {
      u.a locala = (u.a)mdk.get(paramInt);
      if (locala != null) {
        locala.e(paramT);
      }
      return;
    }
    finally {}
  }
  
  public static final void b(c<t> paramc)
  {
    mdl = paramc;
  }
  
  public static final c<t> bhQ()
  {
    return mdl;
  }
  
  public static <T extends a> void h(T paramT)
  {
    try
    {
      u.a locala = (u.a)mdk.get(5);
      if (locala != null) {
        locala.f(paramT);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.u
 * JD-Core Version:    0.7.0.1
 */