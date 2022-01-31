package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnm;
import java.util.ArrayList;

public abstract interface i
  extends a
{
  public abstract void a(Intent paramIntent, bnk parambnk, int paramInt);
  
  public abstract void a(Intent paramIntent, bnm parambnm, int paramInt);
  
  public abstract boolean ca(String paramString);
  
  public abstract ArrayList<String> cb(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.i
 * JD-Core Version:    0.7.0.1
 */