package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import java.util.LinkedList;

public final class c
  extends b
{
  private final String hDB;
  private AuthorizeItemListView jiY;
  private c.b jiZ;
  private LinearLayout jja;
  private final String mAppName;
  private Context mContext;
  
  public c(Context paramContext, LinkedList<c.c> paramLinkedList, String paramString1, String paramString2, c.a parama)
  {
    super(paramContext, (byte)0);
    AppMethodBeat.i(102357);
    this.mContext = paramContext;
    this.mAppName = bo.nullAsNil(paramString1);
    this.hDB = paramString2;
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      paramContext = new IllegalArgumentException("scopeInfoList is empty or null");
      AppMethodBeat.o(102357);
      throw paramContext;
    }
    paramContext = (ViewGroup)LayoutInflater.from(this.mContext).inflate(2130968662, null);
    setContentView(paramContext);
    paramString1 = (ImageView)paramContext.findViewById(2131821155);
    com.tencent.mm.modelappbrand.a.b.acD().a(paramString1, this.hDB, 2130839617, f.fqU);
    ((TextView)paramContext.findViewById(2131821156)).setText(this.mContext.getString(2131301119, new Object[] { this.mAppName }));
    this.jiY = ((AuthorizeItemListView)paramContext.findViewById(2131821158));
    this.jiZ = new c.b(paramLinkedList);
    this.jiY.setAdapter(this.jiZ);
    if (paramLinkedList.size() > 5)
    {
      this.jiY.ZY = paramLinkedList.size();
      this.jja = ((LinearLayout)paramContext.findViewById(2131821157));
      paramString1 = (LinearLayout.LayoutParams)this.jja.getLayoutParams();
      paramString1.height = this.mContext.getResources().getDimensionPixelSize(2131428498);
      this.jja.setLayoutParams(paramString1);
    }
    ((Button)paramContext.findViewById(2131821161)).setOnClickListener(new c.1(this, paramLinkedList, parama, this));
    ((Button)paramContext.findViewById(2131821160)).setOnClickListener(new c.2(this, paramLinkedList, parama, this));
    setCanceledOnTouchOutside(false);
    setOnCancelListener(new c.3(this, parama));
    AppMethodBeat.o(102357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.c
 * JD-Core Version:    0.7.0.1
 */