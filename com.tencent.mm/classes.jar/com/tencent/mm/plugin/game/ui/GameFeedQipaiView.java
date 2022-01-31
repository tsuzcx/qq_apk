package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.cx;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFeedQipaiView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView haW;
  private TextView lbq;
  private ImageView lbr;
  private LinearLayout lbt;
  private ac lbu;
  
  public GameFeedQipaiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    if (this.lbu == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.getId() != g.e.more_etc_tv) {
            break;
          }
        } while (bk.bl(this.lbu.kTr.kTQ));
        i = c.an(getContext(), this.lbu.kTr.kTQ);
        b.a(getContext(), 10, 1023, 999, i, null, GameIndexListView.getSourceScene(), a.fy(this.lbu.kSs));
        return;
        i = ((Integer)paramView.getTag()).intValue();
      } while ((i < 0) || (i > this.lbu.kTr.kSr.size() - 1));
      paramView = (am)this.lbu.kTr.kSr.get(i);
    } while (bk.bl(paramView.kRP));
    int j = c.an(getContext(), paramView.kRP);
    b.a(getContext(), 10, 1023, i + 1, j, paramView.euK, GameIndexListView.getSourceScene(), a.fy(this.lbu.kSs));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.haW = ((TextView)findViewById(g.e.title));
    this.lbq = ((TextView)findViewById(g.e.more_etc_tv));
    this.lbr = ((ImageView)findViewById(g.e.more_arrow));
    this.lbt = ((LinearLayout)findViewById(g.e.game_item_container));
    this.lbq.setOnClickListener(this);
  }
  
  public void setData(com.tencent.mm.plugin.game.model.e parame)
  {
    if ((parame == null) || (parame.kOu == null) || (parame.kOu.kTr == null)) {
      setVisibility(8);
    }
    label342:
    label363:
    do
    {
      return;
      ac localac = parame.kOu;
      setVisibility(0);
      this.lbu = localac;
      if (!bk.bl(localac.kTr.bGw))
      {
        this.haW.setText(localac.kTr.bGw);
        this.haW.setVisibility(0);
        if (bk.bl(localac.kTr.kTx)) {
          break label342;
        }
        this.lbr.setVisibility(0);
        this.lbq.setVisibility(0);
        this.lbq.setText(localac.kTr.kTx);
      }
      for (;;)
      {
        this.lbt.removeAllViews();
        if (bk.dk(localac.kTr.kSr)) {
          break label363;
        }
        Iterator localIterator = localac.kTr.kSr.iterator();
        while (localIterator.hasNext())
        {
          am localam = (am)localIterator.next();
          Object localObject = LayoutInflater.from(getContext()).inflate(g.f.game_center_4_block_recom_item, this, false);
          ((View)localObject).setOnClickListener(this);
          ((View)localObject).setTag(Integer.valueOf(localac.kTr.kSr.indexOf(localam)));
          this.lbt.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 1.0F));
          TextView localTextView1 = (TextView)((View)localObject).findViewById(g.e.recom_item_title);
          ImageView localImageView = (ImageView)((View)localObject).findViewById(g.e.recom_item_img);
          TextView localTextView2 = (TextView)((View)localObject).findViewById(g.e.recom_item_name);
          localObject = (TextView)((View)localObject).findViewById(g.e.recom_item_desc);
          localTextView1.setVisibility(8);
          com.tencent.mm.plugin.game.f.e.baw().g(localImageView, localam.kTM);
          localTextView2.setText(localam.bGw);
          ((TextView)localObject).setText(localam.kRN);
        }
        this.haW.setVisibility(8);
        break;
        this.lbq.setVisibility(8);
        this.lbr.setVisibility(8);
      }
    } while (parame.kOw);
    a.a(getContext(), 10, 1023, parame.position, parame.kOu.euK, GameIndexListView.getSourceScene(), a.fy(parame.kOu.kSs));
    parame.kOw = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedQipaiView
 * JD-Core Version:    0.7.0.1
 */