package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView
  extends BaseSortView
{
  private ListView fry;
  private String ido;
  private boolean idu;
  private int idv = -1;
  private EnterpriseBizContactListView.b idw;
  private EnterpriseBizContactListView.a idx;
  private int idy = 0;
  private int idz = 0;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    ArrayList localArrayList = new ArrayList();
    z.My();
    Cursor localCursor = com.tencent.mm.ai.e.C(this.ido, this.idu);
    while (localCursor.moveToNext())
    {
      jt localjt = new jt();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new ad();
        ((ad)localObject).d(localCursor);
        com.tencent.mm.ai.d locald = new com.tencent.mm.ai.d();
        locald.d(localCursor);
        localjt.userName = ((ao)localObject).field_username;
        localjt.dnp = ((ad)localObject);
        localjt.mVy = locald;
      }
      if (localjt.dnp != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localjt;
        if (localjt.mVy.LA()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).vem = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localjt.dnp.Bl())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).vem = "!2";
          }
          else
          {
            int j = localjt.dnp.AE();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).vem = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).vem = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    this.idv = localArrayList.size();
    Collections.sort(localArrayList, new d((byte)0));
    return localArrayList;
  }
  
  public static void release()
  {
    z.MI().Ms();
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    if ((!bk.bl(paramString)) && (paramd != null))
    {
      Object localObject = (jt)paramd.data;
      if (localObject == null) {
        return false;
      }
      paramd = ((jt)localObject).dnp.Bq();
      String str = ((jt)localObject).dnp.vn();
      localObject = ((jt)localObject).dnp.vo();
      paramString = paramString.toUpperCase();
      if (((!bk.bl(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bk.bl(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bk.bl((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString)))) {
        return true;
      }
    }
    return false;
  }
  
  public final void axD()
  {
    setOnItemClickListener(new EnterpriseBizContactListView.1(this));
    if (getMode() == 0) {
      setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (EnterpriseBizContactListView.a(EnterpriseBizContactListView.this) == null) {
            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, new EnterpriseBizContactListView.a(EnterpriseBizContactListView.this));
          }
          EnterpriseBizContactListView.a locala = EnterpriseBizContactListView.a(EnterpriseBizContactListView.this);
          int i = EnterpriseBizContactListView.b(EnterpriseBizContactListView.this);
          int j = EnterpriseBizContactListView.c(EnterpriseBizContactListView.this);
          if (locala.idC == null)
          {
            localObject = (EnterpriseBizContactListView)locala.idD.get();
            if (localObject == null) {
              return false;
            }
            locala.idC = new com.tencent.mm.ui.widget.e(((EnterpriseBizContactListView)localObject).getContext());
          }
          Object localObject = paramAnonymousView.getTag();
          if ((localObject == null) || (!(localObject instanceof EnterpriseBizContactListView.c))) {
            return false;
          }
          locala.idB = ((EnterpriseBizContactListView.c)localObject).username;
          if ((bk.bl(locala.idB)) || (f.eW(locala.idB))) {
            return false;
          }
          locala.idC.wof = paramAnonymousView;
          locala.idC.a(paramAnonymousAdapterView, paramAnonymousInt, paramAnonymousLong, new EnterpriseBizContactListView.a.1(locala, paramAnonymousInt), new EnterpriseBizContactListView.a.2(locala), i, j);
          return true;
        }
      });
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.idy = ((int)paramMotionEvent.getRawX());
      this.idz = ((int)paramMotionEvent.getRawY());
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getContactCount()
  {
    return this.idv;
  }
  
  public c.a getItemViewCreator()
  {
    return new EnterpriseBizContactListView.3(this);
  }
  
  public ListView getListView()
  {
    this.fry = ((ListView)findViewById(b.d.listview));
    return this.fry;
  }
  
  public View getNoResultView()
  {
    TextView localTextView = (TextView)findViewById(b.d.no_result);
    localTextView.setText(b.h.enterprise_no_sub_biz);
    return localTextView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    return (VerticalScrollBar)findViewById(b.d.sidrbar);
  }
  
  public final View inflate()
  {
    return View.inflate(getContext(), b.e.enterprise_biz_list_view_sort, this);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.idw != null) {
      this.idw.axC();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final void refresh()
  {
    dM(getSortEntityList());
    super.refresh();
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.idu = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.ido = paramString;
  }
  
  public void setOnTouchListener(EnterpriseBizContactListView.b paramb)
  {
    this.idw = paramb;
  }
  
  private final class d
    implements Comparator<com.tencent.mm.ui.base.sortview.d>
  {
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView
 * JD-Core Version:    0.7.0.1
 */