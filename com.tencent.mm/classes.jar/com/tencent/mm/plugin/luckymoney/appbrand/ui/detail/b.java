package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dsf;
import java.util.List;

public abstract interface b
  extends com.tencent.mm.plugin.luckymoney.appbrand.ui.b
{
  public abstract void a(dgq paramdgq);
  
  public abstract void a(dsf paramdsf);
  
  public abstract void aD(Intent paramIntent);
  
  public abstract void fR(List<cih> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b
 * JD-Core Version:    0.7.0.1
 */