package com.tencent.mm.plugin.m.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.tabbar.AppBrandTabBarItem;
import com.tencent.mm.plugin.appbrand.widget.tabbar.a.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.b;
import com.tencent.mm.plugin.appbrand.widget.tabbar.c;
import com.tencent.mm.plugin.appbrand.widget.tabbar.d;
import com.tencent.mm.plugin.appbrand.widget.tabbar.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public class a
  extends com.tencent.mm.plugin.appbrand.widget.tabbar.a
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(View paramView, a.a parama)
  {
    int j = 0;
    AppMethodBeat.i(108235);
    final ImageView localImageView1 = (ImageView)paramView.findViewById(2131300874);
    TextView localTextView1 = (TextView)paramView.findViewById(2131297064);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131303918);
    TextView localTextView2 = (TextView)paramView.findViewById(2131305710);
    View localView = paramView.findViewById(2131301001);
    int i;
    if ("top".equals(this.mOS))
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 40), 1.0F));
      localImageView1.setVisibility(8);
      localTextView2.setTextSize(1, 14.0F);
      if (parama.mPn)
      {
        localView.setBackgroundColor(this.mOU);
        localView.setVisibility(0);
        paramView = localTextView1.getBackground();
        if (paramView != null) {
          paramView.setColorFilter(parama.mPq, PorterDuff.Mode.SRC_ATOP);
        }
        if (!parama.mPp.isEmpty()) {
          break label512;
        }
        i = 4;
        label164:
        localTextView1.setVisibility(i);
        localTextView1.setText(parama.mPp);
        localTextView1.setTextColor(parama.mPr);
        if (!parama.mPo) {
          break label517;
        }
        i = j;
        label198:
        localImageView2.setVisibility(i);
        if ((!parama.mPn) || (parama.mPm.bBK() == null)) {
          break label522;
        }
        parama.mPm.a(new e()
        {
          public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
          {
            AppMethodBeat.i(108232);
            super.a(paramAnonymousBitmap, paramAnonymousd);
            a.a(a.this, paramAnonymousBitmap, localImageView1);
            AppMethodBeat.o(108232);
          }
        });
        parama.mPl.bBJ();
      }
    }
    for (;;)
    {
      localTextView2.setText(parama.mText);
      if (!parama.mPn) {
        break label549;
      }
      localTextView2.setTextColor(this.mOU);
      AppMethodBeat.o(108235);
      return;
      localView.setVisibility(4);
      break;
      if (parama.mPl.bBK() != null) {
        if (parama.mText != null)
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 54), 1.0F));
          localImageView1.setVisibility(0);
          localImageView1.getLayoutParams().width = com.tencent.mm.cc.a.fromDPToPix(getContext(), 32);
          localImageView1.getLayoutParams().height = com.tencent.mm.cc.a.fromDPToPix(getContext(), 28);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 12.0F);
        }
      }
      for (;;)
      {
        localView.setVisibility(4);
        break;
        paramView.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 48), 1.0F));
        localImageView1.setVisibility(0);
        localImageView1.getLayoutParams().width = com.tencent.mm.cc.a.fromDPToPix(getContext(), 36);
        localImageView1.getLayoutParams().height = com.tencent.mm.cc.a.fromDPToPix(getContext(), 36);
        localTextView2.setVisibility(8);
        continue;
        if (parama.mText != null)
        {
          paramView.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 49), 1.0F));
          localImageView1.setVisibility(8);
          localTextView2.setVisibility(0);
          localTextView2.setTextSize(1, 16.0F);
        }
      }
      label512:
      i = 0;
      break label164;
      label517:
      i = 4;
      break label198;
      label522:
      parama.mPl.a(new e()
      {
        public final void a(Bitmap paramAnonymousBitmap, d paramAnonymousd)
        {
          AppMethodBeat.i(108233);
          super.a(paramAnonymousBitmap, paramAnonymousd);
          a.b(a.this, paramAnonymousBitmap, localImageView1);
          AppMethodBeat.o(108233);
        }
      });
      parama.mPl.bBJ();
    }
    label549:
    localTextView2.setTextColor(this.mOT);
    AppMethodBeat.o(108235);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, AppBrandTabBarItem paramAppBrandTabBarItem)
  {
    AppMethodBeat.i(209477);
    paramAppBrandTabBarItem = new a.a();
    paramAppBrandTabBarItem.mPm = new b(paramString4, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(108229);
        super.a(paramAnonymousString, paramAnonymousd);
        ac.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(108229);
      }
    });
    paramAppBrandTabBarItem.mPl = new b(paramString3, new c()
    {
      public final void a(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(108230);
        super.a(paramAnonymousString, paramAnonymousd);
        ac.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(paramAnonymousString)));
        AppMethodBeat.o(108230);
      }
    });
    paramAppBrandTabBarItem.mText = paramString2;
    paramAppBrandTabBarItem.mUrl = paramString1;
    this.mOW.add(new Pair(paramAppBrandTabBarItem.mPl, paramAppBrandTabBarItem.mPm));
    if ((paramAppBrandTabBarItem.mText == null) && ((paramAppBrandTabBarItem.mPl.bBK() == null) || (paramAppBrandTabBarItem.mPm.bBK() == null)))
    {
      ac.e("MicroMsg.AppBrandPageTabBarNV", "illegal data");
      AppMethodBeat.o(209477);
      return;
    }
    paramString1 = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131494993, this.mOR, false);
    a(paramString1, paramAppBrandTabBarItem);
    paramString1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108231);
        int i = a.a(a.this).indexOfChild(paramAnonymousView);
        a.this.ws(i);
        a.b(a.this);
        AppMethodBeat.o(108231);
      }
    });
    this.mOV.add(paramAppBrandTabBarItem);
    this.mOR.addView(paramString1);
    AppMethodBeat.o(209477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.d.a
 * JD-Core Version:    0.7.0.1
 */