package com.tencent.mm.plugin.datareport.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.datareport.c.a;
import com.tencent.mm.plugin.datareport.c.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.c.i;

public class SampleUI
  extends MMActivity
  implements View.OnClickListener
{
  private LinearLayout xhU;
  private Button xhV;
  private Button xhW;
  private Button xhX;
  private Button xhY;
  
  public int getLayoutId()
  {
    return c.b.xgo;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(262961);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/datareport/sample/SampleUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (paramView == this.xhV)
    {
      localObject = new HashMap();
      ((Map)localObject).put("visible_item", "6");
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("dr_click1", paramView, (Map)localObject, 24184);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/datareport/sample/SampleUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(262961);
      return;
      if (paramView == this.xhW)
      {
        ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).I(this, new Intent());
      }
      else if (paramView == this.xhX)
      {
        localObject = new HashMap();
        ((Map)localObject).put("btn3_custom_params", "btn3_custom_params");
        ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("btn3_click", paramView, (Map)localObject, 24184);
      }
      else if (paramView == this.xhY)
      {
        localObject = new HashMap();
        ((Map)localObject).put("btn4_custom_params", "btn4_custom_params");
        ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("btn4_click", paramView, (Map)localObject, 24184);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262942);
    super.onCreate(paramBundle);
    setMMTitle("数据上报SDK示例页面");
    setBackBtn(new SampleUI.1(this));
    this.xhU = ((LinearLayout)$(c.a.xgn));
    this.xhV = ((Button)$(c.a.xgi));
    this.xhW = ((Button)$(c.a.xgj));
    this.xhX = ((Button)$(c.a.xgk));
    this.xhY = ((Button)$(c.a.xgl));
    this.xhV.setOnClickListener(this);
    this.xhW.setOnClickListener(this);
    this.xhX.setOnClickListener(SampleUI..ExternalSyntheticLambda0.INSTANCE);
    this.xhY.setOnClickListener(new SampleUI.2(this));
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eB(this);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgp);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).h(this, "888888");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).d(this, "nickname", "菲灵小仙子");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).d(this, "signture", "记录点点滴滴！感谢有你，希望遇见下一个你");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).d(this, "finder_username", "v2_060000231003b20faec8c5ea8c1dc6d7ce02e930b0779d6ecdd67f6e73fe2f48401eb2aef3bf@finder");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new com.tencent.mm.plugin.datareport.a.c.a()
    {
      public final Map<String, Object> getDynamicParams(String paramAnonymousString)
      {
        AppMethodBeat.i(262930);
        HashMap localHashMap = new HashMap();
        if (i.qA(paramAnonymousString, "page_in")) {
          localHashMap.put("sampleui_dynamicparams", "页面动态参数");
        }
        AppMethodBeat.o(262930);
        return localHashMap;
      }
    });
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).dtq();
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).B("channel_id", "1-1-20-2cf48b5d7ab34f5b8ffb59e72530e948");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).B("session_id", "143_1628342664409#$2_1628342663385#");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eD(this.xhU);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eD(this.xhV);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eD(this.xhW);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eD(this.xhX);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eD(this.xhY);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(this.xhU, "sample_wrapper");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(this.xhV, "sample_btn1");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(this.xhW, "sample_btn2");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(this.xhX, "sample_btn3");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).i(this.xhY, "sample_btn4");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhV, "text", "关注");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhV, "color", "红色");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhW, "text", "点赞");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhW, "color", "黄色");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhX, "text", "评论");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhX, "color", "白色");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhY, "text", "转发");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).e(this.xhY, "color", "灰色");
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this.xhV, new com.tencent.mm.plugin.datareport.a.c.a()
    {
      public final Map<String, Object> getDynamicParams(String paramAnonymousString)
      {
        AppMethodBeat.i(262927);
        HashMap localHashMap = new HashMap();
        if (i.qA(paramAnonymousString, "dr_click1")) {
          localHashMap.put("btn1_dynamicparams", "控件动态参数");
        }
        AppMethodBeat.o(262927);
        return localHashMap;
      }
    });
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this.xhW, new com.tencent.mm.plugin.datareport.a.c.a()
    {
      public final Map<String, Object> getDynamicParams(String paramAnonymousString)
      {
        AppMethodBeat.i(262916);
        HashMap localHashMap = new HashMap();
        if (i.qA(paramAnonymousString, "btn2_click")) {
          localHashMap.put("btn2_dynamicparams", "控件动态参数");
        }
        AppMethodBeat.o(262916);
        return localHashMap;
      }
    });
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this.xhX, new com.tencent.mm.plugin.datareport.a.c.a()
    {
      public final Map<String, Object> getDynamicParams(String paramAnonymousString)
      {
        AppMethodBeat.i(262911);
        HashMap localHashMap = new HashMap();
        if (i.qA(paramAnonymousString, "btn3_click")) {
          localHashMap.put("btn3_dynamicparams", "控件动态参数");
        }
        AppMethodBeat.o(262911);
        return localHashMap;
      }
    });
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this.xhY, new com.tencent.mm.plugin.datareport.a.c.a()
    {
      public final Map<String, Object> getDynamicParams(String paramAnonymousString)
      {
        AppMethodBeat.i(262921);
        HashMap localHashMap = new HashMap();
        if (i.qA(paramAnonymousString, "btn4_click")) {
          localHashMap.put("btn4_dynamicparams", "控件动态参数");
        }
        AppMethodBeat.o(262921);
        return localHashMap;
      }
    });
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(this.xhV, 40, 24184);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(this.xhW, 40, 24184);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(this.xhX, 40, 24184);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).f(this.xhY, 40, 24184);
    AppMethodBeat.o(262942);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.sample.SampleUI
 * JD-Core Version:    0.7.0.1
 */