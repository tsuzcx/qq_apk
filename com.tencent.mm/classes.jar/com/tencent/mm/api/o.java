package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import java.util.ArrayList;

public abstract interface o
  extends a
{
  public abstract void a(Intent paramIntent, eve parameve, int paramInt);
  
  public abstract void a(Intent paramIntent, evg paramevg, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean hO(String paramString);
  
  public abstract ArrayList<String> hP(String paramString);
  
  public abstract boolean hQ(String paramString);
  
  public abstract String hR(String paramString);
  
  public abstract String hS(String paramString);
  
  public abstract void hT(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.o
 * JD-Core Version:    0.7.0.1
 */